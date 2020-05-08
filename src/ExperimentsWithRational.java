public class ExperimentsWithRational {
    public static void main(String[] args) {
        Rational ex1 = new Rational(5, 3);
        Rational ex2 = new Rational(8, 2);
        Rational ex3 = new Rational(-3, 5);
        Rational ex4 = new Rational(15, -45);
        Rational ex5 = new Rational(-15, -45);

        System.out.println(ex1.toString());
        System.out.println(ex2.toString());
        System.out.println(ex3.toString());
        System.out.println(ex4.toString());
        System.out.println(ex5.toString());

        System.out.println(ex1.toDouble());
        System.out.println(ex3.toDouble());
        System.out.println(ex5.toDouble());

        Rational r3 = new Rational(1, 3);
        Rational r2 = new Rational(1, 6);
        Rational r1 = r2.add(r3);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        //r2.addInPlace(r3);
        //System.out.println(r2.toString());

        Rational p3 = new Rational(1, 4);
        Rational p2 = new Rational(1, 5);
        Rational p1 = p2.sub(p3);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        //p2.subInPlace(p3);
        //System.out.println(p2.toString());

        Rational m3 = new Rational(3, 4);
        Rational m2 = new Rational(2, 5);
        Rational m1 = m2.mul(m3);
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        //m2.mulInPlace(m3);
        //System.out.println(m2.toString());

        Rational n3 = new Rational(3, 4);
        Rational n2 = new Rational(2, 5);
        Rational n1 = n2.div(n3);
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        //n2.divInPlace(n3);
        //System.out.println(n2.toString());

        System.out.println(progression(1).toDouble());
        System.out.println(progression(2).toDouble());
        System.out.println(progression(3).toDouble());
        System.out.println(progression(20).toDouble());

        System.out.println(n3.getD());
        System.out.println(n3.getN());
    }

    public static Rational progression(int n) {
        Rational result = new Rational(0);
        for (int i = 1; i <= n; i++) {
            Rational r = new Rational(1, i);
            //result.addInPlace(r);
            result = Rational.add(result, r);
        }
        return result;
    }
}

