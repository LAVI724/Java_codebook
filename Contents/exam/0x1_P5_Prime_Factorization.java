/*
Problem
輸入數字 N (資料型態為 Integer)， 請輸出該數字的所有質因數及其次方。例如 N=360=23 *32 *5。此題數字可能會有質數出現。

Requirement
請撰寫以下兩個 static methods： (未依規定，以 0 分計)

1. boolean [] PrimeArray(long N) {….}
    which returns an array A of Boolean values, where A[i] is true if i is a prime number, otherwise, A[i] is false if i is not a prime number. Note that A.length = N+1; Hint: if n is a prime number, then n * j is not a prime, where j >= 2;

2. String PrimeFactorization(long N) {…}
    which returns a string of prime factorization for the number N. For example, if N = 360, the returned string is “2^3 * 3^2 * 5”.

Input
輸入有多列，每列有個整數 N，最多 1000 列。

Output
第一行輸出所有數字中之最大數X及其開根號整數X，其後針對每一組測資數字N， 輸出 N的質因數分解，將數字 N的所有質因數（及其次方）以小到大方式顯示出來，如質因 數之次方數大於 1，以^運算符號顯示，不同質因數間以 * 運算符號互相連接， *運算符號前 後加空格。
*/

import java.util.Arrays;  
import java.util.Scanner;  
  
public class Main {  
  
    public static boolean [] PrimeArray(long N){  
  
        boolean[] prime = new boolean[1000000];  
        Arrays.fill(prime, true);  
  
        for( long i = 2; i <= N; i++ ){  
            if(prime[(int)i]){  
                for( long j = i * i; j <= N; j += i ){  
                    prime[(int)j] = false;  
                }  
            }  
        }  
        return prime;  
    }  
    public static String PrimeFactorization(long N){  
  
        int[] num = new int[1000000];  
        Arrays.fill( num, 0 );  
  
        long count = N;  
        for( int i = 2; i < N; i++ ){  
            while( count % i == 0 ){  
                num[i]++;  
                count /= i;  
            }  
            if( count == 1 ){  
                break;  
            }  
        }  
  
        // 因數轉字串處理  
        String[] tp = new String[1000000];  
        int j = 0;  
        for( int i = 2; i < N; i++ ){  
            if( num[i] != 0 ){  
                tp[j++] = Integer.toString(i);  
                if( num[i] != 1 ){  
                    tp[j++] = "^";  
                    tp[j++] = Integer.toString(num[i]);  
                }  
                tp[j++] = " * ";  
            }  
        }  
  
        // 合併字串 用 str1.concat(str2)  
        // 因為最後會多一組 * 所以j-1  
        String result = "";  
        for( int i = 0; i < j-1; i++ ){  
            result = result.concat(tp[i]);  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int max = 0;  
        int[] N = new int[1000+5];  
        int k = 0;  
  
        while( input.hasNextLong() ) {  
  
            N[k] = input.nextInt();  
            if (N[k] > max) {  
                max = N[k];  
            }  
            k++;  
        }  
  
  
        // 可以用 method 回傳陣列 但也要用陣列接他的回傳值  
        boolean[] A = PrimeArray(max);  
        System.out.println(max + " " + (int)Math.sqrt(max) );  
        for( int o = 0; o < k; o++ ){  
  
            if( A[N[o]] ){  
                System.out.println(N[o]);  
            }  
            else{  
                String factorization = PrimeFactorization(N[o]);  
                System.out.println(factorization);  
            }  
        }  
    }  
} 