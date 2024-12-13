package LAB6.src;

import LAB6.src.collections.CustomList;
import LAB6.src.gemstones.PreciousGemstone;
import LAB6.src.gemstones.SemiPreciousGemstone;

public class Main {
    public static void main(String[] args) {
        // Create gemstones
        PreciousGemstone ruby = new PreciousGemstone("Ruby", 2.0, 5000, 0.9);
        PreciousGemstone diamond = new PreciousGemstone("Diamond", 1.5, 15000, 0.95);
        SemiPreciousGemstone amethyst = new SemiPreciousGemstone("Amethyst", 3.0, 200, 0.7);

        // Create a custom list and add gemstones
        CustomList<PreciousGemstone> necklace = new CustomList<>();
        necklace.add(ruby);
        necklace.add(diamond);

        CustomList<SemiPreciousGemstone> collection = new CustomList<>();
        collection.add(amethyst);

        // Demonstrate functionality
        System.out.println("Necklace gemstones:");
        for (PreciousGemstone gem : necklace) {
            System.out.println(gem);
        }

        System.out.println("\nSemi-precious gemstones collection:");
        for (SemiPreciousGemstone gem : collection) {
            System.out.println(gem);
        }
    }
}