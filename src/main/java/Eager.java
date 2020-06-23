public class Eager {
    private String color;

    public Eager() {
        this("white");
    }

    public Eager(String color) {
        color = color;
    }

    public static void main(String[] args) {
        Eager e = new Eager();
        System.out.println("Color:" + e.color);
    }
}