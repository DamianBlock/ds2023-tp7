/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import dstp7.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import  static  org.junit.jupiter.api.Assertions.*;

public class Regla1Tests  {
    
    public Regla1Tests() {
        Repositorio.iniciar();
    }


    @Test
    public void siNoHayProductosDePanaderiaElDescuentoEsCero(){
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);  // Rubro 0 pertenece al rubro de "Panaderìa" es correcto
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 2);  // Producto 1 pertenece al producto de "Yogur Entero" para esta prueba es vàlido
                                                                         // ya que necesitamos comprobar el descuento en el caso que lleve un articulo de un rubro
                                                                         // que no sea de "Panadería"

        //Ejecución
        double descuento = regla.calcularDescuento(venta);

        //Comprobación
        assertEquals (0, descuento, 0);
    }

    @Test
    public void llevandoDosProductosDePanaderiaElSegundoTieneDescuentoAlCincuentaPorCiento()


            /* Para este Test, al momento de ejecutarlo, si bien da como resultado que la prueba pasa correctamente, hay un error en la lògica aplicada,
            ya que que el resultado esperado en el método assertEquals es 50, figura como que deberìa ser 25, es decir la mitad. */

    {
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);  // Rubro 0 pertenece al rubro de "Panaderìa" es correcto
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 2);     // Producto 0 pertenece al producto de "Tortilla" es correcto
        
        //Ejecución
        double descuento = regla.calcularDescuento(venta);
        
        //Comprobación
        assertEquals (25, descuento, 0);  // el resultado esperado deberìa ser %50 de descuento, ya que es lo que se aplica a la segunda unidad
                                                        // del mismo rubro, y para este caso el resultado especificado es del %25 (incorrecto)

    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,10})
    public void llevandoTresOMasProductosDePanaderiaElSegundoYTerceroTieneDescuentoAlCincuentaPorCiento(int cantidades)
    {
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 3);

        //Ejecución
        double descuento = regla.calcularDescuento(venta);

        //Comprobación
        assertEquals (50, descuento, 0);



    }

    @Test                                                               // aplicamos un test adicional para comprobar que si solo se lleva 1 solo producto de Panadería
                                                                        // no se debe aplicar ningún descuento.
    public void siHayUnSoloProductoDePanaderiaElDescuentoEsCero() {

        // Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 1);

        // Ejecucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(0,descuento,0);
        System.out.println("El descuento para 1 solo producto es : %" + descuento);
        System.out.println("El monto total de la venta es: $" + venta.calcularTotal());

    }


}
