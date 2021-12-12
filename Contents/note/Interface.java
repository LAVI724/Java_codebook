/* 實作 */

interface CShape{
   final double PI = 3.14;
   public abstract void show();
}

class CCircle implementation CShape{
    
   double radius;
   public CCircle(double r){
     radius = r;
   }
    
   //改寫介面中抽象函數
   public void show(){
     System.out.println("面積＝" + PI*radius*radius);
   }
}

public static void main(String args[]){
    
      CCircle cir = new CCircle(2.0);
      cir.show();       
}

---

/* 多重繼承*/

interface CShape{
   final double PI = 3.14;       
   public abstract void show();   
}
interface CColor{
  abstract void setColor();
}

// CCircle 同時繼承了 CShape 和 CColor
class CCircle implements CShape,CColor{
   double radius;
   String color;
   
   public CCircle(double r){
      radius = r;
   }
   
   public void setColor(String str){
      color = str;
      System.out.println("color=" + color);
   }
   public void show(){
      System.out.println("area=" + PI*radius*radius);
   }
}

public class interface02
{
    public static void main(String args[])
    {
      CCircle moon = new CCircle(5.0);
      moon.setColor("yellow");
      moon.show();        
    }
}

---

/* interface extends */

// 父介面
interface CShape{
   final double PI = 3.14;
   abstract void setColor(String str);
}

// 子介面 繼承了 CShape
interface CShape2D extends CShape{
   abstract void area();
}

// 實作
class CCircle implements CShape2D{
   double radius;
   String color;

   public CCircle(double r){
      radius = r;
   }
   public void setColor(String str){
      color = str;
      System.out.println("color=" + color);
   }
   public void show(){
      System.out.println("area=" + PI*radius*radius);
   }
}

---

/* Comparable Interface */

class Student implements Comparable<Student>{  
    String name;  
    int age;  
    
    Student(String name, int age){
        this.name = name;  
        this.age = age;  
    }  
    
    public int compareTo(Student st){  
        if(age == st.age){
            return 0;  
        }  
        else if(age > st.age){
            return 1;  
        }  
        else{
            return -1;
        }  
    }  
}

// main
public class MainSort{  
    public static void main(String args[]){  
        
        ArrayList<Student> al = new ArrayList<Student>();  
        al.add(new Student("Vijay",23));  
        al.add(new Student("Ajay",27));  
        al.add(new Student("Jai",21));  

        Collections.sort(al);  
        for(Student st: al){  
            System.out.println(st.name + " " + st.age);  
        }  
    }  
}  