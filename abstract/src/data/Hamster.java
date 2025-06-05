package data;

import java.util.Random;

public class Hamster extends Pet {
    public static final double MAX_speed = 10;

    public Hamster(String name, int yob, double weight) {
        super(name, yob, weight);
    }

    @Override
    public double run() {
        Random rd = new Random();
        return rd.nextDouble() * Hamster.MAX_speed;
    }

    @Override
    public void showProfile() {
        System.out.println(name + " - " + yob + " - " + weight + " - " + String.format("%.2f",run()) +" km");
    }
}
