package com.camilo.petagramv3.presentador;

import com.camilo.petagramv3.Pojo.Mascota;

import java.util.ArrayList;

public interface iRecyclerViewPresenter {
    public void obtenerMascotasBaseDatos();

    public void mostrarMascotasRV();

    Object crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(Object crearAdaptador);
}
