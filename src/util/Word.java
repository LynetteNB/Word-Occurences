package util;

import java.util.Objects;

/**
 * Word object includes a word string and the number of occurences of that word.
 */
public class Word {
    private String word;
    private int occurrences = 1;

    public Word(String word) {
        this.word = word;
    }

    public void addOccurrence() {
        occurrences += 1;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        String equals = "";
        for(int i = 0; i < this.occurrences; i++) {
            equals += "=";
        }
        return String.format("%8s | %s (%d)", word, equals, occurrences);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(this.word, word.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, occurrences);
    }
}
