import java.util.ArrayDeque;  
import java.util.Collections;  
import java.util.Scanner;  
import java.util.Vector;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        while(input.hasNextInt()){  
            boolean flag = false;  
            Vector<Integer> vector = new Vector<>();  
  
            while(input.hasNextInt()){  
                int num = input.nextInt();  
                if(num == 0 && flag){  
                    break;  
                }  
                else if(num == 0 && !flag){  
                    System.out.println();  
                    break;  
                }  
                else{  
                    vector.add(num);  
                }  
                flag = true;  
            }  
            Collections.sort(vector);  
  
            ArrayDeque<Integer> array = new ArrayDeque<>();  
            for(int i = 0; i < vector.size(); i++){  
                if(vector.get(i) % 2 == 0){  
                    array.add(vector.get(i));  
                }  
                else{  
                    array.addFirst(vector.get(i));  
                }  
            }  
  
            for(int i = 0; i < array.size();){  
                if(i != array.size()-1){  
                    System.out.printf("%d ", array.getFirst());  
                }  
                else{  
                    System.out.printf("%d\n", array.getFirst());  
                }  
                array.removeFirst();  
            }  
        }  
    }  
  
}  