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
        while (true) {
            System.out.println("Введите абсолютный путь к файлу который хотите закодировать: ");
            inputFilePath = console.nextLine();
            if (!validator.isFileExists(inputFilePath)) {
                System.out.println("Указанный пуль неверный");
            } else {
                inputText = fileManager.readFile(inputFilePath);
                break;
            }
        }

        do {
            System.out.println("Введите ключ шифрования (он должен быть цифрой): ");
            key = console.nextLine();

        } while (!validator.isValidKey(key));

        System.out.println("Введите абсолютный путь к файлу в который будет сохранен зашифрованный текст: ");
        outputFilePath = console.nextLine();






        if (validator.isValidKey(key)) {
            encryptText = cipher.encode(inputText, key);
            fileManager.writeFile(encryptText, outputFilePath);
        } else {
            System.out.println("ключ не является цифрой");
        }
    }
}
