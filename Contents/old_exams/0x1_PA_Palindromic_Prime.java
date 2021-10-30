/*
Palindromic Prime 指數字為一質數並且迴文，請撰寫一個找出迴文質數的程式。 Ex: 757 與 313 為迴文質數

Input Format
每組測資為一整數 N，請注意本題輸入數字的數目不定。

Output Format
請輸出前 N 個 Palindromic Prime(由 2 開始)。輸出的方式為每行顯示 10 個數字，每行數字間以空格分開，但最後一個數字不用空格直接換行。

Technical Specification
• 0 ≤ N ≤ 100
*/

import java.util.Arrays;  
import java.util.Scanner;  
import java.util.Vector;  
  
public class Main {  
  
    public static void main(String[] args) {  
  
        // 直接在最開始就建好質數表  
        boolean[] prime = new boolean[100000+5];  
        Arrays.fill(prime,false);  
        Vector<String> v = new Vector<String>();  
  
        for( int i = 2; i <= 100000; i++ ){  
  
            if(!prime[i]){  
                // 因為 100000 * 100000 會超出 int 所以用 long   
                // i * i 是 int -> 強制轉型 (long)  
                for(long j = (long) i * i; j <= 100000; j += i ) {  
                    // prime 的指標是放 int   
                    prime[(int) j] = true;  
                }  
  
                // 先把 i 轉成 String ( 因為這樣比較方便 reverse )  
                String str = String.valueOf(i);  
  
                // 使用 StringBuilder 宣告 rev -> 因為 StringBuilder 才有 .reverse() 可以用  
                StringBuilder rev = new StringBuilder();  
                // 這裡 append (附加) str 的值給 rev  
                rev.append(str);  
                // reverse  
                rev.reverse();  
  
                // 兩字串判斷相等在 java 要用 .equals 不能直接 == ( 原因跟記憶體位址有關  
                // 然後因為 rev 是 StringBuilder 但 .equals 是 String 的 所以要 .toString()  
                if( str.equals(rev.toString()) ){  
                    v.add(str);  
                }  
  
            }  
        }  
  
        Scanner input = new Scanner(System.in);  
  
        // 重複輸入寫法  
        while( input.hasNextInt() ){  
            int n = input.nextInt();  
  
            if( n == 0 ){  
                System.out.println();  
                continue;  
            }  
  
            for( int i = 0, k = 0; i < n; i++, k++ ){  
                if( k == 9 || i == n - 1 ){  
                    System.out.println(v.get(i));  
                    k = -1;  
                }  
                else{  
                    System.out.print(v.get(i) + " ");  
                }  
            }  
        }  
    }  
} 