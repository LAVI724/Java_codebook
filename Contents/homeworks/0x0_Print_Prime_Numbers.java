/*
Write a program to input an integer N and print all prime numbers less than N.
Please print 10 prime numbers in each line.
*/

import java.util.Scanner;  
import java.util.Vector;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int n = input.nextInt();  
  
        // 建質數表  
        // java 中沒有全域變數 所以這邊建表目前是每次輸入都重建一次 但不夠漂亮  
        boolean[] prime = new boolean[10000000+5];  
  
        // 用 vector 存質數們  
        Vector<Integer> v = new Vector<Integer>();  
        for( int i = 2; i <= n; i++ ){  
            if(!prime[i]){  
                v.add(i);  
                for( int j = i * i; j <= n; j += i ){  
                    prime[j] = true;  
                }  
            }  
        }  
  
        for( int i = 0, k = 0; i < v.size(); i++, k++ ){  
  
            if( k == 9 || i == v.size() - 1){  
                System.out.println(v.get(i));  
                // 把 k 歸回去 -1 是因為下次輪迴會先 k++  
                k = -1;  
            }  
            else{  
                System.out.print(v.get(i) + " ");  
            }  
        }  
        v.clear();  
    }  
}  