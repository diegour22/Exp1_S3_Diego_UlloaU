package cl.duoc.s3tienda.vista;

import cl.duoc.s3tienda.modelo.Producto;
import java.util.List;

public class VistaProductos {
    public void mostrar(List<Producto> productos) {
        System.out.println("\n==== CATÁLOGO DE PRODUCTOS ====");
        for (Producto p : productos) {
            System.out.println(p.getId() + " - " + p.getNombre() +
                    " [" + p.getCategoria() + "] $" + p.getPrecioBase());
        }
    }
}
