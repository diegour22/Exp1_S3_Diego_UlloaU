package cl.duoc.s3tienda.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoProductos {
    private final List<Producto> productos = new ArrayList<>();

    public CatalogoProductos() {
        productos.add(new Producto("P001", "Polera básica", Categoria.POLERAS, new BigDecimal("14990")));
        productos.add(new Producto("P002", "Pantalón jeans", Categoria.PANTALONES, new BigDecimal("29990")));
        productos.add(new Producto("P003", "Zapatillas urbanas", Categoria.ZAPATOS, new BigDecimal("49990")));
        productos.add(new Producto("P004", "Gorro", Categoria.ACCESORIOS, new BigDecimal("9990")));
    }

    public List<Producto> listar() { return Collections.unmodifiableList(productos); }

    public Producto buscarPorId(String id) {
        return productos.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}
