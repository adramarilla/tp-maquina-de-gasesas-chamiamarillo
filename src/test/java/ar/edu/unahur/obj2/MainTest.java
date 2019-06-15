package ar.edu.unahur.obj2;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testPruebaVueltoStockAccionPalanca() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.accionarPalanca();
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 15.0);
        Assert.assertEquals(maquinaCoke.getStock(), 2);
        maquinaCoke.accionarPalanca();
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 0.0);
        Assert.assertEquals(maquinaCoke.getStock(), 1);
    }


    @Test
    public void testPruebaSinStockyEntregaDineroDisponible() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.accionarPalanca();
        maquinaCoke.accionarPalanca();
        maquinaCoke.ingresarPlata(30.0);
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 30.0); // luego de tomar dos gaseosas como gordo cargue para tomar dos mas
        maquinaCoke.accionarPalanca();
        Assert.assertEquals(maquinaCoke.getStock(),0); // como la maquina esta sin stock devuelve lo que le quedo de dinero
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(),0.0);
    }




    @Test
    public void testPruebaStock2() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.accionarPalanca();
        maquinaCoke.accionarPalanca();
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.accionarPalanca();
        maquinaCoke.stokearMaquina(8);
        maquinaCoke.setPrecio(25.0); // modifico el precio de la gaseosa por la macrisi jejejejeje
        maquinaCoke.ingresarPlata(15.0); // iluso creo que estaba al mismo precio
        maquinaCoke.accionarPalanca();
        Assert.assertEquals(maquinaCoke.getStock(),8); // sigue teniendo el stock que se le cargo
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 15.0); // no desconto nada porque ahora la gaciosa esta mas cara
        maquinaCoke.ingresarPlata(15.0);
        maquinaCoke.accionarPalanca();
        Assert.assertEquals(maquinaCoke.getStock(), 7); // desconto porque se le adiciono plata
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 5.0);
        maquinaCoke.finTransaccion();
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 0.0); 

    }




}