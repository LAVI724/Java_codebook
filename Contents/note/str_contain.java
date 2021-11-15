boolean flag = true;
for( String check : array){

    // string.contains 一次查詢多個關鍵字的寫法 要另外存一個數組 token
    // 且在查詢時要以此 for ( String check : array ) 去做掃描
    if( !token.contains(check) ){

        // 將字串型態的數字轉成實數並相加
        BigDecimal b = new BigDecimal(check);

        // (boolean 判斷式) ? (true的輸出) : (false 的輸出)
        System.out.print( flag ? check : " " + check);
        flag = false;

        // BigDecimal 內建 .add 可以直接相加
        ans = ans.add(b);
    }
}

/*
找 BC 是 ABCD 的子字串
可以用 String.contains 找 
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