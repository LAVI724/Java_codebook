/*
請撰寫一程式計算序列總和
1/3 + 2/4 +... i/(i+2)
*/

public class Main {

    public static void main(String[] args) {

        double[] m = new double[20+1];
        for( int i = 1; i <= 20; i++ ){
            for( double j = 1; j <= i; j++ ){
                m[i] += j/(j+2);
            }
        }

        System.out.printf("%4s%20s\n", "i", "m(i)");
        for( int i = 1; i <= 20; i++ ){
            System.out.printf("%4d%20.4f\n", i, m[i]);
        }
    }
}
