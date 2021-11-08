/*
請撰寫一程式，讀取一連串的整數，找出其最大值，並計算該值出現的次數
*/

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Integer> num = new Vector<Integer>();

        // 用 vector 來放輸出
        while(input.hasNextInt()){
            int n = input.nextInt();
            num.add(n);
        }
        // 找最大值和出現次數
        int maxi = 0, count = 1;
        for (Integer integer : num) {
            if (integer > maxi) {
                count = 1;
                maxi = integer;
            } else if (integer == maxi) {
                count++;
            }
        }
        System.out.println(maxi + " " + count);
    }
}
