package com.piriz.proyectoJava.utlis;

public class ApiResponseMsg {
    private String mensaje;

    public ApiResponseMsg(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}