package UnitTests;

import dstp7.model.Regla2;
import dstp7.model.Venta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Regla2Tests {
    public Regla2Tests() {
        Repositorio.iniciar();
    }

    @Test
    public void siLaCompraEsMenorOIgualACincoMilNoHayDescuento() {

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 30);
        venta.agregarDetalle(Repositorio.getProductos()[1], 20);

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(0,descuento,0);

    }
    @Test
    public void siLaCompraEstaCercaACincoMilNoHayDescuento() {  // Se prueba también en valores límites

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 50);        // Precio de tortilla -> $50  => cantidad 50 * $50 = $2500
        venta.agregarDetalle(Repositorio.getProductos()[6], 89);        // Precio de Pan frances -> $28  => cantidad 89 * $28 =2492
                                                                                // dando un total de $4992 cercano a $5000

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(0,descuento,0);
        System.out.println("El descuento para 1 solo producto es : %" + descuento);
        System.out.println("El monto total de la venta es: $" + venta.calcularTotal() + "\n");

    }

    /*@Test
    public void siLaCompraEsMayorACincoMilYMenorOIgualADiezMilTieneUnDescuentoDelTresPorciento() {

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[2]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[4], 70);    // el precio del repollo es de $80 => 70 * $80 = $5600

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(30,descuento,0);

    } */

    @Test
    public void siLaCompraEsMayorACincoMilYMenorOIgualADiezMilTieneUnDescuentoDelTresPorciento() {

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 110);    // el precio de la tortilla es $50 => cantidad 110 * $50 = $5500

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        // assertEquals(3,descuento,0);
        assertEquals(3,descuento,0);

        System.out.println("El descuento para un importe mayor a $5000 y menor o igual a $10000 es : %" + descuento);
        System.out.println("El monto total de la venta es: $" + venta.calcularTotal() + "\n");

    }

    @Test
    public void siLaCompraEsMayorADiezMilYMenorOIgualAVeinticincoMilTieneUnDescuentoDelCincoPorciento() {

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[2]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[4], 200);    // el precio del repollo es de $80 => cantidad 200 * $80 = $16000

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(5,descuento,0);
        System.out.println("El descuento para un importe mayor a $10000 y menor o igual a $25000 es : %" + descuento);
        System.out.println("El monto total de la venta es: $" + venta.calcularTotal() + "\n");

    }

    @Test
    public void siLaCompraEsMayorAVeinticincoMilTieneUnDescuentoDelSeisComaCincoPorciento() {

        // Datos o definiciones
        Regla2 regla = new Regla2(Repositorio.getRubros()[2]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[4], 200);    // el precio del repollo es de $80 => cantidad 200 * $80 = $16000
        venta.agregarDetalle(Repositorio.getProductos()[3], 200);    // el precio del tomate es de $60 => cantidad 200 * $80 = $12000
                                                                             // el total de la compra es de $28000

        // Efejucion
        double descuento = regla.calcularDescuento(venta);

        // Comprobacion
        assertEquals(6.5,descuento,0);
        System.out.println("El descuento para un importe mayor a $25000 es : %" + descuento);
        System.out.println("El monto total de la venta es: $" + venta.calcularTotal() + "\n");

    }


}
