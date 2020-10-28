package com.camilo.petagramv3.presentador;

import android.content.Context;

import com.camilo.petagramv3.Fragment.iRecyclerViewFragment;
import com.camilo.petagramv3.Pojo.Mascota;
import com.camilo.petagramv3.db.ConstructorMascotas;

import java.util.ArrayList;

public abstract class RecyclerViewPresenter implements iRecyclerViewPresenter {
    private iRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewPresenter (iRecyclerViewFragment iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarGridLayout();
    }

}
