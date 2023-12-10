package UnitTests;

import dstp7.model.Producto;
import dstp7.model.Rubro;

public class Repositorio {
    private static final Producto[] productos = new Producto[7];
    private static final Rubro[] rubros = new Rubro[4];

    public static void iniciar()
    {
        crearRubros();
        crearProductos();
    }
    
    public static Producto[] getProductos()
    {
        return productos;
    }
    public static Rubro[] getRubros() {return rubros;}
    
    private static void crearRubros(){
        rubros[0] = new Rubro(1, "Panaderia");
        rubros[1] = new Rubro(2, "Lacteos");
        rubros[2] = new Rubro(2, "Verduras");
        rubros[3] = new Rubro(2, "Limpieza");
       // rubros[4] = new Rubro(3, "Bebidas");
    }
    
    private static void crearProductos(){
        productos[0] = new Producto(1, "Tortilla", 50, rubros[0]);
        productos[1] = new Producto(2, "Yogur Entero", 30, rubros[1]);
        productos[2] = new Producto(3, "Leche Entera", 40, rubros[1]);
        productos[3] = new Producto(4, "Tomate", 60, rubros[2]);
        productos[4] = new Producto(5, "Repollo", 80, rubros[2]);
        productos[5] = new Producto(6, "Detergente", 15, rubros[3]);
        productos[6] = new Producto(7, "Pan Francés", 28, rubros[0]);
     //   productos[7] = new Producto(8, "Caja de Sidra", 4000, rubros[4]);
    }
}
