package data;

import java.util.Random;

public class Cat extends Pet{

    public static double MAX_speed = 50;
    public Cat(String name, int yob, double weight) {
        super(name, yob, weight);
    }

    @Override
    public double run() {
        Random rd = new Random();
        double speed = rd.nextDouble() * Cat.MAX_speed;
        return speed ;
    }

    @Override
    public void showProfile() {
        System.out.println(name +" - " +yob +" - " +weight +" - " +String.format("%.2f",run()) +" km");
    }
}
