package cl.duoc.s3tienda.vista;

import cl.duoc.s3tienda.modelo.ItemPedido;
import cl.duoc.s3tienda.modelo.Pedido;
import java.util.List;

public class VistaCarrito {
    public void mostrar(Pedido pedido) {
        System.out.println("\n==== CARRITO (PEDIDO: " + pedido.getId() + ") ====");
        List<ItemPedido> items = pedido.getItems();
        if (items.isEmpty()) {
            System.out.println("(vacío)");
        } else {
            for (ItemPedido it : items) {
                System.out.println("- " + it.getProducto().getNombre() + " x" + it.getCantidad() +
                        " = $" + it.getSubtotalBruto());
            }
        }
        System.out.println("Subtotal actual: $" + pedido.getSubtotal());
    }
}
