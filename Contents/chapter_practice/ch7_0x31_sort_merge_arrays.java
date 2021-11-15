/*
請撰寫以下方法，將兩個已排序(小到大)的序列合併成一個新的排序序列
public static int[] merge(int[] list1,int[] list2)
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] merge( int[] list1, int[] list2 ) {

        int[] merge = new int[list1.length + list2.length];
        int cur1 = 0, cur2 = 0;

        // 先 sort 兩個 array
        Arrays.sort(list1);
        Arrays.sort(list2);

        // 按照課本給的網站的要求 判斷 list1 和 list2 當前指標指的位址中的數誰比較小
        for (int i = 0; i < list1.length + list2.length; i++ ){
            if( cur1 < list1.length && list1[cur1] < list2[cur2] ){
                merge[i] = list1[cur1++];
            }
            else{
                merge[i] = list2[cur2++];
            }
        }
        return merge;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1 = input.nextInt();
        int[] list1 = new int[n1];
        for( int i = 0; i < n1; i++ ){
            list1[i] = input.nextInt();
        }

        int n2 = input.nextInt();
        int[] list2 = new int[n2];
        for( int i = 0; i < n2; i++ ){
            list2[i] = input.nextInt();
        }

        int[] ans = merge( list1, list2 );
        for( int i = 0; i < ans.length; i++ ){
            System.out.print(ans[i]);
            System.out.print( i != ans.length-1 ? " " : "\n" );
        }
    }
}
