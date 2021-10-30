/*
請撰寫一程式，使用者輸入二進位數字，然後印出其對應的十進位數字。 輸入 0111 1001 1100 輸出 7 9 12
*/

import java.util.Scanner;  
import java.util.StringTokenizer;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        String bin = input.nextLine();  
        StringTokenizer st = new StringTokenizer( bin, " " );  
  
        while(st.hasMoreTokens()){  
            int two = 1, deci = 0;  
            String str = st.nextToken();  
            for( int i = str.length()-1; i >= 0; i-- ){  
                deci += ( str.charAt(i) - '0' )*two;  
                two *= 2;  
            }  
            System.out.println(deci);  
        }  
  
    }  
}  