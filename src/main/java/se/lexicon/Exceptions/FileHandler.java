package se.lexicon.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    void main() {
        Path filePath = Paths.get("src/main/java/se/lexicon/Exceptions/data.txt");
        
        // OUTER TRY: Handles File I/O issues (File not found, access denied, etc.)
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            
            String line;
            // Read the file line by line with loop 
            while ((line = reader.readLine()) != null) {
                
                // INNER TRY: Handles Parsing issues for specific lines
                try {
                    // Trim allows " 50 " to become 50
                    int number = Integer.parseInt(line.trim());
                    IO.println("Parsed number: " + number);
                } catch (NumberFormatException e) {
                    // We handle the bad line specifically and continue with the loop
                    IO.println("Skipping line (Not a number): " + line);
                }
            }
        } catch (NoSuchFileException e) {
            IO.println("Error: The file 'data.txt' could not be found.");
        } catch (IOException e) {
            IO.println("Error: An I/O error occurred reading the file.");
        }
    }
}
