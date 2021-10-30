/*
請撰寫一程式，提示使用者輸入三角形的三個頂點座標(x1,y1)、(x2,y2)、(x3,y3)，並顯示計算後面積。計算三角形面積公式如下:
s = (a + b + c) /2 
A = √ s(s - a)(s - b)(s - c)

輸入
三角形三個點: 1.5 -3.4 4.6 5 9.5 -3.4
輸出
面積為33.600
 
輸出格式為小數點後三位
若三點不為三角形請輸出"Not Triangle"
*/

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.Arrays;  
import java.util.Scanner;  
  
public class Main {  
  
    private static Math Precision;  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;  
  
        x1 = input.nextDouble();  
        y1 = input.nextDouble();  
        x2 = input.nextDouble();  
        y2 = input.nextDouble();  
        x3 = input.nextDouble();  
        y3 = input.nextDouble();  
  
        double[] array = new double[3];  
        array[0] = Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) );  
        array[1] = Math.sqrt( Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2) );  
        array[2] = Math.sqrt( Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2) );  
  
        // 判斷是否為三角形  
        // Arrays.sort(陣列名稱) -> 自動排序  
        Arrays.sort(array);  
  
        if ( array[0] + array[1] <= array[2] ){  
            System.out.println("Not Triangle");  
        }  
        else{  
            // 海龍公式  
            double s = 0;  
            for( int i = 0; i < 3; i++ ){  
                s = s + array[i];  
            }  
            s = s / 2;  
  
            double a = 0;  
            a = Math.sqrt( s * (s-array[0]) * (s-array[1]) * (s-array[2]) );  
              
            // 利用 BigDecimal 去取小數點並四捨五入  
            BigDecimal ans = new BigDecimal(a);  
            System.out.println( ans.setScale(3, RoundingMode.HALF_UP));  
        }  
  
  
    }  
}