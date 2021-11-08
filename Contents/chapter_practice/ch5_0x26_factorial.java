/*
e = 1/0! + 1/1! + 1/2! + ... 1/n!
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 設個陣列存每階的值
        double[] e = new double[10000000+5];
        e[0] = 1;
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        double ans = 1;
        for( long i = 1; i <= n; i++ ){
            // i! = i*(i-1)!
            e[(int)i] = i * e[(int)i-1];
            ans += 1/e[(int)i];
        }
        System.out.println(ans);
    }
}
