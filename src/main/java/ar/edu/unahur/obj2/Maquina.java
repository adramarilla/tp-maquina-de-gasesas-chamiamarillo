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
        estadoMaquina = new EstLista(this); // me costo mucho darme cuenta esta pequena parte
    }


    public void ingresarPlata(double dinero) {

        estadoMaquina.ingresarDinero(dinero);
    }

    /*
    public void venderGaseosa() {
        estadoMaquina.venderGaseosa(dineroEnMaquina, precio);
    }
    */


    public void stokearMaquina(int unidadGaseosa) {

        stock += unidadGaseosa;
        setEstado(new EstLista(this));
    }

    public void accionarPalanca() {
        estadoMaquina.accionarPalanca(dineroEnMaquina, precio);
    }

    public void finTransaccion() {
        estadoMaquina.finTransaccion();
    }

    /* este tampoco va aca
     pertenece a la accion de la alanca
    // que hacer si el dinero es insuficiente o no deposito dinero
    public void faltaDinero() {
        if(dineroEnMaquina == 0) {
            System.out.println("El valor de la Gaseosa es $" + precio);
        }
        if(dineroEnMaquina < precio) {
                System.out.println("Dinero Insuficiente, resta abonar $" + (precio - dineroEnMaquina));
        }
    }
     */


    // seterar los estados de la maquina
    public void setEstado(Estado estado) {
        this.estadoMaquina = estado;
    }

    /* no va porque manejo de otra forma lo del stock
    // sin stock de gaseosa
    public void verStock() {
        if(stock < 1) {
            setEstado(new EstSinStock(this));
        }
    }
     */
    // getter de lo que voy a usar o necesitar

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDineroEnMaquina() {
        return dineroEnMaquina;
    }

    public void setDineroEnMaquina(double dineroEnMaquina) {
        this.dineroEnMaquina = dineroEnMaquina;
    }

    public int getStock() {
        return stock;
    }


    // esta logica la usarn los estados

    public void descontarDineroDepositado() {
        this.dineroEnMaquina -= precio;
    }

    public void depositarDinero(double dinero) {
        this.dineroEnMaquina += dinero;
    }

    /*
    public void setDineroEnMaquina(double dineroEnMaquina) {
        this.dineroEnMaquina = dineroEnMaquina;
    }
    */

    void devolverDirenero() {
        this.setDineroEnMaquina(0.0);
    }

    public void restarStock() {
        stock--;
    }



}
