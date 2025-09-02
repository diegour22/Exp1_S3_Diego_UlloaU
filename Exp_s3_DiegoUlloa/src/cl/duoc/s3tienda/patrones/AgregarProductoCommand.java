package cl.duoc.s3tienda.patrones;

import cl.duoc.s3tienda.controlador.CarritoController;

/**
 * Command concreto: agregar producto al carrito.
 */
public class AgregarProductoCommand implements Command {
    private final CarritoController carritoController;
    private final String productoId;
    private final int cantidad;

    public AgregarProductoCommand(CarritoController carritoController, String productoId, int cantidad) {
        this.carritoController = carritoController;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() {
        carritoController.agregar(productoId, cantidad);
    }
}
