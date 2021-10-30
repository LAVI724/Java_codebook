/*
正多邊形為帶有n個邊，各邊等長，各角度也相同的多邊形(也就是說正多邊形等邊且等角)。計算正多邊形面積的公式為
A = (n*s^2) / 4*tan(pi/n)

請撰寫一程式，使用者輸入邊數，以及正多邊形的邊長，接著顯示其面積。

輸入
n=邊數: 5
s=邊長: 6.5

輸出
74.69017017488385
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        double n = input.nextDouble();  
        double s = input.nextDouble();  
  
        // java 有內建 tan 和 PI 在 Math 裡 太酷了ㄅ  
        System.out.println( (n*s*s) / (4*Math.tan(Math.PI/n)) );  
    }  
}  