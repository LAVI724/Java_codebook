import java.awt.geom.Point2D;

public class Main {

    public static void main(String[] args) {
        double x1 = 2.0, y1 = 6.0;
        Point2D pt = new Point2D.Double(x1, y1);

        System.out.println(pt.distance(0,0));
    }
}

// Output:
// 6.324555320336759