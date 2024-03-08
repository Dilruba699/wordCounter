import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {

    public static void main(String[] args) {
        // Path to the input text file
        String filename = "input.txt";

        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the file and count words
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", ""); // Remove punctuation and convert to lowercase
                if (!word.isEmpty()) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return;
        }

        // Create a TreeMap to store the word count in alphabetical order
        Map<String, Integer> sortedWordCountMap = new TreeMap<>(wordCountMap);

        // Display word count for each unique word in alphabetical order
        for (Map.Entry<String, Integer> entry : sortedWordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}