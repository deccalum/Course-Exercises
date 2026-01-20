package se.lexicon.Exceptions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringtoFile {
    void main() {
        String userInput = IO.readln("Enter a string to save to file: ");
        Path path = Paths.get("output.txt");

        // KEY CHANGE: The resource (writer) is created INSIDE the parentheses.
        // This ensures writer.close() is called automatically, even if errors occur.
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            
            writer.write(userInput);
            IO.println("String saved to output.txt");
            
        } catch (IOException e) {
            IO.println("Error writing to file: " + e.getMessage());
        }
    }
}