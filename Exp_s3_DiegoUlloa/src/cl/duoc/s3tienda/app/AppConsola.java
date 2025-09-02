package cl.duoc.s3tienda.app;

import cl.duoc.s3tienda.controlador.*;
import cl.duoc.s3tienda.modelo.*;
import cl.duoc.s3tienda.vista.*;
import cl.duoc.s3tienda.patrones.Command;
import cl.duoc.s3tienda.patrones.AgregarProductoCommand;
import cl.duoc.s3tienda.patrones.EliminarProductoCommand;


import java.util.Scanner;

public class AppConsola {
    public static void main(String[] args) {
        var catalogo = new CatalogoProductos();
        var pedido = new Pedido("PED-1");

        var vistaProductos = new VistaProductos();
        var vistaCarrito = new VistaCarrito();
        var vistaDescuentos = new VistaDescuentos();

        var productoController = new ProductoController(catalogo, vistaProductos);
        var carritoController = new CarritoController(pedido, catalogo, vistaCarrito);
        var descuentoController = new DescuentoController(pedido, vistaDescuentos);

        Scanner sc = new Scanner(System.in);
        String op;
        do {
            System.out.println("\n==== MENÚ TIENDA ====");
            System.out.println("1) Listar productos");
            System.out.println("2) Agregar al carrito");
            System.out.println("3) Eliminar del carrito");
            System.out.println("4) Ver carrito");
            System.out.println("5) Ver total con descuentos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" -> productoController.listarProductos();
                case "2" -> {
                    System.out.print("ID producto: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Cantidad: ");
                    int cant;
                    try {
                        cant = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad inválida");
                        break;
                    }

                    // Aquí usamos el patrón Command
                    Command cmd = new AgregarProductoCommand(carritoController, id, cant);
                    cmd.ejecutar();
                }
                case "3" -> {
                    System.out.print("ID producto a eliminar: ");
                    String id = sc.nextLine().trim();

                    // Aquí usamos el patrón Command
                    Command cmd = new EliminarProductoCommand(carritoController, id);
                    cmd.ejecutar();
                }

                case "4" -> carritoController.mostrar();
                case "5" -> descuentoController.calcularMostrar();
                case "0" -> System.out.println("Adiós!");
                default -> System.out.println("Opción no válida");
            }
        } while (!op.equals("0"));
    }
}
