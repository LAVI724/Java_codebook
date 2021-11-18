import java.util.Scanner;

public class Main {

    static class LinearEquation {
        private double x1, y1, x2, y2, x3, y3, x4, y4;

        public LinearEquation( double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4 ){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
            this.x4 = x4;
            this.y4 = y4;
        }

        public double getline1(){
            return (this.y1 - this.y2) * this.x1 - (this.x1 - this.x2) * this.y1;
        }

        public double getline2(){
            double getl2 = (this.y3 - this.y4) * this.x3 + (this.x3 - this.x4) * this.y3;
            return getl2 != -0.0 ? getl2 : 0.0;
        }

        public double getEdgeY(){

            double lcmn = 2, div, y;
            while( lcmn % (this.y1 - this.y2) != 0 || lcmn % (this.y3 - this.y4) != 0){
                lcmn++;
            }

            div = (this.x2 - this.x1) * (lcmn/(this.y1 - this.y2)) - (this.x4 - this.x3) * (lcmn/(this.y3 - this.y4));
            y = ( getline1() * (lcmn/(this.y1 - this.y2)) - getline2() * (lcmn/(this.y3 - this.y4)) )/div;

            return y != -0.0 ? y : 0.0;
        }

        public double getEdgeX(){
            double x = ( getline1() + (this.x1 - this.x2) * getEdgeY() ) / (this.y1 - this.y2);
            return x != -0.0 ? x : 0.0;
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

        System.out.printf( "The intersecting point is: (%.1f, %.1f)\n", le.getEdgeX(), le.getEdgeY() );

    }

}

import java.util.Scanner;

public class Main {

    static class LinearEquation {
        private double x1, y1, x2, y2, x3, y3, x4, y4;

        public LinearEquation( double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4 ){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
            this.x4 = x4;
            this.y4 = y4;
        }

        public double getline1(){
            return (this.y1 - this.y2) * this.x1 - (this.x1 - this.x2) * this.y1;
        }

        public double getline2(){
            double getl2 = (this.y3 - this.y4) * this.x3 + (this.x3 - this.x4) * this.y3;
            return getl2 != -0.0 ? getl2 : 0.0;
        }

        public double getEdgeY(){

            double lcmn = 2, div, y;
            while( lcmn % (this.y1 - this.y2) != 0 || lcmn % (this.y3 - this.y4) != 0){
                lcmn++;
            }

            div = (this.x2 - this.x1) * (lcmn/(this.y1 - this.y2)) - (this.x4 - this.x3) * (lcmn/(this.y3 - this.y4));
            y = ( getline1() * (lcmn/(this.y1 - this.y2)) - getline2() * (lcmn/(this.y3 - this.y4)) )/div;

            return y != -0.0 ? y : 0.0;
        }

        public double getEdgeX(){
            double x = ( getline1() + (this.x1 - this.x2) * getEdgeY() ) / (this.y1 - this.y2);
            return x != -0.0 ? x : 0.0;
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
        x = x != -0.0 ? x : 0.0;
        y = y != -0.0 ? y : 0.0;
        System.out.printf( "The intersecting point is: (%.1f, %.1f)\n", x, y );

    }

}

