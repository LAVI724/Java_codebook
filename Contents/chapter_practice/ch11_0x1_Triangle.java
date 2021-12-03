import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class Triangle{
        private static double side1, side2, side3;
        public Triangle(){
            this.side1 = 1.0;
            this.side2 = 1.0;
            this.side3 = 1.0;
        }
        public Triangle(int side1, int side2, int side3){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
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
        String inputs = input.nextLine();

        StringTokenizer st = new StringTokenizer(inputs, " ");

        int side1, side2, side3;
        side1 = Integer.parseInt(st.nextToken());
        side2 = Integer.parseInt(st.nextToken());
        side3 = Integer.parseInt(st.nextToken());
        String color = st.nextToken();
        boolean bool = Boolean.parseBoolean(st.nextToken());

        Triangle tri = new Triangle(side1, side2, side3);
        System.out.printf("%.3f %.3f %s %b\n", Triangle.getArea(), Triangle.getPerimeter(), color, bool);

    }
}