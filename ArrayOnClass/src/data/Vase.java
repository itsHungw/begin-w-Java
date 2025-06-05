package data;

public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {

    }

    public Vase(String creator, int value, int height, String material) {
        super(creator, value);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    @Override
    public void input(){
        super.input();

        height = Integer.parseInt(sc.nextLine());
        material = sc.nextLine();
    }

    @Override
    public void output(){
        super.output();
        System.out.println(height +" - " +material);
    }

    @Override
    public String toString() {
        return "Vase{" +
                "height=" + height +
                ", material='" + material + '\'' +
                ", creator='" + creator + '\'' +
                ", value=" + value +
                '}';
    }
}
