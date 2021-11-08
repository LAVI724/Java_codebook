/*
撰寫一程式，提示使用者輸入一年份，然後判斷它是否為閏年，當輸入-1時，則結束程式的執行
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){
            int n = input.nextInt();
            if( n < 0 ){
                break;
            }
            // 閏年的規律
            else if( n % 4 == 0 && n % 100 != 0){
                System.out.println("It is leap year.");
            }
            else {
                if (n % 400 == 0) {
                    System.out.println("It is leap year.");
                } else {
                    System.out.println("It is not leap year.");

                }
            }
        }
    }
}
