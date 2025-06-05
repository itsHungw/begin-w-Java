package data;

public class Statue extends Item{
    private int weight;
    private String color;

    public Statue() {
    }

    public Statue(String creator, int value, int weight, String color) {
        super(creator, value);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void input(){
        super.input();
        weight = Integer.parseInt(sc.nextLine());
        color = sc.nextLine();
    }

    @Override
    public void output(){
        super.output();
        System.out.println(+weight +" - " +color);
    }

    @Override
    public String toString() {
        return "Painting{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                ", value=" + value +
                ", creator='" + creator + '\'' +
                '}';
    }
}
