import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for( int i = 0; i < n; i++ ){
            double x1, y1, x2, y2, x3, y3;

            x1 = input.nextDouble();
            y1 = input.nextDouble();

            x2 = input.nextDouble();
            y2 = input.nextDouble();

            x3 = input.nextDouble();
            y3 = input.nextDouble();

            // 創建一個 Triangle class 類別的物件 tri 
            // 並初始預設要使用的點給他 他會傳給位於 Triangle 裡的 constructor
            Triangle tri = new Triangle(x1, y1, x2, y2, x3, y3);

            // 呼叫 Triangle 裡的 trianglecheck 用來判斷是否為三角形及其面積
            tri.trianglecheck();
        }
    }

    public static class Triangle{

        // 型別為 Point2D class 的 3 個 datamember 用以儲存 3 個頂點 
        // 記得賦予初始狀態 new
        private Point2D edge1 = new Point2D.Double();
        private Point2D edge2 = new Point2D.Double();
        private Point2D edge3 = new Point2D.Double();

        // constructor 
        // 用來初始化 data member (因為我的 data member 不要 static, static 會只吃第一次的輸入值 )
        public Triangle( double x1, double y1, double x2, double y2, double x3, double y3 ){

            // 型別為 Point2D class 的 3 個 datamember 用以儲存 3 個頂點
            this.edge1.setLocation( x1, y1 );
            this.edge2.setLocation( x2, y2 );
            this.edge3.setLocation( x3, y3 );

        }

        public void trianglecheck(){

            double[] side = new double[3];
            Arrays.fill( side, 0);
            
            // 利用 point2D 的 .distance( point2D edge ) 取得距離 ( 型態為 double )
            side[0] = edge1.distance(edge2);
            side[1] = edge1.distance(edge3);
            side[2] = edge2.distance(edge3);

            Arrays.sort(side);

            if( side[0] + side[1] <= side[2] ){
                System.out.println("Just Line!");
            }
            else{
                // 海龍公式計算三角形面積
                double s = ( side[0] + side[1] + side[2] )/2;
                double a = Math.sqrt( s*(s-side[0])*(s-side[1])*(s-side[2]));

                System.out.printf( "%.3f %.3f %.3f %.3f\n", side[0], side[1], side[2], a );
            }
        }
    }
}
