public class ExperimentsWithTime {
    public static void main(String[] args) {
       Time ex1 = new Time(9, 30);
       Time ex2 = new Time(23, 10);
       Time ex3 = new Time(15, 30);

       System.out.println(ex1.show());
       System.out.println(ex2.show());
       System.out.println(ex3.show());

       System.out.println(ex3.isDay());
       System.out.println(ex3.isNight());

       System.out.println(ex1.sayHello());
       System.out.println(ex2.sayHello());

       ex1.add(20);
       System.out.println(ex1.show());
       ex2.add(60);
       System.out.println(ex2.show());
       ex3.add(40);
       System.out.println(ex3.show());
    }
}
