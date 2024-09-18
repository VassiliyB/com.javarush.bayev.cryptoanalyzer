package constants;

import java.util.*;

public class Alphabet {
    private static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    List<Character> alphabet;
    private final Map<Character, Integer> symbolsIndexes;

    public Alphabet() {
        alphabet = new ArrayList<>(Arrays.asList(ALPHABET));

        symbolsIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            symbolsIndexes.put(alphabet.get(i), i);
        }
    }

    public Character getSymbolByIndex(int index) {
            return alphabet.get(index);
    }

    public int getIndexBySymbol(Character symbol) {
        int result = -1;
        if (symbolsIndexes.containsKey(symbol)) {
            result = symbolsIndexes.get(symbol);
        }
        return result;
    }

    public int getSize() {
        return alphabet.size();
    }
}
