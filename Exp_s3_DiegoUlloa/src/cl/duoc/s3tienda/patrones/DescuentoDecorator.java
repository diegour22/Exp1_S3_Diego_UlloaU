package cl.duoc.s3tienda.patrones;

import java.math.BigDecimal;

/**
 * Clase abstracta del patrón Decorator.
 * Envuelve un PrecioComponent para añadir descuentos.
 */
public abstract class DescuentoDecorator implements PrecioComponent {
    protected final PrecioComponent componente;

    public DescuentoDecorator(PrecioComponent componente) {
        this.componente = componente;
    }

    @Override
    public BigDecimal calcularPrecio() {
        return componente.calcularPrecio();
    }
}
