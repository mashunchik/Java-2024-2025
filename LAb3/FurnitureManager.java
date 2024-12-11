package LAB3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Головний клас з виконавчим методом.
 */
public class FurnitureManager {
    public static void main(String[] args) {
        // Створення масиву меблів
        Furniture[] furnitureArray = {
                new Furniture("Стілець", "Дерево", 750.50, 5.5, 2),
                new Furniture("Стіл", "Метал", 1500.00, 15.0, 3),
                new Furniture("Диван", "Тканина", 4500.75, 50.0, 5),
                new Furniture("Шафа", "Дерево", 3000.00, 70.0, 10),
                new Furniture("Крісло", "Шкіра", 3500.00, 25.0, 4)
        };

        // Сортування за ціною (зростання)
        Arrays.sort(furnitureArray, Comparator.comparingDouble(Furniture::getPrice));
        System.out.println("Сортування за ціною (зростання):");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Сортування за вагою (спадання)
        Arrays.sort(furnitureArray, Comparator.comparingDouble(Furniture::getWeight).reversed());
        System.out.println("\nСортування за вагою (спадання):");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Пошук ідентичного об'єкта
        Furniture target = new Furniture("Диван", "Тканина", 4500.75, 50.0, 5);
        int index = Arrays.asList(furnitureArray).indexOf(target);

        System.out.println("\nПошук ідентичного об'єкта:");
        if (index != -1) {
            System.out.println("Знайдено об'єкт: " + furnitureArray[index]);
        } else {
            System.out.println("Об'єкт не знайдено.");
        }
    }
}