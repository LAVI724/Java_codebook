import java.util.Scanner;

public class Main {

    // 宣告 Exception 類別 (除了變數名稱外 格式是固定的
    static class IllegalTriangleException extends Exception {
    }
    static class Triangle{
        private static double side1, side2, side3;

        // 在頭宣告 throws 內部依據要求不符者 throw
        public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
            if(side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2){
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
            }
            else{
                throw new IllegalTriangleException();
            }
        }

        public static double getArea(){
            double s = getPerimeter()/2;
            return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        }
        public static double getPerimeter(){
            return side1 + side2 + side3;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double side1, side2, side3;
        while(input.hasNextDouble()){
            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();

            // 一定要用 try 和 catch 接 必要時還會有 finally
            try{
                Triangle tri = new Triangle(side1, side2, side3);
                System.out.printf("%.3f %.3f\n", Triangle.getPerimeter(), Triangle.getArea());
            }
            catch(IllegalTriangleException e){
                System.out.println("The sum of any two sides is greater than the other side");
                System.out.printf("Side1: %.1f\nSide2: %.1f\nSide3: %.1f\n", side1, side2, side3);
                break;
            }
        }
    }
}