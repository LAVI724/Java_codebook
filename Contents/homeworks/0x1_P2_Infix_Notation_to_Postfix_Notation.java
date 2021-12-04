/*
請利用 P1 中序轉後序-分割的答案輸出後續的算式，並輸出後序運算式

程式要求
1.必須使用java.util.Stack 實作，否則不予計分。
2.請利用part1求得的token 字串陣列轉後序

輸入   
每組測資會給予不一定長度的算式，符號包含+,-,*,/,(,),%，算式中數字的大小則不超過1000。
 
輸出   
將後序算式的每個運算元與運算子後加入一個空格字元印出。
格式請詳看sample output
*/
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int icpfunc(String check){
        // icp 是該 token 的順序
        // icp -> +- 1 -> */% 2 -> ( 4
        int icp;
        if(check.equals("(")){
            icp = 4;
            return icp;
        }
        else if(check.equals("*") || check.equals("/") || check.equals("%") ){
            icp = 2;
            return icp;
        }
        else{
            icp = 1;
            return icp;
        }
    }
    public static int ispfunc(String check){
        // isp 是堆疊最上層 stack.peek 中的順序
        // isp -> ( 0 -> +- 1 -> */% 2
        int isp;
        if(check.equals("(")){
            isp = 0;
            return isp;
        }
        else if(check.equals("*") || check.equals("/") || check.equals("%") ){
            isp = 2;
            return isp;
        }
        else{
            isp = 1;
            return isp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String token = "+-*/(%";

        // 用 split 切割字串
        String[] array = str.split("((?=\\+|-|\\*|/|\\)|\\(|%)|(?<=\\+|-|\\*|/|\\)|\\(|%))",0);

        // 使用 stack 儲存運算子
        Stack<String> stack = new Stack<>();
        int icp = 0, isp = 0;

        for (String s : array) {
            // 如果是 ) 則輸出所有 ( 以前的 stack 內的運算子
            // 但 () 都不輸出
            if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    System.out.print(stack.peek() + " ");
                    stack.pop();
                }
                // 把 ) 也 pop 掉
                stack.pop();
            }
            // 如果是 + - * / %
            else if (token.contains(s)) {
                // 運算此運算子的 icp 和 當前 stack 頂端的運算子的 isp
                icp = icpfunc(s);
                if (stack.empty()) {
                    stack.push(s);
                }
                else {
                    isp = ispfunc(stack.peek());
                    if (icp > isp) {
                        stack.push(s);
                    } else {
                        while (icp <= ispfunc(stack.peek())) {
                            System.out.print(stack.peek() + " ");
                            stack.pop();
                            if (stack.empty()) {
                                break;
                            }
                        }
                        stack.push(s);
                    }
                }
            }
            // 如果是運算元則直接輸出
            else {
                System.out.print(s + " ");
            }
        }
        // 最後因為有可能 array 在切割的時候最後一個值是運算元
        // 那樣就還會有運算子在 stack 還沒輸出 所以這裡在確認一次
        while(!stack.empty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }
} 