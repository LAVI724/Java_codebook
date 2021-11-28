
import java.util.Scanner;

public class Main {

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[2][2];

        for( int i = 0; i < 2; i++ ){
            for( int j = 0; j < 2; j++ ){
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] a = new double[2][2];
        double[][] b = new double[2][2];

        for( int j = 0; j < 2; j++ ){
            for( int k = 0; k < 2; k++ ){
                a[j][k] = input.nextDouble();
            }
        }
        for( int j = 0; j < 2; j++ ){
            for( int k = 0; k < 2; k++ ){
                b[j][k] = input.nextDouble();
            }
        }
        double[][] c = multiplyMatrix(a, b);
        for( int i = 0; i < 2; i++ ){
            System.out.println( c[i][0] + " " + c[i][1] );
        }
    }
}
