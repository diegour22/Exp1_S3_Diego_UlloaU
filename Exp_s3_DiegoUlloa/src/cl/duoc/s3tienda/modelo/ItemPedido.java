package cl.duoc.s3tienda.modelo;

import java.math.BigDecimal;

/**
 * Línea de pedido: producto + cantidad.
 */
public class ItemPedido {
    private final Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad) {
        if (producto == null) throw new IllegalArgumentException("producto es obligatorio");
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad debe ser > 0");
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad debe ser > 0");
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotalBruto() {
        return producto.getPrecioBase().multiply(BigDecimal.valueOf(cantidad));
    }
}
