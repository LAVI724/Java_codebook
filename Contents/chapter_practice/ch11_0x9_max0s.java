import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();
        int[] row = new int[n];
        int[] col = new int[n];

        int maxr = 0;
        int maxc = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(input.nextInt() == 0){
                    row[i]++;
                    col[j]++;
                    maxr = Math.max(maxr, row[i]);
                    maxc = Math.max(maxc, col[j]);
                }
            }
        }
        ArrayList<Integer> maxrw = new ArrayList<>();
        ArrayList<Integer> maxcl = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(row[i] == maxr){
                maxrw.add(i);
            }
            if(col[i] == maxc){
                maxcl.add(i);
            }
        }
        System.out.print("The most 0s row index: ");
        for(int i = 0; i < maxrw.size(); i++){
            if(i != maxrw.size()-1){
                System.out.print(maxrw.get(i) + ", ");
            }
            else{
                System.out.println(maxrw.get(i));
            }
        }
        System.out.print("The most 0s column index: ");
        for(int i = 0; i < maxcl.size(); i++){
            if(i != maxcl.size()-1){
                System.out.print(maxcl.get(i) + ", ");
            }
            else{
                System.out.println(maxcl.get(i));
            }
        }
    }
}