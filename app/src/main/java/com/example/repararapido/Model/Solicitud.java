package com.example.repararapido.Model;

public class Solicitud {

    private String EmpleadoID;
    private String EmpleadoNombre;
    private String EmpleadoCategoria;

    public Solicitud() {

    }

    public Solicitud(String empleadoID, String empleadoNombre, String empleadoCategoria) {
        EmpleadoID = empleadoID;
        EmpleadoNombre = empleadoNombre;
        EmpleadoCategoria = empleadoCategoria;
    }

    public String getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoID(String empleadoID) {
        EmpleadoID = empleadoID;
    }

    public String getEmpleadoNombre() {
        return EmpleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        EmpleadoNombre = empleadoNombre;
    }

    public String getEmpleadoCategoria() {
        return EmpleadoCategoria;
    }

    public void setEmpleadoCategoria(String empleadoCategoria) {
        EmpleadoCategoria = empleadoCategoria;
    }
}
