package ar.edu.unahur.obj2;

public class Maquina {

    private double precio;
    private double dineroEnMaquina;
    private int stock;
    private Gaseosa gaseosa;
    private Estado estadoMaquina;


    // todavia me cuesta ver en la sintaxis que me conviene que este en el constructor
    public Maquina(int stock, Gaseosa gaseosa1) {
        this.stock = stock;
        this.gaseosa = gaseosa1;
        this.precio = gaseosa1.getPrecio();
        estadoMaquina = new ConStock(this); // me costo mucho darme cuenta esta pequena parte
    }


    public void ingresarPlata(double dinero) {
        estadoMaquina.ingresarDinero(dinero);
    }

    public void venderGaseosa() {
        estadoMaquina.venderGaseosa(dineroEnMaquina, precio);
    }

    // que hacer si el dinero es insuficiente o no deposito dinero
    public void faltaDinero() {
        if(dineroEnMaquina == 0) {
            System.out.println("El valor de la Gaseosa es $" + precio);
        }
        if(dineroEnMaquina < precio) {
                System.out.println("Dinero Insuficiente, resta abonar $" + (precio - dineroEnMaquina));
        }
    }

    // seterar los estados de la maquina
    public void setEstado(Estado estado) {
        this.estadoMaquina = estado;
    }

    // sin stock de gaseosa
    public void verStock() {
        if(stock < 1) {
            setEstado(new SinStock(this));
        }
    }

    // trabajo con el dinero ingresado a la maquina y lo descuento por venta, muestro lo que entregue, devuelvo si no realizo accion
    public double getDineroEnMaquina() {
        return dineroEnMaquina;
    }

    public void descontarVenta(double dinero) {
        this.dineroEnMaquina -= dinero;
    }

    public void depositarDinero(double dinero) {
        this.dineroEnMaquina += dinero;
    }


    public void devolverDirenero() {
        dineroEnMaquina = 0;
    }

    // trabajo con el stock de gaseosas
    public int getStock() {
        return stock;
    }

    public void restarStock() {
        stock--;
    }

    /*
    Habia arrancado el ejercicio con una interface, luego me bloquier y decidi cambiar a una clase abstracta y
    tratar de enganchar los distintos puntos necesarios para armar la simulacion.
    Me quedo afuera el tema de la palanca que no supe nunca donde colocarla, como estoy medio peleado con la sintaxis
    se me ocurre que palanca deberia ser un comportamiento dentro de maquina pero ya estoy bloqueado y no se como seguir.
     */


}
