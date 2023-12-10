package dstp7.model;






public class Regla2 implements IRegla {
    private static final double porcentajeMenor = 0.03d;
    private static final double porcentajeIntermedio = 0.05d;
    private static final double porcentajeMayor = 0.065d;
    private final Rubro rubro;

    public Regla2(Rubro rubro) { this.rubro = rubro;  }                        // faltó crear el constructor


    @Override
    public double calcularDescuento(Venta venta) {
        double total = venta.calcularTotal();

        if (total <= 5000) { return 0d;}


       // System.out.println("El monto total de la venta es: $" + venta.calcularTotal());
      //  System.out.println(total);

      else if (total <= 10000) {           // agregamos que el total también sea mayor o igual que 5000

            System.out.println("Monto total $" + total);
            double descuentoTotal = total * porcentajeMenor;
            System.out.println("Descuento realizado $" + descuentoTotal);
            // return porcentajeMenor *100;
            double totalConDescuento = total - descuentoTotal;
            System.out.println("Total con descuento aplicado $" + totalConDescuento + "\n");
            return (descuentoTotal * 100) / total ;

            }

       else{
            if (total <= 25000) {

                System.out.println("Monto total $" + total);
                double descuentoTotal = total * porcentajeIntermedio;
                System.out.println("Descuento realizado $" + descuentoTotal);
                double totalConDescuento = total - descuentoTotal;
                System.out.println("Total con descuento aplicado $" + totalConDescuento + "\n");
          //    return total * porcentajeIntermedio;
                return (descuentoTotal * 100) / total ;

            }
        }

        System.out.println("Monto total $" + total);
        double descuentoTotal = total * porcentajeMayor;
        System.out.println("Descuento realizado $" + descuentoTotal);
        double totalConDescuento = total - descuentoTotal;
        System.out.println("Total con descuento aplicado $" + totalConDescuento +"\n");
        // return total * porcentajeMayor;
        return (descuentoTotal * 100) / total ;

    }
}

