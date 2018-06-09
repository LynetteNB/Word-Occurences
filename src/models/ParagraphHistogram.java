package models;

import util.FileHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ParagraphHistogram {
    private String inputFile;
    private String outputFile;
    private List<Word> objWordList = new ArrayList<>();

    public ParagraphHistogram(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public List<Word> getObjWordList() {
        return objWordList;
    }

    /**
     * Creates the output txt file of a histogram using the words from the input file.
     */
    public void exportHistogram() {
        FileHelper.outputFile(this.outputFile, createHistogram());
    }

    /**
     * Reads the lines from the input file, counts the occurence of each word, and creates a histogram of words.
     * @return A list of strings that create a histogram of words and their occurences.
     */
    public List<String> createHistogram() {
        String paragraph = refactorLines(FileHelper.readFile(this.inputFile));
        List<String> newFileLines = new ArrayList<>();
        for(String word : paragraph.split(" ")) {
            Word tempWord = new Word(word);
            if(objWordList.contains(tempWord))
                objWordList.get(objWordList.indexOf(tempWord)).addOccurrence();
            else
                objWordList.add(tempWord);
        }
        objWordList.sort(Comparator.comparing(w -> -w.getOccurrences()));
        for(Word word : objWordList) {
            newFileLines.add(word.toString());
        }
        return newFileLines;
    }

    /**
     * Refactors and concatenates each line string to remove all punctuation and change to all lower case.
     * @param fileLines A list of strings to be concatenated.
     * @return A refactored, concatenated single string from the list of strings.
     */
    private static String refactorLines(List<String> fileLines) {
        StringBuilder paragraph = new StringBuilder("");
        for (String line : fileLines) {
            paragraph.append(line.replaceAll("[?!,.#*^']", "").toLowerCase() + " ");
        }

        return paragraph.toString();
    }
}
