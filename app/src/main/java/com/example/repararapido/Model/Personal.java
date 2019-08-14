package com.example.repararapido.Model;

import android.widget.ProgressBar;

public class Personal {

    private String Name, Image, Descripcion, Experiencia, Horario, MenuId, Profesion, Email;

    public Personal() {
    }

    public Personal(String name, String image, String descripcion, String experiencia, String horario, String menuId, String profesion, String email) {
        Name = name;
        Image = image;
        Descripcion = descripcion;
        Experiencia = experiencia;
        Horario = horario;
        MenuId = menuId;
        Profesion = profesion;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String profesion) {
        Profesion = profesion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
