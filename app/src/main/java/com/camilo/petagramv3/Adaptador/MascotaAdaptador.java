package com.camilo.petagramv3.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.camilo.petagramv3.Pojo.Mascota;
import com.camilo.petagramv3.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity){
        this.mascotas = mascotas;
    }

    //inflar el layout y lo pasara al view holder para que el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvContadorLikes.setText(String.valueOf(mascota.getLike()));


    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView tvNombreMascota;
        private TextView tvContadorLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota         = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascota    = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvContadorLikes    = (TextView) itemView.findViewById(R.id.tvContadorLikes);
        }
    }
}
