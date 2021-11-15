/*
An emirp (prime spelled backward) is a nonpalindromic prime number
whose reversal is also a prime. For example, 17 is a prime and 71 is a prime, so
17 and 71 are emirps. Write a program that displays the first 120 emirps. Display
10 numbers per line, separated by exactly one space, as follows:
13 17 31 37 71 73 79 97 107 113
149 157 167 179 199 311 337 347 359 389
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
        int[] pal = new int[120];
        for( int i = 13, cnt = 0; cnt < 120; i++ ){
            if( !prime[i] ){

                StringBuilder rev = new StringBuilder();
                rev.append(i);
                rev.reverse();

                if( !prime[ Integer.parseInt(rev.toString()) ] && Integer.parseInt(rev.toString()) != i ){
                    pal[cnt++] = i;
                }
            }
        }

        for( int i = 0, k = 0; i < 120; i++, k++ ){
            if(k == 9){
                k = -1;
                System.out.println(pal[i]);
            }
            else{
                System.out.print(pal[i] + " ");
            }
        }
    }
}
