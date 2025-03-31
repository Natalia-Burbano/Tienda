package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private Date fecha;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private double ventaTotal;

    public Venta(Date fecha, Cliente cliente, Producto producto,  int cantidad) {
        this.fecha = fecha;
        this.cliente= cliente;
        this.producto= producto;
        this.cantidad = cantidad;
        this.ventaTotal = producto.getPrecio()* cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getVentaTotal() {
        return ventaTotal;
    }

    public void setVentaTotal(double ventaTotal) {
        this.ventaTotal = ventaTotal;
    }

    public void calcularMontoTotal() {
        this.ventaTotal = this.producto.getPrecio() * this.cantidad;
    }

    public String toString() {
        return "Venta:\n" +
                "Fecha: " + fecha + "\n" +
                cliente + "\n" +  // Llama al toString() de Cliente
                producto + "\n" +  // Llama al toString() de Producto
                "Cantidad: " + cantidad + "\n" +
                "Venta Total: " + ventaTotal;
    }

}
