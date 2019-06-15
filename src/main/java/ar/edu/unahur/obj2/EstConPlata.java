package ar.edu.unahur.obj2;

public class EstConPlata extends Estado {

    public EstConPlata(Maquina maquina) {
        super(maquina);
    }

    public void corroborarPlata(double dineroIngresado, double precio) {
        if(dineroIngresado < precio) {
            maquinaGaseosa.setEstado(new EstLista(maquinaGaseosa));
        }
    }

    // este metodo devolvera verdadero si esta sin stock y falso caso contrario
    public boolean corroborarStock() {

        if(maquinaGaseosa.getStock() < 1) {
            System.out.println("Unidad sin stock, se reintegra dinero");
            maquinaGaseosa.devolverDirenero();
            maquinaGaseosa.setEstado(new EstSinStock(maquinaGaseosa));
            return true;
        }
        return false;
    }


    @Override
    public void ingresarDinero(double dinero) {
        maquinaGaseosa.depositarDinero(dinero);
        // prueba
        System.out.println("Total del dinero abonado $" + maquinaGaseosa.getDineroEnMaquina());

    }
/*
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

 */

    @Override
    public void accionarPalanca(double dineroIngresado, double precio) {

        maquinaGaseosa.descontarDineroDepositado();
        maquinaGaseosa.restarStock();
        if(!corroborarStock()) {
            corroborarPlata(maquinaGaseosa.getDineroEnMaquina(), precio);
        }

    }

    @Override
    public void finTransaccion() {

        System.out.println("Su vuelto $ " + maquinaGaseosa.getDineroEnMaquina());
        maquinaGaseosa.devolverDirenero();
        maquinaGaseosa.setEstado(new EstLista(maquinaGaseosa));
    }
}
