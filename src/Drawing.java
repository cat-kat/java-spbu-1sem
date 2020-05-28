public class Drawing {
    private char[][] pict;
    private int lenX;
    private int lenY;

    Drawing(int m, int n, char symb) {
        pict = new char[m][n];
        lenY = m;
        lenX = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                pict[i][j] = symb;
        }

    }

    public void print() {
        for (int i = 0; i < lenY; i++) {
            for (int j = 0; j < lenX; j++) System.out.print(pict[i][j] + " ");
            System.out.println();
        }
    }

    public void drawVerticalLine(int x, char symb) {
        for (int i = 0; i < lenY; i++) setPoint(i, x, symb);
    }

    public void drawHorizontalLine(int y, char symb) {
        for (int i = 0; i < lenX; i++) setPoint(y, i, symb);
    }

    public void drawVerticalInterval(int y, int x1, int x2, char symb) {
        for (int i = x1; i <= x2; i++) setPoint(i, y, symb);
    }

    public void drawHorizontalInterval(int x, int y1, int y2, char symb) {
        for (int i = y1; i <= y2; i++) setPoint(x, i, symb);
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char symb) {
        this.drawHorizontalInterval(x1, y1, y2, symb);
        this.drawHorizontalInterval(x2, y1, y2, symb);
        this.drawVerticalInterval(y1, x1, x2, symb);
        this.drawVerticalInterval(y2, x1, x2, symb);
    }

    public void drawCircle(int x0, int y0, int r, char symb) {
        for (int i = x0 - r; i <= x0 + r; i++)
            for (int j = y0 - r; j <= y0 + r; j++) {
                if (((x0 - i) * (x0 - i)) + ((y0 - j) * (y0 - j)) <= (r * r))
                    setPoint(i, j, symb);
            }
    }

    public void draw(int x, int y, Drawing d) {
        for (int i = 0; i < d.lenY; i++) {
            for (int j = 0; j < d.lenX; j++)
                pict[x + i][y + j] = d.pict[i][j];
        }
    }

    private void setPoint(int x, int y, char symb) {
        pict[x][y] = symb;
    }

}
