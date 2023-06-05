package main;

import game.Player;
import game.vehicles.*;
import java.util.*;
import java.io.*;

public class Main{
    public static Player loadPlayerFromFile(String playerName){
        
        File input = new File("users/" + playerName + ".txt");

        String[] data = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(input))){
            String line = bf.readLine();
            data = line.split(" ");

            return new Player(playerName, data[0], Integer.parseInt(data[1]));
        } catch (IOException e) {
            System.out.println("IO error occured: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        Player Daniel = loadPlayerFromFile("Daniel");
        Player Peter = loadPlayerFromFile("Peter");
        Player Richard = loadPlayerFromFile("Richard");
        Player Tamas = loadPlayerFromFile("Tamas");
        Player Zorror = loadPlayerFromFile("Zorror");

        Car Julikocsija = new Car(160, 800);
        Car Andreakocsi = new Car(180, 1000);
        Car Herby = new Car(20, 100);
        Car Gaborkocsi = new Car(200, 1000);
        Car Tomikocsi = new Car(180,1020);

        try{
            Daniel.buyCar(Julikocsija);
            Daniel.buyCar(Andreakocsi);
            Daniel.buyCar(Tomikocsi);
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        ArrayList<Car> danikocsik = new ArrayList<Car>();
        danikocsik = Daniel.getSortedCars();

        for (Car c : danikocsik)
        {
            System.out.println(c);
        }




    }
}
