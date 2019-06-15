package ar.edu.unahur.obj2;

public class EstLista extends Estado {

    public EstLista(Maquina maquinaGaseosa) {
        super(maquinaGaseosa);
    }

    @Override
    public void ingresarDinero(double dinero) {
        maquinaGaseosa.depositarDinero(dinero);

        // la maquina tiene el dinero y lo muestra
        System.out.println("Dinero depositado $" + maquinaGaseosa.getDineroEnMaquina());

        // verifico que esta bien
        if(maquinaGaseosa.getDineroEnMaquina() >= maquinaGaseosa.getPrecio()) {
            maquinaGaseosa.setEstado(new EstConPlata(maquinaGaseosa));
        }
    }

    @Override
    public void accionarPalanca(double dineroIngresado, double precio) {

        if(dineroIngresado == 0) {
            System.out.println("Valor de la Gaseosa $ " + precio);
        } else {
            if(dineroIngresado < precio) {
                System.out.println("Dinero Insuficiente, resta abonar $" + (precio - dineroIngresado));
            }
        }
    }

    @Override
    public void finTransaccion() {

        maquinaGaseosa.devolverDirenero();
        System.out.println("Todavia no se realizo compra alguna!!!");
    }
}
