/*
請撰寫一個程式，讀取0-1000其中一位數，然後將其的每一位數相乘。

輸入
為一介於0<= num <=1000的Integer

輸出
形態為Integer
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        String str = input.nextLine();  
          
        // 先把字串內的每位數單獨拆分進 array 內  
        String[] array = str.split("");  
  
        Integer ans = new Integer(1);  
        for( int i = 0; i < str.length(); i++ ){  
              
            // 用 Integer.parseInt() 把 array[i] 內的字符轉數字  
            ans = Integer.parseInt(array[i]) * ans;  
        }  
  
        System.out.println(ans);  
    }  
}