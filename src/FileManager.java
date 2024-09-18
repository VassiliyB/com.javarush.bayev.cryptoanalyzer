import exceptions.FileException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String readFilePath) {

        Path filePath = Path.of(readFilePath);
        StringBuilder originalText = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                originalText.append(line.toLowerCase());
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e);
        }
        return originalText.toString();
    }

}
