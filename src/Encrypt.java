
import java.util.Scanner;

public class Encrypt {
    public static Scanner console = new Scanner(System.in);
    FileManager fileManager = new FileManager();
    CaesarCipher cipher = new CaesarCipher();
    Validator validator = new Validator();
    static String inputFilePath;
    static String outputFilePath;
    static String key;

    public void process() {
        String inputText;
        String encryptText;

        System.out.println();
        System.out.println("Введите абсолютный путь к файлу который хотите закодировать: ");
        while (true) {
            inputFilePath = console.nextLine();
            if (!validator.isFileExists(inputFilePath.trim()) || inputFilePath.isBlank()) {
                System.out.println();
                System.out.println("Указанный пуль неверный, введите еще раз");
            } else {
                inputText = fileManager.readFile(inputFilePath);
                System.out.println("Файл успешно прочитан.");
                System.out.println("-----------------------------------------------------------------");
                break;
            }
        }

        do {
            System.out.println();
            System.out.println("Введите ключ шифрования (он должен быть цифрой): ");
            key = console.nextLine();
        } while (!validator.isValidKey(key));

        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        System.out.println();
        System.out.println("Введите абсолютный путь к файлу в который будет сохранен зашифрованный текст: ");
        while (true) {
            outputFilePath = console.nextLine();
            if(validator.isPathValid(outputFilePath)) {
                encryptText = cipher.encode(inputText, key);
                fileManager.writeFile(encryptText, outputFilePath);
                break;
            } else {
                System.out.println("путь некорректен, введите еще раз ");
            }
        }
    }
}
