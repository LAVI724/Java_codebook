/*
請撰寫一個程式，提示使用者輸入一個點座標(x,y)，接著檢視該點座標是否位於中心點(0,0)，半徑為10的圓內(<=10)。
計算距離的公式

(x*x + y*y) 開根號

輸入
4 5
9 9

輸出
(4.0,5.0) is in the circle
(9.0,9.0) is not in the circle
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        double x = input.nextDouble();  
        double y = input.nextDouble();  
  
        //是否在半徑 10 以內  
        if( Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) ) <= 10 ){  
            // 如果要輸出 ("%f %d", a, b) 要用 -> System.out.printf  
            // %.1f 控制小數點後 1 位  
            System.out.printf("(%.1f,%.1f) is in the circle" ,x ,y);  
        }  
        else{  
            System.out.printf("(%.1f,%.1f) is not in the circle" ,x ,y);  
        }  
        System.out.println();  
    }  
}  