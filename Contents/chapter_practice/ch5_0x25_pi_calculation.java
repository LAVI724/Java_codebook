/*
pi = 4( 1 + 1/3 - 1/5 + 1/7 +... + (-1)^i+1^/2*i-1)
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        double pi = 0;
        for( int i = 1; i <= n; i++ ){
            // 依據題意
            pi += Math.pow(-1.0, (double)i+1)/(2*i-1);
        }
        System.out.println(pi*4);

    }
}
