package org.uniquindio.edu.co.poo.model;

public class Producto {
    private String nombre;
    private String codigoProducto;
    private double precio;
    private String categoria;
    private int stockDisponible;

    public Producto (String nombre, String codigoProducto, double precio, String categoria, int stockDisponible){
        this.nombre= nombre;
        this.codigoProducto= codigoProducto;
        this.precio= precio;
        this.categoria= categoria;
        this.stockDisponible= stockDisponible;

    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    @Override
    public String toString() {
        return "Producto:\n" +
                "Nombre: " + nombre + "\n" +
                "Código: " + codigoProducto + "\n" +
                "Precio: " + precio + "\n" +
                "Categoría: " + categoria + "\n" +
                "Stock Disponible: " + stockDisponible;
    }
}
