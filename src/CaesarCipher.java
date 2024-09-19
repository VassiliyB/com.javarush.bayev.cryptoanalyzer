import constants.Alphabet;

public class CaesarCipher {

    Alphabet alphabet = new Alphabet();

    private String coding (String text, int key) {
        StringBuilder newText = new StringBuilder();

        for (char ch : text.toCharArray()) {
            int index = alphabet.getIndexBySymbol(ch);
            if(index != -1) {
                int shiftIndex = (index + key) % alphabet.getSize();
                shiftIndex = (shiftIndex + alphabet.getSize()) % alphabet.getSize();
                System.out.println(shiftIndex);
                newText.append(alphabet.getSymbolByIndex(shiftIndex));
            } else {
                newText.append(ch);
            }
        }
        return newText.toString();
    }

    public String encode (String text, int key) {
        return coding(text.toLowerCase(), key);
    }

    public String decode (String text, int key) {
        return coding(text.toLowerCase(), -key);
    }

}
