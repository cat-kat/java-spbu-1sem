import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Transliterator {
    public static final String[] ICAO_DOC_9303 = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};
    public static final char[] RUS = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    public static Transliterator createICAO_DOC_9303() {
        return new Transliterator(RUS, ICAO_DOC_9303);
    }

    private char[] from;
    private String[] to;

    public Transliterator(char[] from, String[] to) {
        this.from = from;
        this.to = to;
    }

    public String translateOneSymbol(char symb) {
        int ind = -1;
        String normSymb = String.valueOf(symb).toLowerCase();
        for (int i = 0; i < from.length; i++) {
            if (from[i] == normSymb.charAt(0)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) return String.valueOf(symb);
        else return normRegister(symb, to[ind]);
    }

    public String translate(String in) {
        String result = "";
        for (int i = 0; i < in.length(); i++) {
            result += translateOneSymbol(in.charAt(i));
        }
        return result;
    }

    public void translateFile(String input, String output) throws Exception {
        String in = Files.readString(Paths.get(input));
        try (PrintStream write = new PrintStream(new File(output), "utf8")) {
            write.println(translate(in));
        }
    }

    private String normRegister(char symb, String in) {
        if (Character.isLowerCase(symb) || in.length() < 1) return in;
        else return in.substring(0, 1).toUpperCase() + in.substring(1);
    }

}
