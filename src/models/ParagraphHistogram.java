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
        this.exportHistogram();
    }

    public List<Word> getObjWordList() {
        return objWordList;
    }

    /**
     * Reads the lines from the input file, counts the occurence of each word, creates a histogram of words in the
     * input file, and saves it in an output file.
     */
    public void exportHistogram() {
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
        FileHelper.outputFile(this.outputFile, newFileLines);
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
