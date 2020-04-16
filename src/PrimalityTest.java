public class PrimalityTest {
    public static void main (String[] args) {
        System.out.println(isEasy(1));
        System.out.println(isEasy(2));
        System.out.println(isEasy(3));
        System.out.println(isEasy(67));
        System.out.println(isEasy(69));
    }

    private static boolean isEasy(int n) {
        if ((n == 1) || (n == 2)) return true;
        for (int i = 2; i < n-1; i++) {
            if (n % i == 0) {
                return false;
            }
         }
        return true;
    }
}
