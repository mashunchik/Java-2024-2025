package LAB5;

public class PreciousGemstone extends Gemstone {
    public PreciousGemstone(String name, double weightInCarats, double value, double transparency) {
        super(name, weightInCarats, value, transparency);
    }

    @Override
    public String getType() {
        return "Precious";
    }
}

// Клас напівкоштовного каміння
class SemiPreciousGemstone extends Gemstone {
    public SemiPreciousGemstone(String name, double weightInCarats, double value, double transparency) {
        super(name, weightInCarats, value, transparency);
    }

    @Override
    public String getType() {
        return "Semi-Precious";
    }
}