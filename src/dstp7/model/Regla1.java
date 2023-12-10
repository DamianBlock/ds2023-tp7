package dstp7.model;
import java.util.ArrayList;
import java.util.Optional;

public class Regla1 implements IRegla{
    private static final double porcentaje = 0.5d;
    private final Rubro rubro;

    public Regla1(Rubro rubro){
        this.rubro = rubro;
    }
    @Override
    public double calcularDescuento(Venta venta)
    {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        if(venta == null) return descuento;
        for (LineaVenta detalle : venta.getDetalle()) {
            if (detalle.tieneRubro(rubro)) {
                Optional<ProductoDescuento> productoDescuento = productos
                        .stream()
                        .filter(p-> p.tieneProducto(detalle.getProducto()))
                        .findFirst();
                if(productoDescuento.isEmpty())
                   productos.add(new ProductoDescuento(detalle.getProducto(), detalle.getCantidad()));
                else
                   productoDescuento.get().sumarCantidad(detalle.getCantidad());
            }
        }
        for(ProductoDescuento productoDescuento : productos)
        {
            if (productoDescuento.tieneCantidad(2))
            {
                descuento += productoDescuento.getPrecio() * porcentaje;
            }
            else if (productoDescuento.tieneCantidad(3))
            {
                descuento += productoDescuento.getPrecio() * porcentaje * 2;
            }

          /*  else if (productoDescuento.tieneCantidad(4))
            {

            } */
        }
        return descuento;
    }
}

    

    

    

