import java.util.Scanner;

public class Main {

    static class QuadraticEquation {
        private double a, b, c;

        // constructor
        public QuadraticEquation( double a, double b, double c ){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant(){
            return Math.pow( this.b, 2 ) - 4 * this.a * this.c;
        }

        public double getRoot1(){
            // 要小心根號裡不可以是負值
            return ( -1 * this.b + Math.sqrt( Math.abs( getDiscriminant() ))) / ( 2 * this.a );
        }

        public double getRoot2(){
            return ( -1 * this.b - Math.sqrt( Math.abs( getDiscriminant() )))  / ( 2 * this.a );
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        QuadraticEquation qe = new QuadraticEquation( a, b, c);

        if( qe.getDiscriminant() == 0 ){
            System.out.println( "The root is " + qe.getRoot1() );
        }
        else if( qe.getDiscriminant() < 0 ){
            System.out.println("The equation has no roots");
        }
        else{
            System.out.println( "The roots are " + qe.getRoot1() + " and " + qe.getRoot2() );
        }

    }

}
