import java.util.Arrays;

public class Main {

    static class Queue{
        private static int size = 1;
        private static int front, back;
        private static int[] elements = new int[size];
        public Queue() {
            size = 8;
            front = -1;
            back = -1;
        }
        public static void enqueue(int v){
            front++;
            if(front >= size){
                int orisize = size;
                getSize();
                int[] elementsnew = new int[size];
                elementsnew = Arrays.copyOf(elements, elements.length + orisize);
                elements = elementsnew;
            }
            elements[front] = v;
            if(front == 20){
                empty();
            }
            else{
                enqueue(++v);
            }
        }
        public static void dequeue(){
            back++;
            if(back != front){
                System.out.print(elements[back] + " ");
            }
            else{
                System.out.println(elements[back]);
            }
            empty();
        }
        public static void empty(){
            if(back != front) {
                dequeue();
            }
        }
        public static void getSize(){
            size *= 2;
        }
    }
    public static void main(String[] args) {

        Queue.enqueue(1);

    }
}