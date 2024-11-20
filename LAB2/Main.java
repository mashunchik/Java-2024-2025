import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Вхідний текст
        String inputText = "Це перше речення. Ось друге речення, яке більш складне. А це ще одне.";

        // Використання StringBuilder для обробки тексту
        StringBuilder text = new StringBuilder(inputText);

        // Метод для обробки та виведення речень за кількістю слів
        processText(text);
    }

    // Метод для обробки та виведення речень у порядку зростання кількості слів
    public static void processText(StringBuilder text) {
        // Перевірка на порожній текст
        if (text == null || text.length() == 0) {
            System.out.println("Вхідний текст порожній!");
            return;
        }

        // Розділення тексту на речення
        String[] sentences = text.toString().split("\\.\\s*");

        // Список для зберігання речень і їх кількості слів
        List<SentenceWithWordCount> sentenceList = new ArrayList<>();

        // Обробка кожного речення
        for (String sentence : sentences) {
            String trimmedSentence = sentence.trim();
            if (!trimmedSentence.isEmpty()) {
                int wordCount = trimmedSentence.split("\\s+").length; // Кількість слів у реченні
                sentenceList.add(new SentenceWithWordCount(trimmedSentence, wordCount));
            }
        }

        // Сортування за кількістю слів
        Collections.sort(sentenceList, Comparator.comparingInt(SentenceWithWordCount::getWordCount));

        // Виведення результатів
        System.out.println("Речення в порядку зростання кількості слів:");
        for (SentenceWithWordCount sentence : sentenceList) {
            System.out.println(sentence.getSentence());
        }
    }

    // Клас для зберігання речення та кількості слів
    static class SentenceWithWordCount {
        private final String sentence;
        private final int wordCount;

        public SentenceWithWordCount(String sentence, int wordCount) {
            this.sentence = sentence;
            this.wordCount = wordCount;
        }

        public String getSentence() {
            return sentence;
        }

        public int getWordCount() {
            return wordCount;
        }
    }
}
