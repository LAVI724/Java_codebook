/*
Palindrome integer
Write the methods with the following headers:

//Return the reversal of an integer, e.g., reverse(456) returns 654
public static int reverse(int number)

//Return true if number is a palindrome
public static boolean isPalindrome(int number)

Use the reverse method to implement isPalindrome. A number is a palindrome if its reversal is the same as itself. Write a test program that prompts the
user to enter an integer and reports whether the integer is a palindrome.
*/

import java.util.Scanner;

public class Main {

    public static int reverse( int number ){
        String str = Integer.toString(number);
        
        // 用 stringbuiler 反轉
        StringBuilder st = new StringBuilder();
        st.append(str);
        st.reverse();
        
        // 回傳 int 型態
        return Integer.parseInt(st.toString());
    }
    public static boolean isPalindrome( int number ){
        // 將數字反轉
        int revn = reverse(number);

        // 判斷是否為回文
        return revn == number;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        boolean ans = isPalindrome(n);

        if( ans ){
            System.out.println(n + " is palindrome");
        }
        else{
            System.out.println(n + " is not palindrome");
        }
    }
}
