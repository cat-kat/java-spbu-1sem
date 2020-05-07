import java.util.Arrays;

public class ArrayTasks {
    public static void main(String[] args) {
        int[] result = parity(5);
        System.out.println(Arrays.toString(result));

        int[] example = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(hasSimilar(example));

        System.out.println(average(example));

        int[] x = {20, 10, 30, 40};
        int[] y = sortReverse(x);
        System.out.println(Arrays.toString(x)); // печатает 20 10 30
        System.out.println(Arrays.toString(y));// печатает 30 20 10
    }

    private static int[] parity(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (i + 1) * 2;
        }
        return result;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i] == a[j])
                    return true;

            }
        }
        return false;
    }

    private static double average(int[] a) {
        double sum = 0;
        for (int i : a) sum += i;
        return sum / a.length;
    }

    private static int[] sortReverse(int[] a) {
        int n = a.length;
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        for (int i : b) System.out.println(i);
        for (int i = 0; i < Math.round(n / 2); i++) {
            int temp = b[i];
            b[i] = b[n - i - 1];
            b[n - i - 1] = temp;
        }
        return b;
    }
}

