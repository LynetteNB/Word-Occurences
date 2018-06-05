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

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public void createHistogram() {
        List<String> fileLines= FileHelper.readFile(inputFile);
        StringBuilder paragraph = new StringBuilder("");
        List<String> newFileLines = new ArrayList<>();
        for (String line : fileLines) {
            line = line.replaceAll("[?!,.#*^]", "").toLowerCase();
            paragraph.append(line + " ");
        }
        for(String word : Arrays.asList(paragraph.toString().split(" "))) {
            if(Word.checkWordList(word)) {
                Word.updateWord(word);
            } else {
                new Word(word);
            }
        }
        Word.objWordList.sort(Comparator.comparing(w -> -w.getOccurrences()));
        for(Word word : Word.objWordList) {
            newFileLines.add(word.toString());
        }
        FileHelper.outputFile("output.txt", newFileLines);
    }

    public static void main(String[] args) {
        ParagraphHistogram ph = new ParagraphHistogram("input.txt", "output.txt");
        ph.createHistogram();
    }




}
