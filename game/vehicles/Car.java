package game.vehicles;

import game.utils.VehicleException;


public class Car extends Vehicle implements Comperable<Car>{


    private final int maxSpeed;
    public final int price;
    public Boolean sold = false;
    
    public Car(int maxSpeed, int price)
    {
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    @Override
    public void accelerate(double change)
    {
            if (currentSpeed+change<=maxSpeed)
            {
                try
                {
                    accelerateCurrentSpeed(change);
                }
                catch (VehicleException e)
                {
                    System.out.println(e.getMessage());
                }
            }
    } 
    public String toString()
    {
        return id+" "+maxSpeed+" "+price;
    }

    @Override
    public Car compareTo(Car b)
    {
        Car a = this;
        if (a.maxSpeed == b.maxSpeed)
        {
            return a.price < b.price ? a : b;
        }
        return a.maxSpeed > b.maxSpeed ? a : b;
    }

    
}