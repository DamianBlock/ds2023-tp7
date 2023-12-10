package dstp7.model;
public class Producto {
    public Producto()
        {
            
        }
        public Producto(int codigo, String descripcion, double precio, Rubro rubro)
        {
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.rubro = rubro;
        }
        private int codigo;
        private String descripcion;
        private double precio;
        private Rubro rubro;         // visibilidad por atributo a la clase Rubro

    public boolean tieneRubro(Rubro rubro) {
        return this.rubro.equals(rubro);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    @Override
    public boolean equals(Object object){
        Producto producto = (Producto) object;
        return codigo == producto.codigo && descripcion == producto.descripcion;
    }
}
