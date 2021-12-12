// 父類別
abstract class CShape{
   protected String color;
    
   public void setColor(String str){
      color = str;
   }
   public abstract void show();
}

// 子類別
class CRectangle extends CShape{
   protected int width,height;
    
   public CRectangle(int w,int h){
      width = w;
      height = h;
   }
   // 定義繼承父類別的抽象函數 show()
   public void show(){
      System.out.print("color=" + color + ",  ");
      System.out.println("area=" + width*height);
   }
}

// main
public class abstract_01{
    
   public static void main(String args[]){
       
      //透過子類別建立物件
      CRectangle rect = new CRectangle(5,10);  
       
      // 利用子類別的物件去呼叫父類別的 member function setColor()
      rect.setColor("Yellow");   
      rect.show();
   }
}