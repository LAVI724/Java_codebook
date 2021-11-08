/*
將一正整數的所有公因數加總，其總和與正整數相等，則稱此數為完美數。 課本練習５．33
本題不需任何輸入，請嘗試輸出所有 0<num< 10000的完美數
*/

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        // 用 vector 存因數
        Vector<Integer> v = new Vector<Integer>();
        for( int i = 1; i < 10000; i++ ){
            for( int j = 1; j < i; j++ ){
                if( i % j == 0 ){
                    v.add(j);
                }
            }
            // 加總公因數
            int count = 0;
            for (Integer integer : v) {
                count += integer;
            }
            // 是否為完美數
            if( count == i ){
                System.out.println(i);
            }
            v.clear();
        }
    }
}
