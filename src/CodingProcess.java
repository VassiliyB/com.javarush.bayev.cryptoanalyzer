import constants.Constants;
import constants.ProcessType;
import java.util.Scanner;

public class CodingProcess {

    Constants constText = new Constants();
    public static Scanner console = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    CaesarCipher cipher = new CaesarCipher();
    Validator validator = new Validator();

    public void process(ProcessType processType) {

        String inputFilePath = getInputFilePath(processType);
        String inputText = fileManager.readFile(inputFilePath);
        System.out.println(constText.SUCCESSFULLY_READ);
        System.out.println(constText.SEPARATOR);

        String key = getValidKey();
        System.out.println(constText.SEPARATOR);

        String outputFilePath = getOutputFilePath(processType);
        String processedText = processType == ProcessType.DECRYPT
                ? cipher.decode(inputText, key)
                : cipher.encode(inputText, key);

        fileManager.writeFile(processedText, outputFilePath);
        System.out.println(constText.SUCCESSFULLY_WRITE);
    }

    private String getInputFilePath(ProcessType processType) {
        String filePath;

        System.out.println();
        System.out.println(processType == ProcessType.DECRYPT
                ? constText.INPUT_FILE_FOR_DECODE
                : constText.INPUT_FILE_FOR_ENCODE);

        while (true) {
            filePath = console.nextLine();
            if (validator.isFileExists(filePath) || filePath.isBlank()) {
                System.out.println(constText.WRONG_PATH);
            } else {
                return filePath;
            }
        }
    }

    private String getValidKey() {
        String key;
        do {
            System.out.println();
            System.out.println(constText.WRONG_KEY);
            key = console.nextLine();
        } while (validator.isValidKey(key));
        return key;
    }

    private String getOutputFilePath(ProcessType processType) {
        String outputPath;
        System.out.println();
        System.out.println(processType == ProcessType.DECRYPT
                ? constText.OUTPUT_FILE_FOR_DECRYPT
                : constText.OUTPUT_FILE_FOR_ENCRYPT);
        while (true) {
            outputPath = console.nextLine().trim();
            if (validator.isPathValid(outputPath)) {
                return outputPath;
            } else {
                System.out.println(constText.WRONG_PATH);
            }
        }
    }
}
