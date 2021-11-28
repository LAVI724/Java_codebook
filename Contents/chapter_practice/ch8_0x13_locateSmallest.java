
import java.util.Scanner;

public class Main {

    private static int r, c;
    public static int[] locateSmallest(double[][] a) {
        int[] smal = new int[2];
        double min = a[0][0];

        for( int i = 0 ; i < r; i++ ){
            for( int j = 0; j < c; j++ ){
                if( a[i][j] < min ){
                    min = a[i][j];
                    smal[0] = i;
                    smal[1] = j;
                }
            }
        }
        return smal;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        c = input.nextInt();

        double[][] a = new double[r][c];

        for( int j = 0; j < r; j++ ){
            for( int k = 0; k < c; k++ ){
                a[j][k] = input.nextDouble();
            }
        }
        int[] smallest = locateSmallest(a);
        System.out.printf("The location of the smallest element is at (%d, %d)\n", smallest[0], smallest[1]);
    }
}
