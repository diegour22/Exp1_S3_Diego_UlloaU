package cl.duoc.s3tienda.modelo;

import java.math.BigDecimal;

/**
 * Singleton responsable de aplicar descuentos.
 */
public class DiscountManager {
    private DiscountManager() { }

    private static class Holder {
        private static final DiscountManager INSTANCE = new DiscountManager();
    }

    public static DiscountManager getInstance() {
        return Holder.INSTANCE;
    }

    public BigDecimal calcularPrecioFinal(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("producto es obligatorio");
        return producto.getPrecioBase();
    }

    public BigDecimal calcularTotalConDescuentos(Pedido pedido) {
        return pedido.getSubtotal();
    }
}
