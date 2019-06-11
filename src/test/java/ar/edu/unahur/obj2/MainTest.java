package ar.edu.unahur.obj2;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testPruebaVuelto() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.venderGaseosa();
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 15.0);
    }

    @Test
    public void testPruebaStock() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.venderGaseosa();
        Assert.assertEquals(maquinaCoke.getStock(), 2);
    }

    // como me queda plata saco otra gaseosa compruebo el stok y el vuelto del dinero
    @Test
    public void testPruebaStock2() {
        Gaseosa coke = new Gaseosa(15.0);
        Maquina maquinaCoke = new Maquina(3, coke);
        maquinaCoke.ingresarPlata(30.0);
        maquinaCoke.venderGaseosa();
        Assert.assertEquals(maquinaCoke.getStock(), 2);
        maquinaCoke.venderGaseosa();
        Assert.assertEquals(maquinaCoke.getStock(), 1);
        Assert.assertEquals(maquinaCoke.getDineroEnMaquina(), 0.0);

    }


}