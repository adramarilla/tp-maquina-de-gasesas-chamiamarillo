package ar.edu.unahur.obj2;

public class ConStock extends Estado {

    public ConStock(Maquina maquina) {
        super(maquina);
    }

    @Override
    public void ingresarDinero(double dinero) {
        maquinaGaseosa.depositarDinero(dinero);
        // prueba
        System.out.println("Total del dinero abonado $" + maquinaGaseosa.getDineroEnMaquina());

    }

    @Override
    public void venderGaseosa(double dineroIngresado, double precio) {
        if(dineroIngresado < precio) {
            maquinaGaseosa.faltaDinero();
        } else {
            maquinaGaseosa.descontarVenta(precio);
            maquinaGaseosa.restarStock();
            System.out.println("Retirar bebida");
            maquinaGaseosa.verStock();
        }

    }
}
