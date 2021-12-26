import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static class Rational {
        private BigInteger a, b;

        public Rational(double a, double b){
            this.a = BigInteger.valueOf((long) a);
            this.b = BigInteger.valueOf((long) b);

            BigInteger gcd = this.a.gcd(this.b);
            this.a = this.a.divide(gcd);
            this.b = this.b.divide(gcd);
        }

        public Rational add(Rational r2){
            BigInteger n = a.multiply(r2.b).add(b.multiply(r2.a));
            BigInteger d = b.multiply(r2.b);
            return new Rational(Double.parseDouble(String.valueOf(n)), Double.parseDouble(String.valueOf(d)));
        }

        public Rational sub(Rational r2){
            BigInteger n = a.multiply(r2.b).subtract(b.multiply(r2.a));
            BigInteger d = b.multiply(r2.b);
            return new Rational(Double.parseDouble(String.valueOf(n)), Double.parseDouble(String.valueOf(d)));
        }

        public Rational multiply(Rational r2){
            BigInteger n = a.multiply(r2.a);
            BigInteger d = b.multiply(r2.b);
            return new Rational(Double.parseDouble(String.valueOf(n)), Double.parseDouble(String.valueOf(d)));
        }

        public Rational divide(Rational r2){
            BigInteger n = a.multiply(r2.b);
            BigInteger d = b.multiply(r2.a);
            return new Rational(Double.parseDouble(String.valueOf(n)), Double.parseDouble(String.valueOf(d)));
        }

        public String toString(){
            if(b.equals(BigInteger.ONE)){
                return a + "";
            }
            else{
                return a + "/" + b;
            }
        }
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Rational r1 = new Rational(input.nextDouble(), input.nextDouble());
       Rational r2 = new Rational(input.nextDouble(), input.nextDouble());

       System.out.println(r1.toString() + " + " + r2.toString() + " = " + r1.add(r2).toString());
       System.out.println(r1.toString() + " - " + r2.toString() + " = " + r1.sub(r2).toString());
       System.out.println(r1.toString() + " * " + r2.toString() + " = " + r1.multiply(r2).toString());
       System.out.println(r1.toString() + " / " + r2.toString() + " = " + r1.divide(r2).toString());
    }
}
