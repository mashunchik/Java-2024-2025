package LAB6.src.gemstones;

public abstract class Gemstone {
    private String name;
    private double weight; // in carats
    private double price;  // per carat
    private double transparency; // 0.0 to 1.0

    public Gemstone(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTransparency() {
        return transparency;
    }

    public double getTotalPrice() {
        return weight * price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f carats, $%.2f per carat, transparency %.2f",
                name, weight, price, transparency);
    }
}