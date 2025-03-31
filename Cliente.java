package org.uniquindio.edu.co.poo.model;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;


    public Cliente (String nombre, String identificacion, String telefono, String email, String direccion  ){
        this.nombre= nombre;
        this.identificacion= identificacion;
        this.direccion= direccion;
        this.telefono= telefono;
        this.email= email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
                "Nombre: " + nombre + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Email: " + email;
    }

}
