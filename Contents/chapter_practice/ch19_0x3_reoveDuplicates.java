import java.util.*;

public class Main {

    // 這句大致是:
    // 一個 public static 的 class E 名字是 min
    // 應用了 extends Comparable<>
    // T extends Comparable<T>> 限制 T 必須要實作 Comparable<T或T的任意父類>
    // 吃的參數是應用了 E 類別的 ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> newlist = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(!newlist.contains(list.get(i))){
                newlist.add(list.get(i));
            }
        }

        return newlist;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();

        // 利用 switch 去判斷輸入類型的字串
        switch (type) {
            case "Integer":
                ArrayList<Integer> integers = new ArrayList<>();
                while(input.hasNextInt()){
                    integers.add(input.nextInt());
                }
                integers = removeDuplicates(integers);
                for(int i = 0; i < integers.size(); i++){
                    System.out.print(i != integers.size()-1 ? integers.get(i) + " " : integers.get(i) + "\n");
                }
                break;
            case "Double":
                ArrayList<Double> doubles = new ArrayList<>();
                while(input.hasNextDouble()){
                    doubles.add(input.nextDouble());
                }
                doubles = removeDuplicates(doubles);
                for(int i = 0; i < doubles.size(); i++){
                    if(i == doubles.size()-1){
                        System.out.printf("%.3f\n", doubles.get(i));
                    }
                    else{
                        System.out.printf("%.3f ", doubles.get(i));
                    }
                }
                break;
            case "Character":
                ArrayList<Character> characters = new ArrayList<>();
                String str = input.nextLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                while(st.hasMoreTokens()){
                    characters.add(st.nextToken().charAt(0));
                }
                characters = removeDuplicates(characters);
                for(int i = 0; i < characters.size(); i++){
                    System.out.print(i != characters.size()-1 ? characters.get(i) + " " : characters.get(i) + "\n");
                }
                break;
            case "String":
                ArrayList<String> strings = new ArrayList<>();
                String strr = input.nextLine();
                StringTokenizer s = new StringTokenizer(strr, " ");
                while(s.hasMoreTokens()){
                    strings.add(s.nextToken());
                }
                strings = removeDuplicates(strings);
                for(int i = 0; i < strings.size(); i++){
                    System.out.print(i != strings.size()-1 ? strings.get(i) + " " : strings.get(i) + "\n");
                }
                break;
        }
    }
}