/*
Description
A Latin square is an n-by-n array filled with n different Latin letters, each occurring exactly once in each row and once in each column.
Write a program that prompts the user to enter the number n and the array of characters, as shown in the sample output, and checks if the input array is a Latin square. The characters are the first n characters starting from A.
 
Input
Enter number n, and enter n rows of letters separated by spaces.
0 < n <= 26, all the letters in square are A ~ Z.
Input is terminated by a set where n = -1. This set should not be processed.
 
Output
Recognize if it is Latin Square or not. There are 2 different kinds of your answers:
The input array is a Latin square
The input array is not a Latin square
Overall, just check if it is Latin square or not.
 
Sample Input           
4↵
A B C D↵                
B A D C↵
C D B A↵
D C A B↵
↵
3↵
B C A↵
B A C↵
C B A↵
↵
3↵
B A C↵
A C B↵
C B A↵
↵
4↵
D C B A↵
J A V A↵
U C C U↵
P P A P↵
↵
-1↵

Sample Output
The input array is a Latin square↵
↵
The input array is not a Latin square↵
↵
The input array is a Latin square↵
↵
The input array is not a Latin square↵
*/

import java.util.Arrays;  
import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        boolean newline = false;  
  
        while( input.hasNextInt() ){  
  
            int n = input.nextInt();  
            if( n < 0 ){  
                break;  
            }  
            // 控制最後不要換行  
            if( newline ){  
                System.out.println();  
            }  
  
            int[] count = new int[26+5];  
            char[][] square = new char[26+5][26+5];  
            boolean[][] row = new boolean[26+5][26+5];  
            boolean[][] col = new boolean[26+5][26+5];  
  
            // 陣列初始化  
            for( int i = 0; i < 26; i++ ){  
                Arrays.fill(count, 0);  
                Arrays.fill(square[i], '0');  
                Arrays.fill(row[i], false);  
                Arrays.fill(col[i], false);  
            }  
  
            for( int i = 0; i < n; i++ ){  
                for( int j = 0; j < n; j++ ){  
                    // char 的讀取寫法 .next().charAt(0) -> 這個 0 是固定的 因為單字元的索引值就是 0  
                    square[i][j] = input.next().charAt(0);  
                    // 計算每位是否接是出現 n 次 -> 每行都出現一次  
                    count[ square[i][j] - 'A' ]++;  
                }  
            }  
            // 吃最後的換行  
            String space = input.nextLine();  
  
            boolean flag = false;  
            for( int i = 0; i < n; i++ ) {  
                for (int j = i; j < n; j++) {  
  
                    if (row[i][square[i][j] - 'A'] || row[j][square[j][i] - 'A'] || col[i][square[j][i] - 'A'] || col[j][square[i][j] - 'A']) {  
                        flag = true;  
                        break;  
                    }  
                    row[i][square[i][j] - 'A'] = true;  
                    row[j][square[j][i] - 'A'] = true;  
                    col[i][square[j][i] - 'A'] = true;  
                    col[j][square[i][j] - 'A'] = true;  
  
                }  
                if (flag) {  
                    break;  
                }  
            }  
            for( int i = 0; i < 26; i++ ){  
                if( count[i] != n && count[i] != 0 ){  
                    flag = true;  
                    break;  
                }  
            }  
  
            if(flag){  
                System.out.println("The input array is not a Latin square");  
            }  
            else{  
                System.out.println("The input array is a Latin square");  
            }  
            newline = true;  
        }  
    }  
}  