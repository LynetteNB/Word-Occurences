package util;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String word;
    private int occurrences = 1;
    private static List<String> wordList = new ArrayList<>();
    public static List<Word> objWordList = new ArrayList<>();

    public Word(String word) {
        this.word = word;
        wordList.add(word);
        objWordList.add(this);
    }

    private void addOccurrence() {
        occurrences += 1;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public static boolean checkWordList(String word) {
        return wordList.contains(word);
    }

    public static void updateWord(String wordString) {
        for(Word word : objWordList) {
            if(word.word.equals(wordString)) {
                word.addOccurrence();
            }
        }
    }

    @Override
    public String toString() {
        String equals = "";
        for(int i = 0; i < this.occurrences; i++) {
            equals += "=";
        }
        return String.format("%8s | %s (%d)", word, equals, occurrences);
    }
}
