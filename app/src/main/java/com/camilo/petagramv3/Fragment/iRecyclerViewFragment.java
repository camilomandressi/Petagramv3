package com.camilo.petagramv3.Fragment;

import com.camilo.petagramv3.Adaptador.MascotaAdaptador;
import com.camilo.petagramv3.Pojo.Mascota;

import java.util.ArrayList;

public interface iRecyclerViewFragment {
    public void generarGridLayout();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
