import util.FileHelper;
import util.Word;

import java.util.*;

public class ParagraphHistogram {
    private String inputFile;
    private String outputFile;

    public ParagraphHistogram(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * Reads the lines from the input file, counts the occurence of each word, creates a histogram of words in the
     * input file, and saves it in an output file.
     */
    public void createHistogram() {
        String paragraph = refactorLines(FileHelper.readFile(this.inputFile));
        List<String> newFileLines = new ArrayList<>();
        List<Word> objWordList = new ArrayList<>();
        for(String word : Arrays.asList(paragraph.split(" "))) {
            Word temp = new Word(word);
            if(objWordList.contains(temp))
                objWordList.get(objWordList.indexOf(temp)).addOccurrence();
            else
                objWordList.add(temp);
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

    public static void main(String[] args) {
        ParagraphHistogram ph = new ParagraphHistogram("input.txt", "output.txt");
        ph.createHistogram();
    }
}
