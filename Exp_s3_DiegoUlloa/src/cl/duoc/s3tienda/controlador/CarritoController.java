package cl.duoc.s3tienda.controlador;

import cl.duoc.s3tienda.modelo.CatalogoProductos;
import cl.duoc.s3tienda.modelo.Pedido;
import cl.duoc.s3tienda.modelo.Producto;
import cl.duoc.s3tienda.vista.VistaCarrito;

public class CarritoController {
    private final Pedido pedido;
    private final CatalogoProductos catalogo;
    private final VistaCarrito vistaCarrito;

    public CarritoController(Pedido pedido, CatalogoProductos catalogo, VistaCarrito vistaCarrito) {
        this.pedido = pedido;
        this.catalogo = catalogo;
        this.vistaCarrito = vistaCarrito;
    }

    public void agregar(String productoId, int cantidad) {
        Producto p = catalogo.buscarPorId(productoId);
        if (p == null) {
            System.out.println("Producto no encontrado: " + productoId);
            return;
        }
        pedido.agregarProducto(p, cantidad);
        vistaCarrito.mostrar(pedido);
    }

    public void eliminar(String productoId) {
        pedido.eliminarProducto(productoId);
        vistaCarrito.mostrar(pedido);
    }

    public void mostrar() {
        vistaCarrito.mostrar(pedido);
    }
}
