/*
請讀取不一定數量的整數，直到0結束，然後分別顯示奇數與偶數的個數
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[100000];

        int i = 0;
        while( input.hasNextInt() ){
            num[i++] = input.nextInt();
            if( num[i-1] == 0 ){
                break;
            }
        }

        int cnto = 0, cnte = 0;
        for( int j = 0; j < i-1; j++ ){
            if( num[j] % 2 == 0 ){
                cnte++;
            }
            else{
                cnto++;
            }
        }
        System.out.printf("The number of odd numbers:%d\nThe number of even numbers:%d\n", cnto, cnte );
    }
}
