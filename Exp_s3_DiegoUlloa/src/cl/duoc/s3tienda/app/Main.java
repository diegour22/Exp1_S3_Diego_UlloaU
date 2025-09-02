package cl.duoc.s3tienda.app;

import cl.duoc.s3tienda.modelo.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Crear productos de prueba
        Producto p1 = new Producto("P001", "Polera básica", Categoria.POLERAS, new BigDecimal("14990"));
        Producto p2 = new Producto("P002", "Pantalón jeans", Categoria.PANTALONES, new BigDecimal("29990"));

        // Crear pedido y agregar productos
        Pedido pedido = new Pedido("PED-1");
        pedido.agregarProducto(p1, 2);
        pedido.agregarProducto(p2, 1);

        // Mostrar subtotal sin descuentos
        System.out.println("Subtotal: $" + pedido.getSubtotal());

        // Probar Singleton DiscountManager
        DiscountManager a = DiscountManager.getInstance();
        DiscountManager b = DiscountManager.getInstance();
        System.out.println("¿Misma instancia DiscountManager? " + (a == b));
    }
}
