package game;

import java.util.ArrayList;
import game.vehicles.*;
import game.utils.VehicleException;

public class Player{
    
    public String name;
    public String ipadress;
    public int penz;
    public ArrayList<Car> cars;

    public Player(String name, String ipadress, int penz)
    {
        if (name==null || ipadress.length() <= 0 || penz < 0)
            throw new IllegalArgumentException();


        this.name = name;
        this.ipadress = ipadress;
        this.penz = penz;
        this.cars = new ArrayList<Car>();
    }


    public Boolean equals(Player p)
    {
        return this.name==p.name && this.penz == p.penz && this.cars.equals(p.cars);
    }
    
    public int HashCode()
    {
        return name.hashCode() + ipadress.hashCode() + penz*31 + cars.hashCode();
    }

    public void buyCar(Car a) throws VehicleException
    {
        if (a.price <= penz && !a.sold && a!=null)
        {
            penz-=a.price;
            cars.add(a);
            a.sold = true;
        }
        else{
            throw new VehicleException("vagy nincs autod, penzed, vagy loptad! >:^(");
        }

    }
    public ArrayList<Car> getSortedCars()
    {
        ArrayList<Car> sorted = new ArrayList<Car>();
        for (Car c : cars)
        {
            sorted.add(c);
        }
        
        //sort them without using Collections.sort

        for (int i = 0; i < sorted.size(); i++)
        {
            for (int j = i+1; j < sorted.size(); j++)
            {
                if (sorted.get(i).compareTo(sorted.get(j)) == sorted.get(j))
                {
                    Car temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

}