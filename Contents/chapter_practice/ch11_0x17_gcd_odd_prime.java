import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n+5];

        int nn = n;
        for(int i = 2; i <= nn && nn != 1; i++){
            while(nn % i == 0){
                num[i]++;
                nn /= i;
            }
        }
        int total = n;
        for(int i = 2; i <= n; i++){
            while(num[i]%2 != 0){
                total *= i;
                num[i] /= 2;
            }
        }
        System.out.println(total);
    }
}