/*
請撰寫一程式，提示使用者輸入年份及該年份第一天為一星期的哪一天，接著顯示該年份的日曆表格
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int y, week, k = 0;
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        y = input.nextInt();
        week = input.nextInt();

        boolean flag = false;
        for( int i = 0; i < 12; i++ ){
            System.out.println( "          " + month[i] + " " + y + "\n" +
                    "-----------------------------\n" + " Sun Mon Tue Wed Thu Fri Sat");
            k = 0;
            for( int j = 1; j <= days[i]; k++){
                if( !flag && k != week ){
                    System.out.print("    ");
                    continue;
                }

                flag = true;
                if( k <= 6 ){
                    System.out.printf("%4d", j++);
                }
                else{
                    System.out.printf("\n%4d", j++);
                    k = 0;
                }
            }
            flag = false;
            if( k > 6 ){
                k = 0;
            }
            week = k;
            System.out.print( i!= 11 ? "\n\n" : "\n");
        }
    }

}
