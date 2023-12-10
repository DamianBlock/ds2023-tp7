package dstp7.model;
public class ProductoDescuento {

    public ProductoDescuento(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    private Producto producto; // visibilidad por atributo a la clase Producto
    private int cantidad;

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio(){
        return producto.getPrecio();
    }

    public void sumarCantidad(int cantidad){
        this.cantidad += cantidad;

    }

    public boolean tieneProducto(Producto producto){
        return this.producto.equals(producto);
    }

    public boolean tieneCantidad(int cantidad){
        return this.cantidad == cantidad;
    }

    public boolean tieneCantidadEntre(int cantidad1, int cantidad2){
        return cantidad >= cantidad1 && cantidad <= cantidad2;
    }

    public boolean tieneCantidadMayorA(int cantidad){
        return this.cantidad > cantidad;
    }
}
