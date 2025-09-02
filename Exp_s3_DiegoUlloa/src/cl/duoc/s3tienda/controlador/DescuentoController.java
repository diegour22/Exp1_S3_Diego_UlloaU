package cl.duoc.s3tienda.controlador;

import cl.duoc.s3tienda.modelo.Pedido;
import cl.duoc.s3tienda.vista.VistaDescuentos;

public class DescuentoController {
    private final Pedido pedido;
    private final VistaDescuentos vista;

    public DescuentoController(Pedido pedido, VistaDescuentos vista) {
        this.pedido = pedido;
        this.vista = vista;
    }

    public void calcularMostrar() {
        vista.mostrarTotalConDescuento(pedido);
    }
}
