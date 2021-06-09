package com.example.newchatlayout;

public class ObjectoListView {

    private String number, mensaje, fecha, title;
    private int photo;

    public ObjectoListView(String title) {
        this.title = title;
    }

    public ObjectoListView(String number, String mensaje, String fecha, int photo) {
        this.number = number;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.photo = photo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
