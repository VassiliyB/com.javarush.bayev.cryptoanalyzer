import constants.Constants;
import constants.ProcessType;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Constants constText = new Constants();
        CodingProcess codeProcess = new CodingProcess();
        Scanner console = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println(constText.MENU_TEXT);

            String numberMenu = console.next();
            if (numberMenu.matches("\\d+")) {
                switch (numberMenu) {
                    case "1" -> codeProcess.process(ProcessType.ENCRYPT);
                    case "2" -> codeProcess.process(ProcessType.DECRYPT);
                    case "3" -> exit = true;
                    default -> System.out.println(constText.INVALID_VALUE);
                }
            } else {
                System.out.println(constText.INVALID_VALUE);
            }
        }
    }
}
