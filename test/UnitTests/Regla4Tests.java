package UnitTests;

import dstp7.model.Regla4;
import dstp7.model.Venta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Regla4Tests {

    public Regla4Tests() {
        Repositorio.iniciar();
    }

    @Test
    public void siLaCompraEsMenorAQuinceMilElDescuentoEsCero() {

        //Datos o definiciones
        Regla4 regla = new Regla4(Repositorio.getRubros()[0], Repositorio.getRubros()[1], Repositorio.getRubros()[2], Repositorio.getRubros()[3]);      // Traemos todos los rubros
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 300);     // 300 unidades de lacteos * $30 = $9000


        //Ejecucion
        double descuento = regla.calcularDescuento(venta);

        //Comparacion
        assertEquals(0, descuento, 0);
    }

    @Test
    public void siLaCompraEstaCercaDeQuinceMilElDescuentoEsCero() {  // Probando en valores límites, si la compra esta cerca a 15000 el descuento debe ser cero también

        //Datos o definiciones
        Regla4 regla = new Regla4(Repositorio.getRubros()[0], Repositorio.getRubros()[1], Repositorio.getRubros()[2], Repositorio.getRubros()[3]);      // Traemos todos los rubros
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 499);


        //Ejecucion
        double descuento = regla.calcularDescuento(venta);

        //Comparacion
        assertEquals(0, descuento, 0);
    }

    @Test
    public void siLaCompraEsMayorAQuinceMilYLlevaMasDeTresUnidadesIgualesSeAplicaUnDiezPorcientoDeDescuento() {

        //Datos o definiciones
        Regla4 regla = new Regla4(Repositorio.getRubros()[0], Repositorio.getRubros()[1], Repositorio.getRubros()[2], Repositorio.getRubros()[3]);      // Traemos todos los rubros
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 600);       // 00 unidades de lacteos * 30 = $18000
        venta.agregarDetalle(Repositorio.getProductos()[5], 200);       // 200 unidades de detergente x $15 = $3000


        //Ejecucion
        double descuento = regla.calcularDescuento(venta);

        //Comparacion
        assertEquals(10, descuento, 0);
    }

    @Test
    public void siLaCompraEsMayorAQuinceMilYLlevaMasDeTresUnidadesIgualesDeDiferentesRubrosSeAplicaUnDiezPorcientoDeDescuento() {

        //Datos o definiciones
        Regla4 regla = new Regla4(Repositorio.getRubros()[0], Repositorio.getRubros()[1], Repositorio.getRubros()[2], Repositorio.getRubros()[3]);      // Traemos todos los rubros
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 600);       // 00 unidades de lacteos * 30 = $18000
        venta.agregarDetalle(Repositorio.getProductos()[5], 200);       // 200 unidades de detergente x $15 = $3000


        //Ejecucion
        double descuento = regla.calcularDescuento(venta);

        //Comparacion
        assertEquals(10, descuento, 0);
    }

    @Test
    public void siLaCompraEsMayorAQuinceMilSeAplicaUnDiezPorcientoDeDescuentoAMayorDeTresUnidadesIguales() {

        //Datos o definiciones
        Regla4 regla = new Regla4(Repositorio.getRubros()[0], Repositorio.getRubros()[1], Repositorio.getRubros()[2], Repositorio.getRubros()[3]);      // Traemos todos los rubros
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 500);       // 500 unidades de lacteos * 30 = $15000
        venta.agregarDetalle(Repositorio.getProductos()[5], 200);       // 200 unidades de detergente x $15 = $3000
        venta.agregarDetalle(Repositorio.getProductos()[3], 100);       // 100 unidades de tomate * = $60 = $6000
        venta.agregarDetalle(Repositorio.getProductos()[4], 2);         // 2 unidades de Repollo * $80 = $160
        venta.agregarDetalle(Repositorio.getProductos()[2], 2);         // 2 unidades de Leche entera * $40 = $160

        //Ejecucion
        double descuento = regla.calcularDescuento(venta);

        //Comparacion
        assertEquals(10, descuento, 0);
    }
}

