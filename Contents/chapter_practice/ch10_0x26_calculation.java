import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        while(input.hasNext()){

            str = input.nextLine();
            StringTokenizer st = new StringTokenizer(str," +-*/");
            StringTokenizer op = new StringTokenizer(str, " 0123456789");
            String operator = op.nextToken();

            int x, y;

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int ans = 0;
            if(operator.charAt(0) == '+'){
                ans = x + y;
            }
            else if(operator.charAt(0) == '*'){
                ans = x * y;
            }
            else if(operator.charAt(0) == '-'){
                ans = x - y;
            }
            else if(operator.charAt(0) == '/'){
                ans = x / y;
            }
            System.out.println(x + " " + operator + " " + y + " = " + ans);
        }
    }

}