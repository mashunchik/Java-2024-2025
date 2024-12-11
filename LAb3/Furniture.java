package LAB3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Клас Furniture представляє об'єкт меблів.
 */
class Furniture {
    private String name;       // Назва меблів
    private String material;   // Матеріал виготовлення
    private double price;      // Ціна
    private double weight;     // Вага
    private int warrantyYears; // Термін гарантії у роках

    // Конструктор
    public Furniture(String name, String material, double price, double weight, int warrantyYears) {
        this.name = name;
        this.material = material;
        this.price = price;
        this.weight = weight;
        this.warrantyYears = warrantyYears;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    // Перевизначення toString() для зручного виведення
    @Override
    public String toString() {
        return String.format("Furniture{name='%s', material='%s', price=%.2f, weight=%.2f, warranty=%d years}",
                name, material, price, weight, warrantyYears);
    }

    // Перевизначення equals() для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Double.compare(furniture.price, price) == 0 &&
                Double.compare(furniture.weight, weight) == 0 &&
                warrantyYears == furniture.warrantyYears &&
                Objects.equals(name, furniture.name) &&
                Objects.equals(material, furniture.material);
    }
}