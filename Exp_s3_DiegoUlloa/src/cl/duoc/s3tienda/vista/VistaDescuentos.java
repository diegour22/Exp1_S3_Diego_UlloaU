package cl.duoc.s3tienda.vista;

import cl.duoc.s3tienda.modelo.Pedido;
import cl.duoc.s3tienda.modelo.DiscountManager;

public class VistaDescuentos {
    public void mostrarTotalConDescuento(Pedido pedido) {
        var total = DiscountManager.getInstance().calcularTotalConDescuentos(pedido);
        System.out.println("\n==== DESCUENTOS ====");
        System.out.println("Total con descuentos aplicados: $" + total);
    }
}
