/*
你的任務是，給你一個正整數 N，判定它是否是 11 的倍數。

Input
每列資料有一個正整數N，N 最大可能到 1000 位數。
若 N = 0 代表輸入結束。

Output
對每個輸入的數，輸出是否為 11 的倍數。輸出格式請參考 Sample Output。
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
  
        Scanner input = new Scanner(System.in);  
  
        // java 中要用 .hasNext() 來判斷是否輸入結束  
        while( input.hasNext() ){  
  
            // String 的 input 是 .nextLine()  
            String str = input.nextLine();  
  
            // java 用 == 進行比較的時候，比較的是他們在記憶體中的存放地址  
            // 而 String,Integer,Date 這些類中 equals 可以用來做比較  
            if( str.equals("0") ){  
                break;  
            }  
  
            boolean flag = false;  
            int first = 0, second = 0;  
            for( int i = 0; i < str.length(); i++ ){  
  
                if( flag ){  
                    first += Integer.parseInt( String.valueOf( str.charAt(i) ) );  
                    flag = false;  
                }  
                else{  
                    second += Integer.parseInt( String.valueOf( str.charAt(i) ) );  
                    flag = true;  
                }  
            }  
  
            // java 的 abs 前面要加 Math.  
            if( Math.abs( first - second ) % 11 == 0 ){  
                System.out.printf("%s is a multiple of 11.\n", str );  
            }  
            else{  
                System.out.printf("%s is not a multiple of 11.\n", str );  
            }  
        }  
  
    }  
}  