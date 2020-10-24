package com.camilo.petagramv3;

import android.content.Intent;
import android.os.Bundle;

import com.camilo.petagramv3.Adaptador.PageAdapter;
import com.camilo.petagramv3.Fragment.PerfilFragment;
import com.camilo.petagramv3.Fragment.RecyclerViewFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.widget.Toolbar miActionBar = (android.widget.Toolbar) findViewById(R.id.miActionBar);

        miActionBar.inflateMenu(R.menu.menu_main);
        miActionBar.setOnMenuItemClickListener(new android.widget.Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.menuContacto)
                {
                    Intent intent2= new Intent(MainActivity.this, MenuContacto.class);
                    startActivity(intent2);
                    return true;
                }
                else if(item.getItemId()== R.id.menuAcerca)
                {
                    Intent intent3 = new Intent(MainActivity.this, MenuAcercaDe.class);
                    startActivity(intent3);
                    return true;
                }
                else{
                    // do something
                }

                return false;
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(MainActivity.this, MenuContacto.class);
                startActivity(intent2);
            }
        });

        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



    }

    private void setSupportActionBar(android.widget.Toolbar miActionBar) {
    }


    private ArrayList<Fragment> agregarFragments (){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casaperro);
        tabLayout.getTabAt(1).setIcon(R.drawable.perroicon);
    }


}