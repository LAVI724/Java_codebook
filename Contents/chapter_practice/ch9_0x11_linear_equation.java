import java.util.Scanner;

public class Main {

    static class LinearEquation {
        private double a, b, c, d, e, f;

        public LinearEquation( double a, double b, double c, double d, double e, double f ){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public boolean isSolvable(){
            return this.a * this.d - this.b * this.c != 0;
        }

        public double getX(){
            return ( this.e * this.d - this.b * this.f ) / ( this.a * this.d - this.b * this.c );
        }

        public double getY(){
            return ( this.a * this.f - this.e * this.c ) / ( this.a * this.d - this.b * this.c );
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c, d, e, f;

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        e = input.nextDouble();
        f = input.nextDouble();

        LinearEquation le = new LinearEquation( a, b, c, d, e, f );

        if( le.isSolvable() ){
            System.out.println( "x is " + le.getX() + " and y is " + le.getY() );
        }
        else{
            System.out.println( "The equation has no solution" );
        }

    }

}
