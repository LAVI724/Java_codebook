import java.util.Scanner;

public class Main {

    // 抽象類別模板
    abstract static class GeometricObject{
        
        // 子類別 extends 可以用父類別的 protected member 所以這裡可以設 protected
        protected double x, y;
        protected abstract double getArea();

        public boolean equal(Rectangle ret2){
            if(this.getArea() > ret2.getArea()){
                return false;
            }
            else if(this.getArea() < ret2.getArea()){
                return false;
            }
            else {
                return true;
            }
        }
    }
    public static class Rectangle extends GeometricObject implements Comparable<Rectangle>{
        private double x, y;

        public Rectangle(double x, double y){
            this.x = x;
            this.y = y;
        }

        protected double getArea() {
            return x*y;
        }

        // override 父類別的 equal
        public boolean equal(Rectangle ret2) {
            return this.getArea() == ret2.getArea();
        }

        public int compareTo(Rectangle ret2) {
            if(this.getArea() == ret2.getArea()){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Rectangle ret1 = new Rectangle(input.nextDouble(), input.nextDouble());
       Rectangle ret2 = new Rectangle(input.nextDouble(), input.nextDouble());
       System.out.println(ret1.equal(ret2));
    }
}
