package cl.duoc.s3tienda.modelo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa un producto del catálogo de la tienda.
 */
public class Producto {
    private final String id;
    private String nombre;
    private Categoria categoria;
    private BigDecimal precioBase;

    public Producto(String id, String nombre, Categoria categoria, BigDecimal precioBase) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id no puede ser vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre no puede ser vacío");
        if (categoria == null) throw new IllegalArgumentException("categoria no puede ser null");
        if (precioBase == null || precioBase.signum() < 0) throw new IllegalArgumentException("precioBase inválido");
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public BigDecimal getPrecioBase() { return precioBase; }
    public void setPrecioBase(BigDecimal precioBase) {
        if (precioBase == null || precioBase.signum() < 0) throw new IllegalArgumentException("precioBase inválido");
        this.precioBase = precioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id.equals(producto.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return nombre + " (" + categoria + ") $" + precioBase;
    }
}
