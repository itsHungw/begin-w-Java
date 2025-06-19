import data.Cat;
import data.Dog;
import data.Hamster;


public class Main {
    public static void main(String[] args) {
        race();
    }

    public static void race(){
        Dog d1 = new Dog("Spike", 2025, 5);
        Cat c1 = new Cat("Tom", 2023, 3);
        Hamster h1 = new Hamster("Jerry", 2025, 0.7);



        d1.showProfile();

        c1.showProfile();

        h1.showProfile();
    }
}