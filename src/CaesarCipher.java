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
                newText.append(alphabet.getSymbolByIndex(shiftIndex));
            } else {
                newText.append(ch);
            }
        }
        return newText.toString();
    }

    public String encode (String text, String key) {
        int intKey = Integer.parseInt(key);
        return coding(text.toLowerCase(), intKey);
    }

    public String decode (String text, String key) {
        int intKey = Integer.parseInt(key);
        return coding(text.toLowerCase(), -intKey); // Хорошо ли здесь приводить текст к нижнему регистру?
    }                                            // Или это нужно делать в другом месте?

}
