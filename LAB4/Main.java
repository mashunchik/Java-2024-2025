package LAB4;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputText = "Це    перше речення. Ось друге речення,   яке більш складне. А це ще одне.";

        // Створення об'єкта Text
        Text text = new Text(inputText);

        // Нормалізація пробілів
        text.normalizeWhitespace();

        // Виведення обробленого тексту
        System.out.println("Оброблений текст:");
        System.out.println(text);

        // Сортування речень за кількістю слів
        List<Sentence> sentences = text.getSentences();
        sentences.sort(Comparator.comparingInt(s -> s.toString().split("\\s+").length));

        // Виведення речень у порядку зростання кількості слів
        System.out.println("\nРечення в порядку зростання кількості слів:");
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }
}