package cl.duoc.s3tienda.patrones;

import cl.duoc.s3tienda.modelo.Categoria;
import cl.duoc.s3tienda.modelo.Producto;

import java.math.BigDecimal;

/**
 * Descuento que aplica solo a productos de cierta categoría.
 */
public class DescuentoCategoria extends DescuentoDecorator {
    private final Categoria categoriaObjetivo;
    private final BigDecimal porcentaje;

    public DescuentoCategoria(PrecioComponent componente, Categoria categoriaObjetivo, BigDecimal porcentaje) {
        super(componente);
        this.categoriaObjetivo = categoriaObjetivo;
        this.porcentaje = porcentaje;
    }

    @Override
    public BigDecimal calcularPrecio() {
        if (componente instanceof ProductoBase base) {
            Producto prod = base.getProducto();
            if (prod.getCategoria() == categoriaObjetivo) {
                BigDecimal precioOriginal = super.calcularPrecio();
                return precioOriginal.subtract(precioOriginal.multiply(porcentaje));
            }
        }
        return super.calcularPrecio();
    }
}
