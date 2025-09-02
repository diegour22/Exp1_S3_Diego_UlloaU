package cl.duoc.s3tienda.patrones;

import java.math.BigDecimal;

/**
 * Descuento simple por porcentaje (ej: 10%).
 */
public class DescuentoPorcentaje extends DescuentoDecorator {
    private final BigDecimal porcentaje; // ej: 0.10 para 10%

    public DescuentoPorcentaje(PrecioComponent componente, BigDecimal porcentaje) {
        super(componente);
        this.porcentaje = porcentaje;
    }

    @Override
    public BigDecimal calcularPrecio() {
        BigDecimal precioOriginal = super.calcularPrecio();
        return precioOriginal.subtract(precioOriginal.multiply(porcentaje));
    }
}
