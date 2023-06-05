package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import game.*;
import game.utils.VehicleException;
import game.vehicles.*;

import java.util.*;

public class Tests{

    @Test
    public void testPlayerConstructorNullName(){
        assertThrows(IllegalArgumentException.class, () -> new Player(null, "asd", 100));
    }

    @Test
    public void testNegativeVirtualMoney()
    {
        assertThrows(IllegalArgumentException.class, () -> new Player("asd", "asd", -100));
    }
    @Test
    public void testIpAdressWithWhitespace()
    {
        assertThrows(IllegalArgumentException.class, () -> new Player("asd", "asd asd", 100));
    }
    @Test
    public void testMoneyGood()
    {
        Player p = new Player("asd", "asd", 100);
        assertEquals(100, p.penz);
    }

    @Test
    public void testCarGoodPositive()
    {
        Car a = new Car(1000, 100);
        a.accelerate(10);
        assertEquals(10, a.getCurrentSpeed());
    }

    @Test
    public void testCarGoodNegative()
    {
        Car a = new Car(1000, 100);
        a.accelerate(40);
        a.accelerate(-20);
        assertEquals(20, a.getCurrentSpeed());
    }

    @Test
    public void testMaxSpeed()
    {
        Car a = new Car(40, 100);
        a.accelerate(20);
        a.accelerate(60);
        assertEquals(20, a.getCurrentSpeed());
    }
    
    @Test
    public void testZeroSpeed()
    {
        Car a = new Car(40, 100);
        a.accelerate(20);

        assertThrows(VehicleException.class, () -> a.accelerate(-30));

    }

    @Test
    public void testPlayerEquals()
    {
        Player a = new Player("asd", "asd", 100);
        Player b = new Player("asd", "dsa", 100);

        assertTrue(a.equals(b));
    }

    @Test
    public void testPlayerHash()
    {
        Player a = new Player("asd", "asd", 100);
        Player b = new Player("asd", "asd", 100);

        assertEquals(a.HashCode(), b.HashCode());
    }

    @Test
    public void testLopta()
    {
        Car a = new Car(40, 100);
        Player Joco = new Player("Joco", "asd", 100);
        Player Rafaello = new Player("Rafaello","azeletiskolaja",100);
        try{
            Joco.buyCar(a);
        }
        catch(VehicleException e)
        {
            System.out.println(e);
        }
        
        assertThrows(VehicleException.class, () -> Rafaello.buyCar(a));
    }

    @Test
    public void testKeves()
    {
        Car a = new Car(40, 1000);
        Player Joco = new Player("Joco", "asd", 100);

        assertThrows(VehicleException.class, () -> Joco.buyCar(a));
    }



    



}