import java.util.Scanner;  
  
public class Main {  
  
    static class LinearEquation {  
        private double x1, y1, x2, y2, x3, y3, x4, y4;  
        private double a, b, c, d, e, f;  
  
        public LinearEquation( double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4 ){  
            this.x1 = x1;  
            this.y1 = y1;  
            this.x2 = x2;  
            this.y2 = y2;  
            this.x3 = x3;  
            this.y3 = y3;  
            this.x4 = x4;  
            this.y4 = y4;  
  
            a = this.y1 - this.y2;  
            b = -(this.x1 - this.x2);  
            c = this.y3 - this.y4;  
            d = -(this.x3 - this.x4);  
            e = (this.y1 - this.y2) * this.x1 - (this.x1 - this.x2) * this.y1;  
            f = (this.y3 - this.y4) * this.x3 - (this.x3 - this.x4) * this.y3;  
        }  
  
        public double getEdgeY(){  
  
            return (a*f - e*c) / (a*d - b*c);  
  
        }  
  
        public double getEdgeX(){  
            return  (e*d - b*f) / (a*d - b*c);  
        }  
    }  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        double x1, y1, x2, y2, x3, y3, x4, y4;  
  
        x1 = input.nextDouble();  
        y1 = input.nextDouble();  
        x2 = input.nextDouble();  
        y2 = input.nextDouble();  
        x3 = input.nextDouble();  
        y3 = input.nextDouble();  
        x4 = input.nextDouble();  
        y4 = input.nextDouble();  
  
        LinearEquation le = new LinearEquation( x1, y1, x2, y2, x3, y3, x4, y4 );  
  
        double x = le.getEdgeX(), y = le.getEdgeY();  
        x = (x != -0.0 ? x : 0.0);  
        y = (y != -0.0 ? y : 0.0);  
        System.out.printf( "The intersecting point is: (%.1f, %.1f)\n", x, y );  
  
    }  
  
}  