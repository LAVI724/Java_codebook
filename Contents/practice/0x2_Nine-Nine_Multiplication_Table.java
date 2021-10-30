/*
請列出所有九九乘法表。
example:
1 * 1 = 1 1 * 2 = 2 1 * 3 = 3 1 * 4 = 4 1 * 5 = 5 ... 1 * 9 = 9\n
*每個公式中間都有一個空格
*每行最後都沒有空格，但有換行符號
*每個公式的答案都是 %2d <-重點
*可以利用System.out.printf(String , value ,......);
*/

public class Main {  
  
    public static void main(String[] args) {  
  
        for( int i = 1; i < 10; i++ ){  
            for( int j = 1; j < 10; j++ ){  
  
                if( j == 9 ){  
                    System.out.printf( "%d * %d = %2d\n", i, j, i * j );  
                    continue;  
                }  
                  
                System.out.printf( "%d * %d = %2d ", i, j, i * j );  
  
            }  
        }  
  
    }  
}  