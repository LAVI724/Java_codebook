/*
請撰寫一程式，使用者輸入二個字串，然後顯示二個字串是否為第一個字串的子字串。 
輸入 string s1:ABCD string s2:BC 
輸出 BC is a substring of ABCD

輸入 string s1:ABCD string s2:CA
輸出 CA is not a substring of ABCD
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        String str = input.nextLine();  
  
        // 已確認 : 切割後的空白不會存進 array  
        String[] array = str.split(" ");  
  
        // 原來可以用 str.contains 去找子字串 我還以為只能找字元..  
        if(array[0].contains(array[1])){  
            System.out.println(array[1] + " is a substring of " + array[0]);  
        }  
        else{  
            System.out.println(array[1] + " is not a substring of " + array[0]);  
        }  
  
    }  
}  