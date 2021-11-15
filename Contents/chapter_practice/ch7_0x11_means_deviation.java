/*
mean = ( x1 + x2 +... + xn )/n
deviation = sqrt( ( (x1 - mean)^2 + ... + (xn - mean)^2 ) / n - 1 )
*/


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static double mean(double[] x){

        double cnt = 0;
        for( int i = 0; i < 10; i++ ){
            cnt += x[i];
        }
        System.out.println("The mean is " + cnt/10);
        return cnt/10;
    }
    public static double deviation(double[] x){

        double mean = mean(x);
        double cnt = 0;
        for( int i = 0; i < 10; i++ ){
            cnt += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(cnt/9.0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] x = new double[10];
        for( int i = 0; i < 10; i++ ){
            x[i] = input.nextDouble();
        }
        System.out.println("The standard deviation is " + deviation(x));
    }
}
