import java.util.*;

public class Main {
=
    // 應用了 extends Comparable<>
    // T extends Comparable<T>> 限制 T 必須要實作 Comparable<T或T的任意父類>
    // 吃的參數是應用了 E 類別的陣列
    public static <E extends Comparable<E>> int linearSearch(E[] list,E key){
        for(int i = 0; i < list.length; i++){
            if(list[i].compareTo(key) == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        int n = input.nextInt();

        // 利用 switch 去判斷輸入類型的字串
        switch (type) {
            case "Integer":
                Integer[] integers = new Integer[n];
                for(int i = 0; i < n; i++){
                    integers[i] = input.nextInt();
                }
                int keyi = input.nextInt();
                int flagi = linearSearch(integers, keyi);
                if(flagi > 0){
                    System.out.print(keyi + " is found in the " + flagi + "'th place.\n");
                }
                else{
                    System.out.println("Not found");
                }
                break;
            case "Double":
                Double[] doubles = new Double[n];
                for(int i = 0; i < n; i++){
                    doubles[i] = input.nextDouble();
                }
                double keyd = input.nextInt();
                int flagd = linearSearch(doubles, keyd);
                if(flagd > 0){
                    System.out.print(keyd + " is found in the " + flagd + "'th place.\n");
                }
                else{
                    System.out.println("Not found");
                }
                break;
            case "Character":
                Character[] characters = new Character[n];
                for(int i = 0; i < n; i++){
                    characters[i] = input.nextLine().charAt(0);
                }
                char keyc = input.nextLine().charAt(0);
                int flagc = linearSearch(characters, keyc);
                if(flagc > 0){
                    System.out.print(keyc + " is found in the " + flagc + "'th place.\n");
                }
                else{
                    System.out.println("Not found");
                }
                break;
            case "String":
                String[] strings = new String[n];
                // 要吃掉切換 int 輸入後和 string 輸入之間的那個換行
                String endl = input.nextLine();
                String strr = input.nextLine();
                StringTokenizer s = new StringTokenizer(strr, " ");
                int head = 0;
                while(s.hasMoreTokens()){
                    strings[head++] = s.nextToken();
                }
                String keys = input.nextLine();
                int flags = linearSearch(strings, keys);
                if(flags > 0){
                    System.out.print(keys + " is found in the " + flags + "'th place.\n");
                }
                else{
                    System.out.println("Not found");
                }
                break;
        }
    }
}