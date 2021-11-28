import java.util.Scanner;

public class Main {

    static class MyPoint{
        double X, Y;
        public double getX() {
            return X;
        }
        public double getY() {
            return Y;
        }
        public MyPoint(){
            X = 0;
            Y = 0;
        }
        public MyPoint(double x, double y){
            X = x;
            Y = y;
        }

        public double distance(MyPoint mp2){
            return Math.sqrt(Math.pow(this.X-mp2.X, 2) + Math.pow(this.Y-mp2.Y, 2));
        }
        public double distance(double x, double y){
            return Math.sqrt(Math.pow(this.X-x, 2) + Math.pow(this.Y-y, 2));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        MyPoint mp1 = new MyPoint(x1, y1);
        MyPoint mp2 = new MyPoint(x2, y2);

        System.out.println(mp1.distance(mp2));
        System.out.println(mp1.distance(x3, y3));
    }
}