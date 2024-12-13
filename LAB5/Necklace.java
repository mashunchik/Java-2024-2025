package LAB5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Necklace {
    private List<Gemstone> gemstones;

    public Necklace() {
        gemstones = new ArrayList<>();
    }

    public void addGemstone(Gemstone gemstone) {
        if (gemstone == null) {
            throw new IllegalArgumentException("Gemstone cannot be null.");
        }
        gemstones.add(gemstone);
    }

    public double calculateTotalWeight() {
        return gemstones.stream().mapToDouble(Gemstone::getWeightInCarats).sum();
    }

    public double calculateTotalValue() {
        return gemstones.stream().mapToDouble(Gemstone::getValue).sum();
    }

    public void sortByValue() {
        gemstones.sort(Comparator.comparingDouble(Gemstone::getValue).reversed());
    }

    public List<Gemstone> findByTransparencyRange(double minTransparency, double maxTransparency) {
        if (minTransparency < 0 || maxTransparency > 100 || minTransparency > maxTransparency) {
            throw new IllegalArgumentException("Invalid transparency range.");
        }
        return gemstones.stream()
                .filter(g -> g.getTransparency() >= minTransparency && g.getTransparency() <= maxTransparency)
                .toList();
    }

    public void printGemstones() {
        gemstones.forEach(System.out::println);
    }
}