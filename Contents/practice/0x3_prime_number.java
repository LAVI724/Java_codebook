/*
請輸入一個Integer並輸出小於其的所有質數
每行答案中間都有空格
每行最後都為換行符號(沒有空格)
*/

import java.util.*;  
  
public class Main {  
  
    public static void main(String[] args) {  
  
        Scanner input = new Scanner(System.in);  
        int n = input.nextInt();  
  
        boolean prime[] = new boolean[1000];  
  
        // java 的 vector 寫法似乎是如此 :D  
        // <> 內不能寫 int 要寫 Integer  
        Vector<Integer> v = new Vector();  
  
        // Arrays.fill 類似 C++ 的 memset( a, false, sizeof(a) );  
        Arrays.fill( prime,false );  
  
        for( int i = 2; i < n; i++ ){  
            if( !prime[i] ){  
  
                for( int j = i * i; j < n; j += i ){  
                    prime[j] = true;  
                }  
                // 像 C++ 的 v.push_back(i)  
                v.add(i);  
  
            }  
        }  
  
        int i;  
        for( i = 0; i < v.size()-1; i++ ){  
  
            // 不能直接寫 v[i] 要寫 v.get(i)  
            System.out.printf( "%d ", v.get(i) );  
              
        }  
        System.out.printf( "%d\n", v.get(i) );  
  
    }  
}  