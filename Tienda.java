package org.uniquindio.edu.co.poo.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tienda {
    private String nombre;
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Venta> listaVentas;

    public Tienda(String nombre, List<Cliente> listaClientes, List<Producto> listaProductos, List<Venta> listaVentas) {
        this.nombre = nombre;
        this.listaClientes = listaClientes != null ? listaClientes : new ArrayList<>();
        this.listaProductos = listaProductos != null ? listaProductos : new ArrayList<>();
        this.listaVentas = listaVentas != null ? listaVentas : new ArrayList<>();
    }

    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
    public List<Cliente> getListaClientes() {
        return listaClientes; }
    public List<Producto> getListaProductos() {
        return listaProductos; }
    public List<Venta> getListaVentas() {
        return listaVentas; }

    public String registrarCliente(String nombre, String identificacion, String telefono, String email, String direccion) {
        if (buscarCliente(identificacion) != null) {
            return "El Cliente ya está registrado";
        }
        Cliente nuevoCliente = new Cliente(nombre, identificacion, telefono, email, direccion);
        listaClientes.add(nuevoCliente);
        return "Cliente registrado con éxito";
    }

    private Cliente buscarCliente(String identificacionCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdentificacion().equals(identificacionCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public String actualizarCliente(String nombre, String identificacion, String direccion, String telefono, String email) {
        Cliente clienteEncontrado = buscarCliente(identificacion);
        if (clienteEncontrado == null) {
            return "Cliente no encontrado";
        }

        clienteEncontrado.setNombre(nombre);
        clienteEncontrado.setDireccion(direccion);
        clienteEncontrado.setTelefono(telefono);
        clienteEncontrado.setEmail(email);
        return "Cliente actualizado exitosamente";
    }

    public String eliminarCliente(String identificacion) {
        Cliente cliente = buscarCliente(identificacion);
        if (cliente == null) {
            return "No se encontró el cliente";
        }
        listaClientes.remove(cliente);
        return "Cliente eliminado exitosamente";
    }

    public String registrarProducto(Producto producto) {
        if (listaProductos.contains(producto)) {
            return "El producto ya existe.";
        }
        listaProductos.add(producto);
        return "Producto agregado correctamente.";
    }

    private Producto buscarProducto(String codigoProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigoProducto().equals(codigoProducto)) {
                return producto;
            }
        }
        return null;
    }

    public String actualizarProducto(String nombre, String codigoProducto, double precio, String categoria, int stockDisponible) {
        Producto productoEncontrado = buscarProducto(codigoProducto);
        if (productoEncontrado == null) {
            return "Producto no encontrado";
        }

        productoEncontrado.setNombre(nombre);
        productoEncontrado.setPrecio(precio);
        productoEncontrado.setCategoria(categoria);
        productoEncontrado.setStockDisponible(stockDisponible);
        return "Producto actualizado exitosamente";
    }

    public String eliminarProducto(String codigoProducto) {
        Producto producto = buscarProducto(codigoProducto);
        if (producto == null) {
            return "No se encontró el producto en la tienda";
        }
        listaProductos.remove(producto);
        return "Producto eliminado de la tienda";
    }

    public Venta realizarVenta(String identificacion, String codigoProducto, int cantidad) {
        Cliente cliente = buscarCliente(identificacion);
        Producto producto = buscarProducto(codigoProducto);

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return null;
        }
        if (producto == null) {
            System.out.println("Producto no encontrado");
            return null;
        }
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida");
            return null;
        }
        if (producto.getStockDisponible() < cantidad) {
            System.out.println("No hay suficiente stock disponible.");
            return null;
        }

        producto.setStockDisponible(producto.getStockDisponible() - cantidad);
        Venta nuevaVenta = new Venta(new Date(), cliente, producto, cantidad);
        listaVentas.add(nuevaVenta);
        System.out.println("Venta realizada con éxito: " + nuevaVenta);
        return nuevaVenta;
    }

    public void listaVentas() {
        if (listaVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        System.out.println("Lista de Ventas:");
        for (Venta venta : listaVentas) {
            System.out.println(venta);
        }
    }

    public Venta buscarVenta(String identificacion) {
        for (Venta venta : listaVentas) {
            if (venta.getCliente().getIdentificacion().equals(identificacion)) {
                return venta;
            }
        }
        return null;
    }

    public boolean actualizarVenta(String identificacion, String codigoProducto, int nuevaCantidad) {
        Venta venta = buscarVenta(identificacion);
        if (venta == null) {
            System.out.println("Venta no encontrada.");
            return false;
        }

        Producto producto = buscarProducto(codigoProducto);
        if (producto == null) {
            System.out.println("Nuevo producto no encontrado.");
            return false;
        }

        venta.setProducto(producto);
        venta.setCantidad(nuevaCantidad);
        venta.calcularMontoTotal();
        System.out.println("Venta actualizada con éxito: " + venta);
        return true;
    }

    public boolean eliminarVenta(String identificacion) {
        Venta venta = buscarVenta(identificacion);
        if (venta == null) {
            System.out.println("Venta no encontrada.");
            return false;
        }
        listaVentas.remove(venta);
        System.out.println("Venta eliminada con éxito.");
        return true;
    }
}







