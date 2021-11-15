/*
請撰寫一個方法，計算某整數個位數的乘積
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        long cnt = 1;
        for( int i = 0; i < str.length(); i++ ){
            cnt *= str.charAt(i) - '0';
        }

        System.out.println(cnt);
    }
}
