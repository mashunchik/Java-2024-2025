package LAB5;

public abstract class Gemstone {
    private String name;
    private double weightInCarats;
    private double value;
    private double transparency;

    public Gemstone(String name, double weightInCarats, double value, double transparency) {
        this.name = name;
        this.weightInCarats = weightInCarats;
        this.value = value;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getWeightInCarats() {
        return weightInCarats;
    }

    public double getValue() {
        return value;
    }

    public double getTransparency() {
        return transparency;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s: Weight=%.2f carats, Value=%.2f, Transparency=%.2f%%",
                name, weightInCarats, value, transparency);
    }
}
