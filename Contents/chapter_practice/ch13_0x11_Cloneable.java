import java.util.Scanner;

public class Main {

    // 抽象類別模板
    abstract static class GeometricObject implements Comparable<GeometricObject>{

        // 子類別 extends 可以用父類別的 protected member 所以這裡可以設 protected
        protected abstract double getPerimeter();

        // 比較邊長
        public int compareTo(GeometricObject o){
            if(getPerimeter() > o.getPerimeter()){
                return 1;
            }
            else if(getPerimeter() < o.getPerimeter()){
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    public static class Octagon extends GeometricObject implements Cloneable{
        private double side;

        public Octagon(){
            this.side = 0;
        }

        public Octagon(double side){
            this.side = side;
        }

        public double getArea() {
            return (2.0 + 4.0/Math.sqrt(2))*side*side;
        }

        protected double getPerimeter(){
            return side*8;
        }

        // override Object clone
        // https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/488214/
        public Object clone(){
            Object obj = null;
            try{
                obj = super.clone();
            }
            catch (CloneNotSupportedException e){
                e.printStackTrace();
            }
            return obj;
        }

        // instanceof 比較左邊的物件是右邊類別的物件時回傳 true
        // https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/302506/
        public boolean equals(Object obj) {
            return obj instanceof Octagon;
        }
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Octagon oct1 = new Octagon(5.0);
        // 創建一個 clone obt1 的物件
       Octagon oct2 = (Octagon) oct1.clone();

       System.out.println("Area is " + oct1.getArea());
       System.out.println("Perimeter is " + oct1.getPerimeter());
       System.out.println("Compare the methods " + oct1.compareTo(oct2));
    }
}
