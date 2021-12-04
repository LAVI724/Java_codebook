/*
請利用作業一(Part 2)中序轉後序-轉後序的答案輸出後續的算式，並輸出運算結果

輸入
每組測資會給予不一定長度的算式，符號包含+,-,*,/,(,),%。

程式要求 (未依規定以0分記)
Write a Class XXXX (name it yourself) (which is not the Main class)  for computing the input expression.
Class XXXX must include the following three static methods
​​String[] AAAA(String s) which returns an array of string tokens for the input expession s.
String[] BBBB(String s) which returns an array of string tokens (Postfixe Expression) for the input expression s. Note that BBBB() can call AAAA().
BigDecimal CCCC(String s) which returns the computing result of input expresdion s. Note that CCCC() can call AAAA() and BBBB().
Please give a meaningful name for AAAA, BBBB, and CCCC.

輸出
輸出算式的答案(BigDecimal)
*/

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        BigDecimal output;
        // 呼叫並使用另一個叫做 computing 的 class 的內部 method
        output = computing.caculating(str);

        System.out.println(output.setScale(2, RoundingMode.HALF_UP));
    }
}
// 同一份 java 檔案內只能有一個 public class 所以第二個直接叫 class 就好
class computing {

    // 用來判斷後續先後順序的兩個 method
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

    // 等同於老師要求的第一個 method AAAA
    // 把輸入的 s 做切割後放入陣列 arr 中
    public static String[] splitmethod (String s){
        // 用 split 切割字串
        String[] arr = s.split("((?=\\+|-|\\*|/|\\)|\\(|%)|(?<=\\+|-|\\*|/|\\)|\\(|%))",0);
        return arr;
    }

    // 等同於老師要求的 BBBB
    // 呼叫 splitmethod method 去切割字串並按照後續排序
    public static String[] postfixe (String s){
        String[] postfixearr;
        String token = "+-*/(%";

        // 呼叫 splitmethod method 切割字串
        // 用 postfixearr 接回傳的陣列裡
        postfixearr = computing.splitmethod(s);

        String[] ans = new String[postfixearr.length];

        // 使用 stack 儲存運算子
        Stack<String> stack = new Stack<>();
        int icp = 0, isp = 0, i = 0;

        for (String str : postfixearr) {
            // 如果是 ) 則輸出所有 ( 以前的 stack 內的運算子
            // 但 () 都不輸出
            if (str.equals(")")) {
                while (!stack.peek().equals("(")) {
                    ans[i++] = stack.peek();
                    stack.pop();
                }
                // 把 ) 也 pop 掉
                stack.pop();
            }
            // 如果是 + - * / %
            else if (token.contains(str)) {
                // 運算此運算子的 icp 和 當前 stack 頂端的運算子的 isp
                icp = icpfunc(str);
                if (stack.empty()) {
                    stack.push(str);
                }
                else {
                    isp = ispfunc(stack.peek());
                    if (icp > isp) {
                        stack.push(str);
                    } else {
                        while (icp <= ispfunc(stack.peek())) {
                            ans[i++] = stack.peek();
                            stack.pop();
                            if (stack.empty()) {
                                break;
                            }
                        }
                        stack.push(str);
                    }
                }
            }
            // 如果是運算元則直接輸出
            else {
                ans[i++] = str;
            }
        }
        // 最後因為有可能 array 在切割的時候最後一個值是運算元
        // 那樣就還會有運算子在 stack 還沒輸出 所以這裡在確認一次
        while(!stack.empty()){
            ans[i++] = stack.peek();
            stack.pop();
        }
        return ans;
    }

    // 相當於老師要求的 CCCC
    public static BigDecimal caculating (String s){
        String answer = "";
        String[] frompostfixe;
        Stack<String> stack = new Stack<>();
        String token = "+-*/%";

        // 呼叫 postfixe method 去排序後續
        // 而 postfixe method 會先去呼叫 splitmethod method 去切割字串
        // 所以 caculating 可以 call postfixe 和 splitmethod
        frompostfixe = postfixe(s);

        for (String str : frompostfixe) {

            // 如果跑道 frompostfixe 沒放後續字串的地方了 就 break 掉
            if( str == null ){
                break;
            }

            // 當碰到運算子時 先到 stack 去找最上面的兩個運算元
            // 分別讀取後 將兩者皆 pop 出來 ( 因為如此一來他們用過了 )
            // 對他們進行該運算子的運算
            // 最後將目前的運算結果 push 進 stack 裡
            // 這樣就算之後有更要先乘除後加減的數也不會影響到之前運算過的數
            if (token.contains(str)) {

                BigDecimal top = BigDecimal.valueOf( Double.parseDouble(stack.peek()) );
                stack.pop();
                BigDecimal sec = BigDecimal.valueOf( Double.parseDouble(stack.peek()) );
                stack.pop();

                if (str.charAt(0) == '+'){
                    sec = sec.add( top );
                    stack.push(sec.toString());
                }
                else if (str.charAt(0) == '-'){
                    sec = sec.subtract( top );
                    stack.push(sec.toString());
                }
                else if (str.charAt(0) == '*'){
                    sec = sec.multiply( top );
                    stack.push(sec.toString());
                }
                else if (str.charAt(0) == '/'){
                    sec = sec.divide( top, 2, RoundingMode.HALF_UP );
                    stack.push(sec.toString());
                }
                else if (str.charAt(0) == '%'){
                    sec = sec.remainder( top );
                    stack.push(sec.toString());
                }
                // 判斷目前運算的結果是多少 ( 無論是暫時的 還是最終結果
                answer = stack.peek();
            }
            // 如果是運算子就直接 push 進 stack
            else{
                stack.push(str);
            }
        }
        // 最後回傳 Bigdecimal 型態的 answer
        // 根據老師要求的 method 型別
        return BigDecimal.valueOf( Double.parseDouble(answer) );
    }
}