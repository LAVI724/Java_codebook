import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static class Rational {
        private BigInteger a, b;

        public Rational(BigInteger a, BigInteger b){
            this.a = a;
            this.b = b;

            BigInteger gcd = this.a.gcd(this.b);
            this.a = this.a.divide(gcd);
            this.b = this.b.divide(gcd);
        }

        public Rational add(Rational r2){
            BigInteger n1 = a.multiply(r2.b);
            BigInteger n2 = b.multiply(r2.a);

            BigInteger n = n1.add(n2);
            BigInteger d = b.multiply(r2.b);
            return new Rational(n, d);
        }

        // 要先轉 double 再除 不然會失去小數
        public double ans(){
            double n = Double.parseDouble(String.valueOf(this.a));
            double d = Double.parseDouble(String.valueOf(this.b));
            return n/d;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rational r = new Rational(BigInteger.ONE, BigInteger.TWO);

        int n = input.nextInt();
        BigInteger cnt = BigInteger.valueOf(3);

        for(int i = 3; i <= n/2 + 1; i++, cnt = cnt.add(BigInteger.TWO)){
            r = r.add(new Rational(cnt, cnt.add(BigInteger.ONE)));
        }
        System.out.println(r.ans());
    }
}
