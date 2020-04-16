public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int[] result = Eratosthene(32);
        for (int i : result) {
            System.out.println(i);
        }
    }


    private static int[] Eratosthene(int n) {
        int p = 2;
        int nullElem = 0;
        int[] sieve = new int[n - 2];
        for (int i = 2; i < n; i++) {
            sieve[i - 2] = i;
        }
        while (p < n - 1) {
            for (int i = 2 * p; i < n; i++) {
                if (i % p == 0) {
                    sieve[i - 2] = 0;

                }
            }
            for (int i = 0; i < sieve.length; i++) {
                if (sieve[i] > p) {
                    p = sieve[i];
                    break;
                }
            }

        }
        int len = 0;
        for (int i : sieve) {
            if (i != 0) len++;
        }
        int[] result = new int[len];
        int j = 0;
        for (int i : sieve) {
            if (i != 0) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }


}
