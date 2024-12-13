package LAB4;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] splitSentences = text.split("(?<=[.!?])\s*");
        for (String sentence : splitSentences) {
            sentences.add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void normalizeWhitespace() {
        for (Sentence sentence : sentences) {
            String normalized = sentence.toString().replaceAll("\\s+", " ");
            sentences.set(sentences.indexOf(sentence), new Sentence(normalized));
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence.toString()).append(" ");
        }
        return text.toString().trim();
    }
}