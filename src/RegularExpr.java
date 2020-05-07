import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpr {
    public static void main(String[] args) {
        System.out.println(myIsEmail("koboy-cat@icloud.ru"));
        System.out.println(isEmail("koboy-cat@icloud.com"));
        System.out.println(delWhitespace("Лишние , запятые, стоят   , здесь!"));
        System.out.println(replaceDash("Какая-то сине-зеленовая трава"));
        System.out.println(countKOT("Кот который КОТ"));
        // System.out.println(increaseIntFromStr("resources/nums_2.txt"));
    }

    private static boolean myIsEmail(String s) {
        return s.matches("[a-z\\.-]*@[a-z\\.-]*\\.[a-z][a-z]([a-z]|)([a-z]|)");
    }

    private static boolean isEmail(String s) {
        return s.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    private static String delWhitespace(String s) {
        return s.replaceAll("\\s+,", ",");
    }

    private static String replaceDash(String s) {
        return s.replaceAll("([a-zA-Zа-я]+)-([a-zA-Zа-я]+)", "$2-$1");
    }

    private static int countKOT(String s) {
        int count = 0;
        Pattern p = Pattern.compile("кот", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        Matcher m = p.matcher(s);
        while (m.find()) count++;
        return count;
    }

}
