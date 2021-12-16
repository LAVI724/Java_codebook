import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static class Point implements Comparable<Point>{

        private int x, y, num;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            num = x + y;
        }

        public int compareTo(Point o) {
            if((Math.pow(this.x, 2)) + (Math.pow(this.y, 2)) > (Math.pow(o.x, 2)) + (Math.pow(o.y, 2))){
                return 1;
            }
            else if((Math.pow(this.x, 2)) + (Math.pow(this.y, 2)) == (Math.pow(o.x, 2)) + (Math.pow(o.y, 2))){
                if(this.x > o.x){
                    return 1;
                }
                else if(this.x == o.x) {
                    if (this.y > o.y) {
                        return 1;
                    }
                    else if (this.y == o.y) {
                        return 0;
                    }
                    else {
                        return -1;
                    }

                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(input.hasNextInt()){

            if(flag){
                System.out.println();
            }

            int n = input.nextInt();
            ArrayList<Point> al = new ArrayList<>();

            for(int i = 0; i < n; i++){
                al.add(new Point(input.nextInt(), input.nextInt()));
            }

            Collections.sort(al);

            int max = 0, pointx = 0, pointy = 0;
            for(int i = 0; i < n; i++){
                System.out.println("(" + al.get(i).x + "," + al.get(i).y + ")");
                if(al.get(i).num >= max){
                    max = al.get(i).num;
                    pointx = al.get(i).x;
                    pointy = al.get(i).y;
                }
            }

            System.out.println("max num: " + max);
            System.out.println("point:(" + pointx + "," + pointy + ")");
            flag = true;
        }
    }
}
