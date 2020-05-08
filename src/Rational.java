public class Rational {
    public static final Rational ONE = new Rational(1);
    public static final Rational ZERO = new Rational(0);

    public static Rational add(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d + r2.n * r1.d, r2.d * r1.d);
    }

    public static Rational sub(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d - r2.n * r1.d, r2.d * r1.d);
    }

    public static Rational mul(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.n, r2.d * r1.d);
    }

    public static Rational div(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d, r2.n * r1.d);
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long[] optimize(long a, long b) {
        long result[] = new long[2];
        long mygcd = gcd(Math.abs(a), Math.abs(b));
        if (b < 0) {
            result[0] = -a / mygcd;
            result[1] = -b / mygcd;
        } else {
            result[0] = a / mygcd;
            result[1] = b / mygcd;
        }
        return result;
    }

    private long n;
    private long d;

    Rational(long n) {
        this.n = n;
        this.d = 1;
    }

    Rational(long n, long d) {
        long result[] = optimize(n, d);
        this.n = result[0];
        this.d = result[1];

    }

    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }

    public String toString() {
        if (n == 0) return "0";
        else if (d == 1) return String.valueOf(n);
        else return n + "/" + d;
    }

    public double toDouble() {
        return (double) n / (double) d;
    }

    public Rational add(Rational r) {
        return new Rational(n * r.d + r.n * d, r.d * d);
    }

  /*  public void addInPlace(Rational r) {
        n = n * r.d + r.n * d;
        d = r.d * d;
        long result[] = optimize(n, d);
        n = result[0];
        d = result[1];
    } */

    public Rational sub(Rational r) {
        return new Rational(n * r.d - r.n * d, r.d * d);
    }

   /*  public void subInPlace(Rational r) {
        n = n * r.d - r.n * d;
        d = r.d * d;
        long result[] = optimize(n, d);
        n = result[0];
        d = result[1];
    } */

    public Rational mul(Rational r) {
        return new Rational(n * r.n, r.d * d);
    }

  /*  public void mulInPlace(Rational r) {
        n = n * r.n;
        d = r.d * d;
        long result[] = optimize(n, d);
        n = result[0];
        d = result[1];
    } */

    public Rational div(Rational r) {
        return new Rational(n * r.d, r.n * d);
    }

 /*    public void divInPlace(Rational r) {
        n = n * r.d;
        d = r.n * d;
        long result[] = optimize(n, d);
        n = result[0];
        d = result[1];
    } */

}
