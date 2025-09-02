package cl.duoc.s3tienda.modelo;

import java.math.BigDecimal;
import java.util.*;

public class Pedido {
    private final String id;
    private final List<ItemPedido> items = new ArrayList<>();

    public Pedido(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id no puede ser vacío");
        this.id = id;
    }

    public String getId() { return id; }
    public List<ItemPedido> getItems() { return Collections.unmodifiableList(items); }

    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemPedido it : items) {
            if (it.getProducto().equals(producto)) {
                it.setCantidad(it.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemPedido(producto, cantidad));
    }

    public void eliminarProducto(String productoId) {
        items.removeIf(it -> it.getProducto().getId().equals(productoId));
    }

    public BigDecimal getSubtotal() {
        return items.stream()
                .map(ItemPedido::getSubtotalBruto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
