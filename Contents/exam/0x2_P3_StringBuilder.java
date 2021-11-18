import java.util.Scanner;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int n = input.nextInt();  
        // 吃交替換行的誤植  
        String space = input.nextLine();  
  
        for( int i = 0; i < n; i++ ){  
            String str = input.nextLine();  
            String ori = input.nextLine();  
            String cha = input.nextLine();  
              
            // 利用 StringBuilder 來做反轉用行  
            StringBuilder st = new StringBuilder(str);  
              
            // 持續轉換 如果已換過的還是可以轉換字串，那就繼續換 直到 -1 ( 字串尾超出屁股ㄌ   
            while ( st.indexOf(ori) != -1 ){  
                st.replace( st.indexOf(ori), st.indexOf(ori) + ori.length(), cha );  
            }  
            // 反轉並輸出  
            st.reverse();  
            System.out.println(st);  
  
        }  
    }  
}  