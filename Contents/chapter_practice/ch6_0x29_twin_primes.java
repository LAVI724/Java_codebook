/*
Twin primes are a pair of prime numbers that differ by 2. For
example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are
twin primes
Find all twin primes under 1000
*/

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        // 先建質數表 ( 預設初值很大
        boolean[] prime = new boolean[1000];
        Vector<Integer> pri = new Vector<Integer>();
        for( int i = 2; i < 1000; i++ ){
            if( !prime[i] ){
                pri.add(i);
                for( int j = i*i; j < 1000; j += i ){
                    prime[j] = true;
                }
            }
        }

        for( int i = 0; i < pri.size()-1 ; i++ ){
            if( pri.get(i+1) - pri.get(i) == 2 ){
                System.out.printf("(%d, %d)", pri.get(i), pri.get(i+1));
                System.out.print( i != pri.size()-2 ? "\n" : "");
            }
        }
    }
}
