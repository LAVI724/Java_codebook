import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Rational {

        private int Molecular, Denominator;

        // 設立 consturctor 接收兩個整數參數為 分子/分母 的初值
        public Rational( int m, int d){
            this.Molecular = m;
            this.Denominator = d;
        }

        // 分別創立 Molecular、Denominator 的 get 和 set member methods
        public int getMolecular() {
            return this.Molecular;
        }
        public int getDenominator() {
            return this.Denominator;
        }
        // set member methods -> 為了讓 private 的參數可以使用的 member function
        public int setMolecular(){
            return this.Molecular;
        }
        public int setDenominator(){
            return this.Denominator;
        }

        // 整數的四則運算
        public Rational add( Rational rt2 ) {

            int d = this.Denominator * rt2.Denominator;
            int m = (( this.Molecular * ( d / this.Denominator )) + ( rt2.Molecular * ( d / rt2.Denominator )));

            BigInteger gcdn = BigInteger.valueOf(m).gcd( BigInteger.valueOf(d) );
            m =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m).divide(gcdn) ) );
            d =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d).divide(gcdn) ) );

            if( m == 0 || d == 0 ){
                return new Rational(0,0);
            }
            else if( m < 0 && d < 0 ){
                return new Rational( -m, -d );
            }
            return new Rational( m, d );
        }
        public Rational sub( Rational rt2 ){

            int d = this.Denominator * rt2.Denominator;
            int m = (( this.Molecular * ( d / this.Denominator )) - ( rt2.Molecular * ( d / rt2.Denominator )));

            BigInteger gcdn = BigInteger.valueOf(m).gcd( BigInteger.valueOf(d) );
            m =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m).divide(gcdn) ) );
            d =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d).divide(gcdn) ) );

            if( m == 0 || d == 0 ){
                return new Rational(0,0);
            }
            else if( m < 0 && d < 0 ){
                return new Rational( -m, -d );
            }
            return new Rational( m, d );
        }
        public Rational mul( Rational rt2 ){

            if( this.Molecular == 0 || this.Denominator == 0 || rt2.Molecular == 0 || rt2.Denominator == 0 ){
                return new Rational(0,0 );
            }

            int d = this.Denominator * rt2.Denominator;
            int m = ( this.Molecular * rt2.Molecular );

            BigInteger gcdn = BigInteger.valueOf(m).gcd( BigInteger.valueOf(d) );
            m =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m).divide(gcdn) ) );
            d =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d).divide(gcdn) ) );

            if( m == 0 || d == 0 ){
                return new Rational(0,0);
            }
            else if( m < 0 && d < 0 ){
                return new Rational( -m, -d );
            }
            return new Rational( m, d );
        }
        public Rational div( Rational rt2 ){

            if( this.Molecular == 0 || this.Denominator == 0 || rt2.Molecular == 0 || rt2.Denominator == 0 ){
                return new Rational(0,0 );
            }

            // 除法的四則運算我喜歡倒數相乘
            int tmp = rt2.Molecular;
            rt2.Molecular = rt2.Denominator;
            rt2.Denominator = tmp;
            
            if( rt2.Molecular < 0 || rt2.Denominator < 0){
                rt2.Denominator = -rt2.Denominator;
                rt2.Molecular = -rt2.Molecular;
            }

            int d = this.Denominator * rt2.Denominator;
            int m = ( this.Molecular * rt2.Molecular );

            BigInteger gcdn = BigInteger.valueOf(m).gcd( BigInteger.valueOf(d) );
            m =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m).divide(gcdn) ) );
            d =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d).divide(gcdn) ) );

            if( m == 0 || d == 0 ){
                return new Rational(0,0);
            }
            else if( m < 0 && d < 0 ){
                return new Rational( -m, -d );
            }
            return new Rational( m, d );

        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while ( input.hasNextLine() ){
            String oper = input.nextLine();
            String a = input.nextLine();
            String b = input.nextLine();

            StringTokenizer st1 = new StringTokenizer( a, "()/ ");
            int m1 = Integer.parseInt( st1.nextToken() );
            int d1 = Integer.parseInt( st1.nextToken() );

            StringTokenizer st2 = new StringTokenizer( b, "()/ ");
            int m2 = Integer.parseInt( st2.nextToken() );
            int d2 = Integer.parseInt( st2.nextToken() );

            Rational rt1 = new Rational( m1, d1 );
            Rational rt2 = new Rational( m2, d2 );

            BigInteger gcdn = BigInteger.valueOf(m1).gcd( BigInteger.valueOf(d1) );
            m1 =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m1).divide(gcdn) ) );
            d1 =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d1).divide(gcdn) ) );

            gcdn = BigInteger.valueOf(m2).gcd( BigInteger.valueOf(d2) );
            m2 =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m2).divide(gcdn) ) );
            d2 =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d2).divide(gcdn) ) );

            System.out.print( ( m1 % d1 != 0 ? "(" + m1 + "/ " + d1 + ")" : m1/d1 ) + " " + oper + " " + ( m2 % d2 != 0 ? "(" + m2 + "/ " + d2 + ")" : m2/d2 ) + " = ");

            // 用 switch 做切換 感謝 intelij 的自動排版
            if( oper.equals("+") ){
                // 要設立一個 Ration div 去接回傳回來的 Rational class 型態
                // 之後取 Molecular 和 Denominator 都是用他去接
                Rational div = rt1.add(rt2);
                if( div.Molecular == 0 ){
                    System.out.println("0");
                }
                else if( div.Molecular % div.Denominator == 0 ){
                    System.out.println(div.Molecular / div.Denominator);
                }
                else{
                    System.out.println("(" + div.Molecular + "/ " + div.Denominator + ")");
                }
            }
            else if ( oper.equals("-") ){

                Rational div = rt1.sub(rt2);
                if( div.Molecular == 0 ){
                    System.out.println("0");
                }
                else if( div.Molecular % div.Denominator == 0 ){
                    System.out.println(div.Molecular / div.Denominator);
                }
                else{
                    System.out.println("(" + div.Molecular + "/ " + div.Denominator + ")");
                }
            }
            else if ( oper.equals("*") ){

                Rational div = rt1.mul(rt2);
                if( div.Molecular == 0 ){
                    System.out.println("0");
                }
                else if( div.Molecular % div.Denominator == 0 ){
                    System.out.println(div.Molecular / div.Denominator);
                }
                else{
                    System.out.println("(" + div.Molecular + "/ " + div.Denominator + ")");
                }
            }
            else{
                Rational div = rt1.div(rt2);
                if( div.Molecular == 0 ){
                    System.out.println("0");
                }
                else if( div.Molecular % div.Denominator == 0 ){
                    System.out.println(div.Molecular / div.Denominator);
                }
                else{
                    System.out.println("(" + div.Molecular + "/ " + div.Denominator + ")");
                }
            }
        }
    }
}
