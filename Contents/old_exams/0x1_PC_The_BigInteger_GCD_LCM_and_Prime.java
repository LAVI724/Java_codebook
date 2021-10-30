/*
請利用BigInteger解題，不然不予給分

Problem
請輸入兩個數字M、N，找出M、N的最大公因數(GCD – Greatest Common Divisor) G及最小公倍數(LCM – Least Common Multiple)L，並找出大於L的前5個可能質數(Prime)。

Input
輸入有多筆測資，每列代表一組測資，每組測資會有兩個數字M、N (數值可能會超過long可儲存的範圍)

Output
第一列先輸出兩數的最大公因數 G及最小公倍數L，第二列再輸出大於L的前5個可能質數，每個質數間以一個空格格開。
*/

import java.math.BigInteger;  
import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        BigInteger M, N, G, L;  
          
        while( input.hasNextBigInteger() ) {  
              
            M = input.nextBigInteger();  
            N = input.nextBigInteger();  
              
            // BigInteger 內建函數 gcd  
            G = M.gcd(N);  
            // L = M * N / G  
            L = M.multiply(N).divide(G);  
            System.out.print(G + " " + L + "\n");  
  
            for( int i = 0; i < 5; i++){  
                  
                // .nextProbablePrime -> 返回一個大於該 BigInteger 的質數  
                System.out.print( i == 4 ? L.nextProbablePrime() + "\n" : L.nextProbablePrime() + " ");  
                L = L.nextProbablePrime();  
            }  
        }  
    }  
} 