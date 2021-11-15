/*
Implement the following two methods:

public static boolean isValid(double side1, double side2, double side3)

public static double area(double side1, double side2, double side3)

Write a test program that reads three sides for a triangle and uses the isValid
method to test if the input is valid and uses the area method to obtain the area.
The program displays the area if the input is valid. Otherwise, it displays that
the input is invalid.
*/

import java.util.Scanner;

public class Main {

    // 判斷是否為三角形
    public static boolean isValid( double side1, double side2, double side3 ){
        return side1 + side2 > side3;
    }

    // 計算面積
    public static double area( double side1, double side2, double side3 ){
        double s = (side1 + side2 + side3)/2;
        return Math.sqrt( s*(s-side1)*(s-side2)*(s-side3) );
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        if ( isValid( side1, side2, side3 ) ){
            System.out.printf("The area of the triangle is %.1f\n", area( side1, side2, side3 ) );
        }
        else{
            System.out.println("Input is invalid");
        }
    }
}
