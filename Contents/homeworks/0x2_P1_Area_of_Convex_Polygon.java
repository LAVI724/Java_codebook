import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static class Triangle {
        // 型別為 Point2D class 的 3 個 datamember 用以儲存 3 個頂點
        private Point2D edge1 = new Point2D.Double();
        private Point2D edge2 = new Point2D.Double();
        private Point2D edge3 = new Point2D.Double();

        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
            // 型別為 Point2D class 的 3 個 datamember 用以儲存 3 個頂點
            this.edge1.setLocation(x1, y1);
            this.edge2.setLocation(x2, y2);
            this.edge3.setLocation(x3, y3);
        }

        public double area(){
            double[] side = new double[3];
            Arrays.fill( side, 0);

            // 利用 point2D 的 .distance( point2D edge ) 取得距離 ( 型態為 double )
            side[0] = edge1.distance(edge2);
            side[1] = edge1.distance(edge3);
            side[2] = edge2.distance(edge3);

            // 海龍公式計算三角形面積
            double s = ( side[0] + side[1] + side[2] )/2;
            return Math.sqrt( s*(s-side[0])*(s-side[1])*(s-side[2]));
        }
    }

    public static class ConvexPolygon {
        Scanner input = new Scanner(System.in);
        // 用 vector 存凸角形各點
        private static int n;
        private static Vector<Double> edge = new Vector<>();

        public ConvexPolygon(int n, Vector<Double> edge) {
            this.n = n;
            ConvexPolygon.edge = edge;
        }

        public static double area() {
            double area = 0;
            // 以 edge[0] edge[1] 為三角形固定一點 順時針向其他每兩點畫一個三角形 並計算面積
            for (int i = 0, k = 0; i < n - 2; i++, k += 2) {
                Triangle tri = new Triangle(edge.get(0), edge.get(1), edge.get(k + 2), edge.get(k + 3), edge.get(k + 4), edge.get(k + 5));
                area += tri.area();
            }
            return area;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(input.hasNext()){
            int n = input.nextInt();
            Vector<Double> edge = new Vector<>();
            for (int i = 0; i < 2 * n; i++) {
                edge.add(input.nextDouble());
            }
            ConvexPolygon CP = new ConvexPolygon(n, edge);

            if(flag){
                System.out.println();
            }
            System.out.printf("%.3f\n", ConvexPolygon.area());
            flag = true;
        }
    }
}