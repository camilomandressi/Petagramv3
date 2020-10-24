package com.camilo.petagramv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

public class MenuContacto extends AppCompatActivity {
    EditText nombre;
    EditText email;
    EditText password;
    EditText comentario;
    Button botonEnviar;
    EditText miemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.inflateMenu(R.menu.menu_main);

        miActionBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.menuContacto)
                {
                    Intent intent2= new Intent(MenuContacto.this, MenuContacto.class);
                    startActivity(intent2);
                    return true;
                }
                else if(item.getItemId()== R.id.menuAcerca)
                {
                    Intent intent3 = new Intent(MenuContacto.this, MenuAcercaDe.class);
                    startActivity(intent3);
                    return true;
                }
                else{
                    // do something
                }

                return false;
            }
        });
        nombre = (EditText) findViewById(R.id.tiNombre);
        email = (EditText) findViewById(R.id.tiEmail);
        password = (EditText) findViewById(R.id.tiPassword);
        comentario = (EditText) findViewById(R.id.tiComentario);
        miemail = (EditText) findViewById(R.id.tiMiEmail);


        botonEnviar = (Button) findViewById(R.id.btnEnviar);
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sender=miemail.getText().toString();
                String senderPass=password.getText().toString();
                String receiver=email.getText().toString();
                String title=nombre.getText().toString();
                String message=comentario.getText().toString();
                sendEmail(sender,senderPass,receiver,title,message);
            }
        });
    }

    private void sendEmail(final String Sender, final String Password, final String Receiver, final String Title, final String Message) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender(Sender,Password);
                    sender.sendMail(Title, "<b>"+Message+"</b>", Sender, Receiver);
                    makeAlert();

                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();
    }
    private void makeAlert(){
        this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(MenuContacto.this, "Mensaje Enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
