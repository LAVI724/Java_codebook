/*
為了要便於中序轉後序的程式運行，請先將算式的數字與運算符號做分割
1. 使用String類別 & 字串輸入
2. 使用StringTokenizer類別 或 String類別之split()method來切割中序運算式。
3. 使用String［］array 儲存所有tokens。
4. 將數字token轉換成實數，加總後輸出總和。Hint: Use BigDecimal in java.math package

輸入
每組測資會給予不一定長度的算式，符號包含+,-,*,/,(,),%，算式中數字可以是實數或整數型態。 

輸出
第一行輸出運算式的每個運算元，運算元間以空格字元隔開。
第二行輸出運算式的每個運算子，運算子間以空格字元隔開。
第三行印出運算元的總和，小事點以下印三位。
*/

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        String str = input.nextLine();  
        String token = "+-*/()%";  
  
        // 當字串中帶有 + * | \ 等符號時要寫 \\ 轉義，因為他們在正則表達示中有相應的不同意義  
        // limit is 0; array contains all substrings  
        // Positive Lookahead or Lookbehind 觀念  
        // “((?=@)|(?<=@))” -> 才會把 運算子 還有 運算元 都單獨切開  
        String[] array = str.split("((?=\\+|-|\\*|/|\\)|\\(|%)|(?<=\\+|-|\\*|/|\\)|\\(|%))",0);  
  
        // 預設 ans 賦值 可控制小數點位數 ex 0.000 -> 小數點後三位  
        BigDecimal ans = new BigDecimal("0.000");  
  
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
        System.out.println();  
  
        flag = true;  
        for( String again : array){  
            if( token.contains(again) ){  
                System.out.print( flag ? again : " " + again);  
                flag = false;  
            }  
        }  
        System.out.println();  
          
        // BigDecimal 四捨五入的寫法 .setScale( 想要留取的位數, RoundingMode.HALF_UP)  
        System.out.println(ans.setScale(3, RoundingMode.HALF_UP));  
    }  
} 