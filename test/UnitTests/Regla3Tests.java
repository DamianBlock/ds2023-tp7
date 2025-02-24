package UnitTests;

import dstp7.model.Regla3;
import dstp7.model.Venta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Regla3Tests {

    public Regla3Tests() {
        Repositorio.iniciar();
    }

    @Test
    public void siLlevaCincoUnidadesIgualesEnLacteosOVerdurasSeAplicaUnCincuentaPorcientoDeDescuentoDesdeLaSegundaHastaLaQuintaUnidad() {
        //Datos o definiciones
        Regla3 regla = new Regla3(Repositorio.getRubros()[1], Repositorio.getRubros()[2]);      // Traemos tanto el rubro de lacteos como de verdulería
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 5);
        venta.agregarDetalle(Repositorio.getProductos()[2], 5);

        //Ejecucion
        double descuento = regla.calcularDescuento(venta);


        //Comparación
        System.out.println("El descuento es : %" + descuento);
        assertEquals(30, descuento, 0);

    }

    @Test
    public void siLlevaUnaUnidadDeDiferentesProductoDeCualquierRubroNoTieneDescuento() {
        //Datos o definiciones
        Regla3 regla = new Regla3(Repositorio.getRubros()[0], Repositorio.getRubros()[1]);      // Traemos tanto el rubro de lacteos como de verdulería
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 1);
        venta.agregarDetalle(Repositorio.getProductos()[2], 1);

        //Ejecucion
        double descuento = regla.calcularDescuento(venta);


        //Comparación
        System.out.println("El descuento es : %" + descuento);
        assertEquals(0, descuento, 0);
    }
}


