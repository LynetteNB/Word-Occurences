package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    /**
     * Takes in a String with the filepath of the file to be read and returns a list with each line of the file as an element of the list.
     * @param filePath The filepath to the file to be read.
     * @return List of strings with each line read from the file as an element of the list.
     */
    public static List<String> readFile(String filePath) {
        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Unable to read the file provided! Check the input filepath.");
            e.printStackTrace();
        }
        return fileLines;
    }

    /**
     * Creates a new file with the given contents to the path given.
     * @param filePath The name of the file to be created including file path.
     * @param contents A list of the contents to be written in the new file.
     */
    public static void outputFile(String filePath, List<String> contents){
        try {
            if(Paths.get(filePath).getParent() != null && !Files.exists(Paths.get(filePath).getParent())){
                Files.createDirectory(Paths.get(filePath).getParent());
            }
            if(!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
            }
            Files.write(Paths.get(filePath), contents);
        } catch (IOException e) {
            System.out.println("Unable to create new output file! Try a different output filepath.");
            e.printStackTrace();
        }
    }
}
