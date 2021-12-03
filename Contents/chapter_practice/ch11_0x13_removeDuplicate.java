import java.util.*;

public class Main {

    public static void removeDuplicate(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int first = list.indexOf(list.get(i));
            int last = list.lastIndexOf(list.get(i));
            if(first == last){
                list.remove(i);
                i--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(input.hasNext()){
            list.add(input.nextInt());
        }
        removeDuplicate(list);

        System.out.print("The same integers are: ");
        for(int i = 0; i < list.size(); i++){
            System.out.printf(i != list.size()-1 ? list.get(i) + " " : String.valueOf(list.get(i)));
        }
        System.out.println();
    }
}