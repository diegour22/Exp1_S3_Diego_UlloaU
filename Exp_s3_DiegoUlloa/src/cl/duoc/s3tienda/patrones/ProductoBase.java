package cl.duoc.s3tienda.patrones;

import cl.duoc.s3tienda.modelo.Producto;

import java.math.BigDecimal;

/**
 * Clase concreta que implementa PrecioComponent.
 * Representa un producto con su precio base sin descuentos.
 */
public class ProductoBase implements PrecioComponent {
    private final Producto producto;

    public ProductoBase(Producto producto) {
        this.producto = producto;
    }

    @Override
    public BigDecimal calcularPrecio() {
        return producto.getPrecioBase();
    }

    public Producto getProducto() {
        return producto;
    }
}
