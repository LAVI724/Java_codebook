/*
迴文質數，請輸入要顯示到前幾個迴文質數
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // 先建質數表 ( 預設初值很大
        boolean[] prime = new boolean[100000];
        for( long i = 2; i < 100000; i++ ){
            if( !prime[(int)i] ){
                for(long j = i*i; j < 100000; j += i ){
                    prime[(int)j] = true;
                }
            }
        }

        // pal 用來放是回文的數
        int[] pal = new int[n];
        for( int i = 2, cnt = 0; cnt < n; i++ ){
            if( !prime[i] ){

                StringBuilder rev = new StringBuilder();
                rev.append(i);
                rev.reverse();

                if( rev.toString().equals(Integer.toString(i)) ){
                    pal[cnt++] = i;
                }
            }
        }

        for( int i = 0, k = 0; i < n; i++, k++ ){
            if( k == 9 || i == n-1 ){
                k = -1;
                System.out.println(pal[i]);
            }
            else{
                System.out.print(pal[i] + " ");
            }
        }
    }
}
