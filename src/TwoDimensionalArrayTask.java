import java.util.Arrays;

public class TwoDimensionalArrayTask {
    public static void main(String[] args) {
        char[][] c = createTable(7, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);

    }

    private static char[][] createTable(int n, char s) {
        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) table[i][j] = s;
        }
        return table;
    }

    private static void printTable(char[][] table) {
        int len = table.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) System.out.print(table[i][j] + " ");
            System.out.println();
        }

    }

    private static void fillFirstAndLastLines(char[][] table, char s) {
        int len = table[0].length;
        Arrays.fill(table[0], s);
        Arrays.fill(table[len - 1], s);
    }

    private static void fillFirstAndLastColumns(char[][] table, char s) {
        int len = table[0].length;
        for (int i = 0; i < len; i++) {
            table[i][0] = s;
            table[i][len - 1] = s;
        }
    }
}