import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

    public boolean isValidKey(String key) {
        boolean isValid = false;
        try {
            Integer.parseInt(key);
            isValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Введенные данные не являются числом. Попробуйте еще раз.");
        }
        return isValid;
    }

    public boolean isFileExists(String inputFile) {
        return Files.exists(Paths.get(inputFile));
    }



    public boolean isPathValid(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            Path parentDir = path.getParent();
            if (parentDir != null) {
                return Files.exists(parentDir) && Files.isWritable(parentDir);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}



