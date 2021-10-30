/*
請撰寫一程式，提示使用者輸入月份與年份，接著顯示該月份的天數。 舉個例子，如果使用者月份輸入2，年份輸入2012，此程式應顯示"February 2012 had 29 days"。如果使用者月份輸入3，年份輸入2015，程式顯示"March 2015 had 31 days"。
*/

import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int month = input.nextInt();  
        int year = input.nextInt();  
  
        // 分別存 30 天的月份 和 31 天的月份 以及他們的英文月份名  
        int[] thirty = {1,3,5,7,8,10,12};  
        String[] thirty_eng = {"January", "March", "May", "July", "August", "October", "December"};  
  
        int[] thirty_one = {4,6,9,11};  
        String[] thirty_one_eng = {"April", "June", "September", "November"};  
  
        // 查詢他是否是 30 天的月份  
        // 最後放 return 後面的其他程式碼就不會執行了  
        for( int i = 0; i < thirty.length; i++){  
            if(month == thirty[i]){  
                System.out.println(thirty_eng[i] + " " + year + " had 31 Days" );  
                return;  
            }  
        }  
        for( int i = 0; i < thirty_one.length; i++){  
            if(month == thirty_one[i]){  
                System.out.println(thirty_one_eng[i] + " " + year + " had 31 Days" );  
                return;  
            }  
        }  
        if( year % 4 == 0){  
            System.out.println("February " + year + " had 29 Days");  
            return;  
        }  
        System.out.println("February " + year + " had 28 Days");  
  
    }  
}