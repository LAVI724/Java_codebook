import java.util.*;

public class Main {
    
    // 這句大致是:
    // 一個 public static 的 class E 名字是 min 
    // 應用了 extends Comparable<> 
    // T extends Comparable<T>> 限制 T 必須要實作 Comparable<T或T的任意父類>
    // 吃的參數是應用了 E 類別的 ArrayList
    public static <E extends Comparable<E>> E min(ArrayList<E> list){
        // 創建 E 的物件 並初始化
        E min = list.get(0);
        for (E e : list) {
            // compareTo -> 如果原物件 = compareTo 的目標() 內的值 回傳等於 0 的值
            // compareTo -> 如果原物件 > compareTo 的目標() 內的值 回傳大於 0 的值
            // compareTo -> 如果原物件 < compareTo 的目標() 內的值 回傳小於 0 的值
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E max = list.get(0);
        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();

        // 利用 switch 去判斷輸入類型的字串
        switch (type) {
            case "Integer":
                ArrayList<Integer> integers = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    integers.add(input.nextInt());
                }
                System.out.println(min(integers));
                System.out.println(max(integers));
                break;
            case "Double":
                ArrayList<Double> doubles = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    doubles.add(input.nextDouble());
                }
                System.out.printf("%.3f\n", min(doubles));
                System.out.printf("%.3f\n", max(doubles));
                break;
            case "Character":
                ArrayList<Character> characters = new ArrayList<>();
                for(int i = 0; i < 10; i++){
                    characters.add(input.next().charAt(0));
                }
                System.out.println(min(characters));
                System.out.println(max(characters));
                break;
            case "String":
                ArrayList<String> strings = new ArrayList<>();
                String str = input.nextLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                while(st.hasMoreTokens()){
                    strings.add(st.nextToken());
                }
                System.out.println(min(strings));
                System.out.println(max(strings));
                break;
        }
    }
}