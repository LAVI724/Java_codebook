import java.util.Scanner;

public class Main {

    static class RegularPolygon{
        private int n;
        private double side;
        private double x, y;

        public RegularPolygon(){
            n = 3;
            side = 1;
            x = 0;
            y = 0;
        }

        public RegularPolygon( int n, double side ){
            this.n = n;
            this.side = side;
        }

        public RegularPolygon( int n, double side, double x, double y ){
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }

        public double getPerimeter(){
            return this.side * this.n;
        }

        public double getArea(){
            return ( this.n * Math.pow( this.side, 2 ) ) / ( 4 * Math.tan( Math.PI / this.n ));
        }

    }
    public static void main(String[] args) {

        // 預設值
        RegularPolygon rp1 = new RegularPolygon();
        // 給定邊
        RegularPolygon rp2 = new RegularPolygon( 6, 4 );
        // 給定邊和 x y
        RegularPolygon rp3 = new RegularPolygon( 10, 4, 5.6, 7.8 );

        System.out.println( "Polygon 1 perimeter: " + rp1.getPerimeter() );
        System.out.println( "Polygon 1 area: " + rp1.getArea() );
        System.out.println( "Polygon 2 perimeter: " + rp2.getPerimeter() );
        System.out.println( "Polygon 2 area: " + rp2.getArea() );
        System.out.println( "Polygon 3 perimeter: " + rp3.getPerimeter() );
        System.out.println( "Polygon 3 area: " + rp3.getArea() );

    }

}
