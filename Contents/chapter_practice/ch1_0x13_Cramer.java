/*
請利用克萊姆(Cramer)公式，嘗試解出2*2的線性方程式
ax + by = e
cx + dy = f

輸入：
輸入a b e 
與 c d f 分別代表兩個線性方程式的常數與答案
其形態皆為double

輸出：
請利用Cramer解出x與y二值
其形態皆為double
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        double x1 = 0, y1 = 0, a1 = 0, x2 = 0, y2 = 0, a2 = 0;  
  
        x1 = input.nextDouble();  
        y1 = input.nextDouble();  
        a1 = input.nextDouble();  
        x2 = input.nextDouble();  
        y2 = input.nextDouble();  
        a2 = input.nextDouble();  
  
        // 克萊姆公式  
        // [a b][x] = [e]  
        // [c d][y] = [f]  
        // x = ed - bf / ad - bc  
        // y = af - ec / ad - bc  
        double x = 0, y = 0;  
        x = ( ( a1 * y2 ) - ( y1 * a2 ) ) / ( ( x1 * y2 ) - ( y1 * x2 ) );  
        y = ( ( x1 * a2 ) - ( a1 * x2 ) ) / ( ( x1 * y2 ) - ( y1 * x2 ) );  
        System.out.println(x + " " + y);  
    }  
}  

