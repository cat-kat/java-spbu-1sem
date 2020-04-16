import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class IOTasks {
    public static void main(String[] args) throws Exception {
        System.out.println(easyAmount("resources/nums.txt"));
        System.out.println(amount("resources/nums_2.txt"));
        System.out.println(amount("resources/sp.txt"));
        String[] lines = {"Это был смешной день", "Очень смешной", "Правда"};
        newFile(lines, "resources/result.txt");
        grammaText("resources/sp.txt", "resources/trueText.txt");
    }

    private static int easyAmount(String fileName) throws FileNotFoundException {
        int sum = 0;
        File f = new File(fileName);
        try (Scanner in = new Scanner(f, "utf8")) {
            while (in.hasNext()) {
                int temp = in.nextInt();
                sum += temp;
            }
        }
        return sum;
    }

    private static int amount(String fileName) throws FileNotFoundException {
        int sum = 0;
        File f = new File(fileName);
        try (Scanner in = new Scanner(f, "utf8")) {
            while (in.hasNext()) {
                if (in.hasNextInt()) {
                    int temp = in.nextInt();
                    sum += temp;
                } else in.next();
            }
        }
        return sum;
    }

    private static File newFile(String[] lines, String fileName) throws Exception {
        File f = new File(fileName);
        try (PrintStream out = new PrintStream(f, "utf8")) {
            for (String line : lines) {
                out.println(line);
            }
        }
        return f;
    }

    private static void grammaText(String fileIn, String fileOut) throws Exception {
        File f = new File(fileIn);
        File result = new File(fileOut);
        try (Scanner in = new Scanner(f, "utf8")) {
            try (PrintStream out = new PrintStream(result, "utf8")) {
               if (in.hasNext()) {
                   out.print(upper(in.next().substring(1)) + " ");
               }
                while (in.hasNext()) {
                    String temp = in.next();
                    out.print(lower(temp) + " ");
                    if (in.hasNext() && (temp.endsWith("!") || temp.endsWith("?") || temp.endsWith("."))) {
                       out.print(upper(in.next()) + " ");
                    }
                }
            }
        }
    }
    private static String upper (String temp) {
        return  temp.substring(0, 1).toUpperCase() + temp.substring(1);
    }

    private static String lower (String temp) {
        return temp.substring(0, 1).toLowerCase() + temp.substring(1);
    }
}

