import constants.Alphabet;

public class MainApp {
    public static void main(String[] args) {
        FileManager file = new FileManager();
        String origText = file.readFile("text.txt");
        System.out.println(origText);

    }
}
