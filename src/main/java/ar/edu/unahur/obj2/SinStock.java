package ar.edu.unahur.obj2;

public class SinStock extends Estado {

    public SinStock(Maquina maquina) {
        super(maquina);
    }

    @Override
    public void ingresarDinero(double dinero) {
        System.out.println("Unidad sin Stock, se devuelve el dinero");
        maquinaGaseosa.devolverDirenero();
    }

    @Override
    public void venderGaseosa(double dineroIngresado, double precio) {
        System.out.println("Unidad sin Stock, se devuelve el dinero");
        maquinaGaseosa.devolverDirenero();
    }
}
