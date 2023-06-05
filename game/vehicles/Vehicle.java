package game.vehicles;

import game.utils.VehicleException;

public abstract class Vehicle{
    public static int counter = 0;
    protected final int id = counter++;
    protected double currentSpeed;


    public double getCurrentSpeed()
    {
        return currentSpeed;
    }

    protected final void accelerateCurrentSpeed(double change) throws VehicleException
    {
        if (currentSpeed+change < 0)
            throw new VehicleException("Speed cannot be negative");
        currentSpeed = currentSpeed+change;
    }
    public void accelerate(double change){}

}