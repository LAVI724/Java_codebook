/*
Problem
If you have good observations skills, you may found that building a Magic Square is simple. A Magic Square has only an odd number N of rows and columns where N < 100. A Magic Square is created by integer numbers in the range from 1 to N2 , with a peculiar property, the “sum of the numbers” in each row, column and diagonal are the same.

For the case n = 3,
M. Square          Rows           Columns         Diagonals
4 9 2              4+9+2 = 15     4+3+8 = 15      2+5+8 = 15
3 5 7              3+5+7 = 15     9+5+1 = 15      4+5+6 = 15
8 1 6              8+1+6 = 15     2+7+6 = 15 

Input
Each line contains an Integer N denoting an N * N Magic Square.

Output
如果 N 是偶數則輸出 ”It is not an odd number. ”。 如果 N 是奇數則先輸出直橫列的加總數字，再輸出 N * N 數字陣列,每個數字以%5d 格 式輸出。每組測資間請空一行。
*/

import java.util.Arrays;  
import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        boolean flag = false;  
  
        while(input.hasNext()){  
            int n = input.nextInt();  
            if( flag ){  
                System.out.println();  
            }  
  
            if( n % 2 == 0 ){  
                System.out.println("It is not an odd number.");  
                flag = true;  
                continue;  
            }  
  
            int[][] square = new int[100+5][100+5];  
            for( int i = 0; i < n; i++ ){  
                Arrays.fill( square[i], 0);  
            }  
  
            int r = n-1, c = n/2;  
            square[r][c] = 1;  
            for( int i = 2; i <= n*n; i++ ){  
  
                int rn = r+1;  
                int cn = c+1;  
                if( rn >=n ){  
                    rn = 0;  
                }  
                if( cn >= n ){  
                    cn = 0;  
                }  
                if( square[rn][cn] != 0 ){  
                    rn = r-1;  
                    cn = c;  
                    if( rn < 0 ){  
                        rn = n-1;  
                    }  
                }  
                square[rn][cn] = i;  
                r = rn;  
                c = cn;  
            }  
            int sum = 0;  
            for( int i = 0; i < n; i++ ){  
                sum += square[0][i];  
            }  
            System.out.println(sum);  
            for( int i = 0; i < n; i++ ){  
                for( int j = 0; j < n; j++ ){  
                    System.out.printf("%5d", square[i][j]);  
                }  
                System.out.println();  
            }  
            flag = true;  
        }  
  
    }  
} 