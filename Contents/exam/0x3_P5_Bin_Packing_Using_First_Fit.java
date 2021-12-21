import java.util.*;  
  
public class Main {  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        boolean flag = false;  
  
        while(input.hasNextInt()){  
            int n = input.nextInt();  
            int m = input.nextInt();  
  
            int[] total = new int[m+5];  
            String[] ans = new String[m+5];  
            int head = 0;  
            for(int i = 0; i < m; i++){  
                int num = input.nextInt();  
                for(int j = 0; j <= head; j++){  
                    if(j == head){  
                        total[head] = num;  
                        ans[head] = "";  
                        ans[head] = ans[head].concat(" " + num);  
                        head++;  
                        break;  
                    }  
                    else{  
                        if(total[j] + num <= n){  
                            total[j] += num;  
                            ans[j] = ans[j].concat(" " + num);  
                            break;  
                        }  
                    }  
                }  
            }  
  
            if(flag){  
                System.out.println();  
            }  
            System.out.println(head);  
            for(int i = 0; i < head; i++){  
                System.out.printf("Container %d contains objects with weight%s\n", i+1, ans[i]);  
            }  
            flag = true;  
        }  
  
    }  
}  