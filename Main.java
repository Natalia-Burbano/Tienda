package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Cliente;
import org.uniquindio.edu.co.poo.model.Producto;
import org.uniquindio.edu.co.poo.model.Tienda;
import org.uniquindio.edu.co.poo.model.Venta;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Tienda Online", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Agregar clientes de prueba
        tienda.registrarCliente("María López", "12345", "+57 3101234567", "maria.lopez@email.com", "Cra 10");
        tienda.registrarCliente("Carlos Gómez", "123456", "+57 3202345678", "carlos.gomez@email.com", "Calle 50");
        tienda.registrarCliente("Andrea Pérez", "1234567", "+57 3003456789", "andrea.perez@email.com", "Av 42");

        // Agregar productos de prueba
        tienda.registrarProducto(new Producto("Arroz 1kg", "P001", 5.000, "Alimentos", 50));
        tienda.registrarProducto(new Producto("Leche 1L", "P002", 6.500, "Lácteos", 30));
        tienda.registrarProducto(new Producto("Pan Molde 500g", "P003", 8.000, "Panadería", 25));
        tienda.registrarProducto(new Producto("Detergente 1L", "P004", 12.000, "Limpieza", 40));
        tienda.registrarProducto(new Producto("Aceite Vegetal 900ml", "P005", 18.000, "Alimentos", 35));


        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    " Menú Tienda \n\n"
                            + "1. Registrar Cliente\n"
                            + "2. Registrar Producto\n"
                            + "3. Realizar Venta\n"
                            + "4. Lista de Ventas\n"
                            + "5. Buscar Venta\n"
                            + "6. Actualizar Venta\n"
                            + "7. Eliminar Venta\n"
                            + "8. Salir\n\n"
                            + "Seleccione una opción:");

            switch (opcion) {
                case "1":
                    registrarCliente(tienda);
                    break;
                case "2":
                    registrarProducto(tienda);
                    break;
                case "3":
                    realizarVenta(tienda);
                    break;
                case "4":
                    listaVentas(tienda);
                    break;
                case "5":
                    buscarVenta(tienda);
                    break;
                case "6":
                    actualizarVenta(tienda);
                    break;
                case "7":
                    eliminarVenta(tienda);
                    break;
                case "8":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar la Tienda Online");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void registrarCliente(Tienda tienda) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String email = JOptionPane.showInputDialog("Ingrese el correo:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");

        String mensaje = tienda.registrarCliente(nombre, identificacion, telefono, email, direccion);
        JOptionPane.showMessageDialog(null, mensaje);
    }


    private static void registrarProducto(Tienda tienda) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
        String categoria = JOptionPane.showInputDialog("Ingrese la categoría:");
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock:"));

        String mensaje = tienda.registrarProducto(new Producto(nombre, codigo, precio, categoria, stock));
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void realizarVenta(Tienda tienda) {
        String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));

        Venta venta = tienda.realizarVenta(idCliente, codigoProducto, cantidad);
        if (venta != null) {
            JOptionPane.showMessageDialog(null, " Venta realizada con éxito:\n" + venta);
        } else {
            JOptionPane.showMessageDialog(null, " No se pudo realizar la venta.");
        }
    }


    private static void listaVentas(Tienda tienda) {
        if (tienda.getListaVentas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas.");
        } else {
            StringBuilder ventasList = new StringBuilder(" Lista de Ventas:\n");
            for (Venta venta : tienda.getListaVentas()) {
                ventasList.append(venta).append("\n");
            }
            JOptionPane.showMessageDialog(null, ventasList.toString());
        }
    }


    private static void buscarVenta(Tienda tienda) {
        String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        Venta venta = tienda.buscarVenta(idCliente);

        if (venta != null) {
            JOptionPane.showMessageDialog(null, "Venta encontrada:\n" + venta);
        } else {
            JOptionPane.showMessageDialog(null, " No se ha encontrado una venta hecha por el cliente.");
        }
    }

    private static void actualizarVenta(Tienda tienda) {
        String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String nuevoProducto = JOptionPane.showInputDialog("Ingrese el nuevo código del producto:");
        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad:"));

        boolean actualizado = tienda.actualizarVenta(idCliente, nuevoProducto, nuevaCantidad);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, " Venta actualizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, " No se pudo actualizar la venta.");
        }
    }

    private static void eliminarVenta(Tienda tienda) {
        String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        boolean eliminado = tienda.eliminarVenta(idCliente);

        if (eliminado) {
            JOptionPane.showMessageDialog(null, " Venta eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, " No se pudo eliminar la venta.");
        }
    }
}

