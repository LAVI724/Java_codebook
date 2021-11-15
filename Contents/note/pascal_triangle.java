import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        BigInteger[] triangle = new BigInteger[n+5];
        Arrays.fill(triangle, BigInteger.ONE);

        for( int i = 0; i <= n; i++ ){
            for( int j = i; j >0; j-- ){
                triangle[j] = triangle[j].add(triangle[j-1]);
            }
            for( int j = n-i; j > 0; j-- ){
                System.out.print(" ");
            }
            for( int j = 0; j <= i; j++ ){
                System.out.printf(" %d", triangle[j]);
                if( i % 2 == 0 && i != 0 && j == i ){
                    break;
                }
            }
            if( i != 0 ){
                System.out.print(" 1");
            }
            System.out.println();
        }
    }
}
