package com.camilo.petagramv3.Pojo;

public class Mascota {
    private String nombre;
    private int like;
    private int foto;

    public Mascota (String nombre, int like, int foto){
        this.nombre = nombre;
        this.like = like;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}



