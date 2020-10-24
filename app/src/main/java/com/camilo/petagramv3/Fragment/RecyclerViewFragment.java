package com.camilo.petagramv3.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camilo.petagramv3.Adaptador.MascotaAdaptador;
import com.camilo.petagramv3.Pojo.Mascota;
import com.camilo.petagramv3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarDatos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarDatos(){
        mascotas = new ArrayList <> ();
        mascotas.add(new Mascota("Puppy",1,R.drawable.perro1));
        mascotas.add(new Mascota("Ragnar", 0,R.drawable.perro2));
        mascotas.add(new Mascota("Laika", 5,R.drawable.perro3));
        mascotas.add(new Mascota("Scooby", 3,R.drawable.perro4));
        mascotas.add(new Mascota("Rambo", 2, R.drawable.perro5));
        mascotas.add(new Mascota("Floky", 6,R.drawable.perro7));
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }
}