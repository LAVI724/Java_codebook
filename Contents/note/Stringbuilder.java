// 先把 i 轉成 String ( 因為這樣比較方便 reverse )  
String str = String.valueOf(i);  
  
// 使用 StringBuilder 宣告 rev -> 因為 StringBuilder 才有 .reverse() 可以用  
StringBuilder rev = new StringBuilder();  

// 這裡 append (附加) str 的值給 rev  
rev.append(str);  

// reverse  
rev.reverse(); 

/* 置換 */

// replace
import java.lang.*;

public class StringBuilderDemo {

  public static void main(String[] args) {
  
    StringBuilder str = new StringBuilder("Java Util Package");
    System.out.println("string = " + str);
    
    // 從 index 5 到 9 換掉
    str.replace(5, 9, "Lang");

    System.out.println("After replacing: " + str);
  }
}

// string = Java Util Package
// After replacing: Java Lang Package