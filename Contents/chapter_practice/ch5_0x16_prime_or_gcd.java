/*
請撰寫一程式，讀取一個整數，並以遞增的順序顯示所以的因數。 比方說，假設輸入整數為120，此程式的輸出結果應該是要2、2、2、3、5。
但當輸入的整數為質數時，需輸出1與輸入的質數。
此題假設1為質數
*/

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        boolean[] prime = new boolean[10000000+5];
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for( int i = 2; i <= n; i++ ){
            if(!prime[i]){
                for( int j = i * i; j <= n; j += i ){
                    prime[j] = true;
                }
            }
        }

        if( !prime[n] ){
            System.out.println("1 " + n );
        }
        else{
            int num = n;
            for( int i = 2; i < n; i++ ){
                while( num % i == 0 ){
                    num /= i;
                    System.out.print( num != 1 ? i + " " : i + "\n" );
                }
                if( num == 1 ){
                    break;
                }
            }
        }
    }
}
