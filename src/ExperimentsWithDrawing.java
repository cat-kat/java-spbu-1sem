public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        Drawing a = new Drawing(5, 4, '*');
        a.print();
        System.out.println("/------------------/");
        a.drawVerticalLine(2, '_');
        a.print();
        System.out.println("/------------------/");
        a.drawHorizontalLine(3, '-');
        a.print();

        System.out.println("/------------------/");
        Drawing b = new Drawing(6, 7, '*');
        b.drawRectangle(2,3, 5, 6, '+');
        b.print();

        System.out.println("/------------------/");
        Drawing c = new Drawing(20, 20, '-');
        c.drawCircle( 10,10, 7,'+');
        c.print();

        System.out.println("/------------------/");
        Drawing d = new Drawing(40, 40, '.');
        Drawing h = house();
        d.draw(5, 10, h);
        d.print();
    }

    public static Drawing house() {
        Drawing h = new Drawing(20, 20, '.');
        h.drawRectangle(10, 2, 18, 17, '*');
        h.drawRectangle(12, 4, 15, 9, '*');
        h.drawRectangle(13, 12, 18, 15, '*');
        h.drawRectangle(6, 1, 10, 18, '*');
        int x1 = 1;
        int x2 = 18;
        while (x1 < x2) {
            h.drawVerticalInterval(x1,  6, 10,'*');
            x1 += + 3;
        }
        return h;
    }
}