package LAB4;

public class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String toUpperCase() {
        return Character.toString(Character.toUpperCase(character));
    }

    public String toLowerCase() {
        return Character.toString(Character.toLowerCase(character));
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }
}