package cl.duoc.s3tienda.controlador;

import cl.duoc.s3tienda.modelo.CatalogoProductos;
import cl.duoc.s3tienda.vista.VistaProductos;

public class ProductoController {
    private final CatalogoProductos catalogo;
    private final VistaProductos vista;

    public ProductoController(CatalogoProductos catalogo, VistaProductos vista) {
        this.catalogo = catalogo;
        this.vista = vista;
    }

    public void listarProductos() {
        vista.mostrar(catalogo.listar());
    }
}
