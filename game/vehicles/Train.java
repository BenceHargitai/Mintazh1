package game.vehicles;

public class Train extends Vehicle{

    @Override
    public void accelerate(double change)
    {
        try{
            if (change<0)
                accelerateCurrentSpeed(change/10);

            else
                accelerateCurrentSpeed(change);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    
}