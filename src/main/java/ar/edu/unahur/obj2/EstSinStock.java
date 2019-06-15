package ar.edu.unahur.obj2;

public class EstSinStock extends Estado {

    public EstSinStock(Maquina maquina) {
        super(maquina);
    }

    @Override
    public void ingresarDinero(double dinero) {
        System.out.println("Unidad sin Stock, se devuelve el dinero");
        //maquinaGaseosa.devolverDirenero(); //esto esta mal aca acomodarlo donde va
    }


/* Este no va
    @Override
    public void venderGaseosa(double dineroIngresado, double precio) {
        System.out.println("Unidad sin Stock, se devuelve el dinero");
        maquinaGaseosa.devolverDirenero();
    }
*/

    @Override
    public void accionarPalanca(double dineroIngresado, double precio) {
        System.out.println("Unidad sin stock, Disculpe!!!");
    }

    @Override
    public void finTransaccion() {

        maquinaGaseosa.devolverDirenero();
        System.out.println("No se realizo compra - LA UNIDAD SE ENCUENTRA SIN STOCK!!!");
    }
}
