package dstp7.model;
public class LineaVenta {
      public LineaVenta(){}

      public LineaVenta(Producto producto, int cantidad){
            this.producto = producto;
            this.cantidad = cantidad;
            this.precio = producto.getPrecio();
      }

      private int cantidad;
      private Producto producto;  // visibilidad por atributo a la clase Producto
      private double precio;

      public boolean tieneRubro(Rubro rubro){
            return producto.tieneRubro(rubro);
      }

      public double subTotal(){
         return precio*cantidad;
      }

      public int getCantidad() {
            return cantidad;
      }

      public Producto getProducto() {
            return producto;
      }

      public double getPrecio() {
            return precio;
      }
}
