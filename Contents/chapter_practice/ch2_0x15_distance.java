/*
請撰寫一個程式，提示使用者輸入兩點座標(x1,y1)及(x2,y2)，並顯示兩點間的距離。 請注意，您可以利用Math.pow(a,0.5)來計算√a。

輸入
x1,y1: 1.5 -3.4
x2,y2: 4 5

輸出
8.764131445842194
 
計算兩點間距離的公式為
(x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) 開根號
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