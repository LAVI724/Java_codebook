/**
java 中獲取當前日期和時間方法
使用 Date 和 toString 去打印當前日期和時間
*/

import java.util.Date;
  
public class DateDemo {
   public static void main(String[] args) {
       // 初始化 Date 对象
       Date date = new Date();
        
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
   }
}

// Output:
// Mon May 04 09:51:52 CDT 2013

/*
日期比较
Java使用以下三种方法来比较两个日期：

1. 使用 getTime() 方法获取两个日期（自1970年1月1日经历的毫秒数值），然后比较这两个值
2. 使用方法 before()，after() 和 equals()
    例如，一个月的12号比18号早，则 new Date(99, 2, 12).before(new Date (99, 2, 18)) 返回true。
3. 使用 compareTo() 方法，它是由 Comparable 接口定义的，Date 类实现了这个接口。

/**
使用 SimpleDateFormat 格式化日期
SimpleDateFormat 是一个以语言环境敏感的方式来格式化和分析日期的类
SimpleDateFormat 允许你选择任何用户自定义日期时间格式来运行
例如：
*/

import  java.util.*;
import java.text.*;
 
public class DateDemo {
   public static void main(String[] args) {
 
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
    
        System.out.println("當前時間為: " + ft.format(dNow));
    }
}

// Output:
// 當前時間為: 2018-09-06 10:16:34

/*
實際範例
*/

import java.util.Date;
 
public class DateDemo {
 
  public static void main(String[] args) {
    // 初始化 Date 对象
    Date date = new Date();
 
    // c的使用  
    System.out.printf("全部日期和時間：%tc%n",date);          
    
    //f的使用  
    System.out.printf("年-月-日格式：%tF%n",date);  
    
    //d的使用  
    System.out.printf("月/日/年格式：%tD%n",date);  
    
    //r的使用  
    System.out.printf("HH:MM:SS PM格式（12時制）：%tr%n",date);  
    
    //t的使用  
    System.out.printf("HH:MM:SS格式（24時制）：%tT%n",date);  
    
    //R的使用  
    System.out.printf("HH:MM格式（24時制）：%tR",date);  
  }
}