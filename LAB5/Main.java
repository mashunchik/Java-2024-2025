package LAB5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Necklace necklace = new Necklace();

            // Додавання каменів
            necklace.addGemstone(new PreciousGemstone("Diamond", 1.5, 5000, 99));
            necklace.addGemstone(new SemiPreciousGemstone("Amber", 2.0, 300, 75));
            necklace.addGemstone(new PreciousGemstone("Ruby", 1.2, 2500, 85));
            necklace.addGemstone(new SemiPreciousGemstone("Quartz", 3.0, 150, 60));

            System.out.println("Gemstones in necklace:");
            necklace.printGemstones();

            System.out.println("\nTotal Weight: " + necklace.calculateTotalWeight() + " carats");
            System.out.println("Total Value: " + necklace.calculateTotalValue() + " USD");

            System.out.println("\nSorted by value:");
            necklace.sortByValue();
            necklace.printGemstones();

            System.out.println("\nGemstones with transparency between 70% and 90%:");
            List<Gemstone> filtered = necklace.findByTransparencyRange(70, 90);
            filtered.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
