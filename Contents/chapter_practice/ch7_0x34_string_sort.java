/*
public static String sort(String s)
For example, sort("acb") returns abc.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String sort (String s){

        // 為了用 java 內建的 Arrays.sort()
        // 這裡先將 string 轉成 array
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        // 因為 method 要回傳 String 型態 所以利用 stringbuilder 把 array 轉成 string
        StringBuilder str = new StringBuilder();
        for (char c : arr) {
            str.append(c);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        System.out.printf("Sorted string is %s\n", sort(s) );
    }
}
