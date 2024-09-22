import constants.ProcessType;

public class MainApp {
    public static void main(String[] args) {
        Encrypt encrypt = new Encrypt();
        CodingProcess decrypt = new CodingProcess();
        decrypt.process(ProcessType.DECRYPT);
    }
}
