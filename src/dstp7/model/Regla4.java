package dstp7.model;
import java.util.ArrayList;
public class Regla4 implements IRegla{
        private static final double porcentaje = 0.1d;

    public Regla4(Rubro rubro1, Rubro rubro2, Rubro rubro3, Rubro rubro4) {             // agregamos al constructor todos los rubros
    }

    @Override
        public double calcularDescuento(Venta venta) {
        if (venta.calcularTotal() < 15000) return 0;

        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        for (LineaVenta detalle : venta.getDetalle()) {
            boolean existe = false;
            for (ProductoDescuento productoDescuento : productos) {
                if (productoDescuento.tieneProducto(detalle.getProducto())) {
                    existe = true;
                    productoDescuento.sumarCantidad(detalle.getCantidad());
                    break;
                }
            }
            if (!existe) {
                productos.add(new ProductoDescuento(detalle.getProducto(), detalle.getCantidad()));
            }
        }
        double total = 0;
        double totalAcumulado = total;
        for (ProductoDescuento productoDescuento : productos) {
            if (productoDescuento.tieneCantidadMayorA(3))

                descuento += productoDescuento.getPrecio() * productoDescuento.getCantidad() * porcentaje;  // Se calcula el descuento total aplicado en descuento
            total = productoDescuento.getPrecio() * productoDescuento.getCantidad();        // Se obtiene el total de la compra multilpicando precio por cantidad
                if(productoDescuento.tieneCantidadMayorA(3)) {
                    totalAcumulado = total + totalAcumulado;
                }
            System.out.println("El descuento para la compra acumulada de $" + totalAcumulado + " es de: $" + descuento );
            System.out.println("El descuento acumulado es: $" + descuento);
            System.out.println("El total por linea de venta es : $ " + total);
        }
        return (descuento * 100) / totalAcumulado ;       // aca modificamos para devolver el descuento aplicado en porcentaje, en este caso del %10.


    }
    }
