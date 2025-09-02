package cl.duoc.s3tienda.patrones;

import cl.duoc.s3tienda.controlador.CarritoController;

/**
 * Command concreto: eliminar producto del carrito.
 */
public class EliminarProductoCommand implements Command {
    private final CarritoController carritoController;
    private final String productoId;

    public EliminarProductoCommand(CarritoController carritoController, String productoId) {
        this.carritoController = carritoController;
        this.productoId = productoId;
    }

    @Override
    public void ejecutar() {
        carritoController.eliminar(productoId);
    }
}
