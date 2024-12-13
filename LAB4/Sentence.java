package LAB4;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Object> components; // Може містити слова або розділові знаки

    public Sentence(String sentence) {
        components = new ArrayList<>();
        String[] parts = sentence.split("(?<=\b)|(?=\b)");
        for (String part : parts) {
            if (part.matches("\\w+")) {
                components.add(new Word(part));
            } else {
                components.add(part);
            }
        }
    }

    public List<Object> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Object component : components) {
            sentence.append(component.toString());
        }
        return sentence.toString();
    }
}