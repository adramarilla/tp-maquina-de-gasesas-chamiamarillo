package ar.edu.unahur.obj2;

public abstract class Estado {

    protected Maquina maquinaGaseosa;

    public Estado(Maquina maquinaGaseosa) {
        this.maquinaGaseosa = maquinaGaseosa;
    }

    public abstract void ingresarDinero(double dinero);
    public abstract void venderGaseosa(double dineroIngresado, double precio);

}
