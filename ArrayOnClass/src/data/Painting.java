package data;

public class Painting extends Item{
   private int height;
   private String width;
   private boolean isWatercolour;
    private boolean isFrame;

    public Painting() {
    }

    public Painting(String creator, int value, int height, String width, boolean isWatercolour, boolean isFrame) {
        super(creator, value);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFrame = isFrame;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public boolean isWatercolour() {
        return isWatercolour;
    }

    public void setWatercolour(boolean watercolour) {
        isWatercolour = watercolour;
    }

    public boolean isFrame() {
        return isFrame;
    }

    public void setFrame(boolean frame) {
        isFrame = frame;
    }

    @Override
    public void input() {
        super.input();
        height = Integer.parseInt(sc.nextLine());
        width = sc.nextLine();
        isWatercolour = sc.nextBoolean();
        isFrame = sc.nextBoolean();
    }

    @Override
    public void output(){
        super.output();
        System.out.println(height +" - " +width +" - " +isWatercolour +" - " +isFrame);
    }

    @Override
    public String toString() {
        return "Painting{" +
                "height=" + height +
                ", width='" + width + '\'' +
                ", isWatercolour=" + isWatercolour +
                ", isFrame=" + isFrame +
                ", value=" + value +
                ", creator='" + creator + '\'' +
                '}';
    }
}
