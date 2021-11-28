public class Main {

    static class Circle2D{
        double x, y;
        double radius;
        public Circle2D(){
            this.x = 0;
            this.y = 0;
            this.radius = 1;
        }
        public Circle2D(double x, double y, double radius){
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
        public double getArea(){
            return Math.PI * this.radius * this.radius;
        }
        public double getPerimeter(){
            return Math.PI * this.radius * 2;
        }
        public boolean contains(double x, double y){
            return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2)) < radius;
        }
        public boolean contains(Circle2D Cicle){
            return Cicle.radius < this.radius;
        }
        public boolean overlaps(Circle2D Circle){
            return Math.sqrt(Math.pow(this.x-Circle.x, 2) + Math.pow(this.y-Circle.y, 2)) < radius;
        }
    }
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        Circle2D c2 = new Circle2D(4, 5, 10.5);
        Circle2D c3 = new Circle2D(3, 5, 2.3);

        System.out.println("Area is " + c1.getArea());
        System.out.println("Perimeter is " + c1.getPerimeter());
        System.out.println("c1 contains point (3, 3)? " + c1.contains(3, 3));
        System.out.println("c1 contains circle Circle2D(4, 5, 10.5)? " + c1.contains(c2));
        System.out.println("c1 overlaps circle Circle2D(3, 5, 2.3)? " + c1.overlaps(c3));
    }

}