package cl.duoc.s3tienda.patrones;

import java.math.BigDecimal;

/**
 * Componente base del patrón Decorator.
 * Define la operación común: calcular el precio final.
 */
public interface PrecioComponent {
    BigDecimal calcularPrecio();
}
