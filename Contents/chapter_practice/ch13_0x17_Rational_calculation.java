import java.util.Scanner;

public class Main {

    interface Cloneable{
        public abstract String toString();
    }
    static class Complex implements Cloneable{
        private double a, b;
        private double integer, real;

        public Complex(){

        }
        public Complex(double a, double b){
            this.a = a;
            this.b = b;
        }

        public double getInteger() {
            return integer;
        }

        public double getReal() {
            return real;
        }

        public String add(Complex cpx2){
            integer = this.a + cpx2.a;
            real = this.b + cpx2.b;

            return String.valueOf(integer) + " + " + String.valueOf(real) + "i";

        }

        public String substract(Complex cpx2){
            integer = this.a - cpx2.a;
            real = this.b - cpx2.b;

            return String.valueOf(integer) + " + " + String.valueOf(real) + "i";

        }

        public String multiply(Complex cpx2){
            integer = (this.a * cpx2.a - this.b * cpx2.b);
            real = (this.b * cpx2.a + this.a * cpx2.b);

            return String.valueOf(integer) + " + " + String.valueOf(real) + "i";

        }

        public String divide(Complex cpx2){
            integer = (this.a * cpx2.a + this.b * cpx2.b)/(cpx2.a * cpx2.a + cpx2.b * cpx2.b);
            real = (this.b * cpx2.a - this.a * cpx2.b)/(cpx2.a * cpx2.a + cpx2.b * cpx2.b);

            return String.valueOf(integer) + " + " + String.valueOf(real) + "i";

        }

        public String toString(){
            double tmpa = a, tmpb = b;

            String as = String.valueOf(tmpa);
            String bs = String.valueOf(tmpb);
            if(b != 0){
                return "(" + as + " + " + bs + "i)";
            }
            else{
                return "(" + as + ")";
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] num = new double[4];

        for(int i = 0; i < 4; i++){
            num[i] = input.nextDouble();
        }

        Complex cpx1 = new Complex(num[0], num[1]);
        Complex cpx2 = new Complex(num[2], num[3]);

        System.out.println(cpx1.toString() + " + " + cpx2.toString() + " = " + cpx1.add(cpx2));
        System.out.println(cpx1.toString() + " - " + cpx2.toString() + " = " + cpx1.substract(cpx2));
        System.out.println(cpx1.toString() + " * " + cpx2.toString() + " = " + cpx1.multiply(cpx2));
        System.out.println(cpx1.toString() + " / " + cpx2.toString() + " = " + cpx1.divide(cpx2));
    }
}