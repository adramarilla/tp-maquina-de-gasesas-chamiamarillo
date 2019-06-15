package ar.edu.unahur.obj2;

public abstract class Estado {

    protected Maquina maquinaGaseosa;

    public Estado(Maquina maquinaGaseosa) {
        this.maquinaGaseosa = maquinaGaseosa;
    }

    public abstract void ingresarDinero(double dinero);

    //public abstract void venderGaseosa(double dineroIngresado, double precio); // puede ser que este este mal

    public abstract void accionarPalanca(double dineroIngresado, double precio); // este cierra mas (ver hoja para lo que hay que implementar)

    public abstract void finTransaccion();



}
