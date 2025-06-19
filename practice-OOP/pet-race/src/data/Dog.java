package data;

import java.util.Random;

public class Dog extends Pet{
    public static final double MAX_speed = 40;

    public Dog(String name, int yob, double weight) {
        super(name, yob, weight);

    }
//using Random() to init random speed
    @Override
    public double run() {
        Random rd = new Random();
        double speed = rd.nextDouble() * Dog.MAX_speed;
        return speed;
    }

    @Override
    public void showProfile() {
        System.out.println(name +" - " +yob +" - " +weight +" - " + String.format("%.2f",run()) +" km");
    }
}
