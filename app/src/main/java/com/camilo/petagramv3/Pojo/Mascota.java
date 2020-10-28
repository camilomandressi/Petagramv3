package com.camilo.petagramv3.Pojo;

public class Mascota {
    private String nombre;
    private String like;
    private int foto;
    private int idMascota;

    public Mascota (String nombre, String like, int foto){
        this.nombre = nombre;
        this.like = like;
        this.foto = foto;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void addLikes(){
        int NolikesIncrement;
        NolikesIncrement = Integer.parseInt(String.valueOf(like));
        NolikesIncrement++;
        this.like = String.valueOf(NolikesIncrement);
    }
}



