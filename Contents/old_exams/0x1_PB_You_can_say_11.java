/*
給你一個正整數 N，判定它是否是 11 的倍數。提示: 在這裡，我們需要用到一個關於 11 倍
數的小常識，那就是：11 倍數的「奇數位數字和」與「偶數位數字和」兩者的差必定為 11 的
倍數。

Input Format
每列資料有一個正整數 N，N 最大可能到 1000 位數。若 N = 0 代表輸入結束

Output Format
先輸出奇數的和與偶數位的和，再對每一個輸入的數，輸出是否為 11 的倍數。輸出格式請

本題必須使用 char[] or String 儲存數入之正整數。
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        while( input.hasNext() ){  
            String str = input.nextLine();  
            if( str.equals("0") ){  
                break;  
            }  
  
            int even = 0, odd = 0;  
            for( int i = str.length()-1; i >= 0; i -= 2 ){  
                // 要抓字串中的每個 char 要 str.charAt()  
                // 要把 char 轉 int 蠻複雜的   
                // 要先 String.valueOf() 然後 Integer.parseInt  
                odd += Integer.parseInt( String.valueOf( str.charAt(i) ) );  
            }  
            for( int i = str.length()-2; i >= 0; i -= 2 ){  
                even += Integer.parseInt( String.valueOf( str.charAt(i) ) );  
            }  
  
            int sub = Math.abs( even - odd );  
            if( sub % 11 != 0){  
                System.out.println( odd + " " + even + "\n" + str + " is not a multiple of 11." );  
            }  
            else{  
                System.out.println( odd + " " + even + "\n" + str + " is a multiple of 11." );  
            }  
        }  
    }  
}  