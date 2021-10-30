/*
Problem
Write a program to input an expression string in which the operands and operators are separated by zero or more spaces. For example, 3.5*4+3 and 3.5 + 4 % 3 are acceptable expressions. The operator in the expression might be +, -, *, /, and %. Your program must print out the expression and its computing result. The sample output for the input expression 3.5*4+3 is shown below: 
3.5 * 4 + 3 = 17 

Requirement
Write a static method BigDecimal calculate(String exp) to compute the expression and return a BigDecimal result. The operands should be stored as BigDecimal in this method. You have to use the arithmetic operators provided by the BigDecimal class to calculate the expression. (未依規定，以 0 分計)

Input 
There are many input lines. Each line has an input expression Exp. There are three operands and two operators in Exp.

Output
For each input expression Exp, please output the expression and its computing result. Note that all tokens are separated by a space character. (小數點以下印一位)
*/

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.Arrays;  
import java.util.Scanner;  
import java.util.StringTokenizer;  
  
public class Main {  
  
    public static BigDecimal calculate(String exp){  
  
        StringTokenizer st = new StringTokenizer(exp,"0123456789. ");  
        StringTokenizer ma = new StringTokenizer(exp, "+-*/% ");  
  
        String[] operator = new String[5];  
        String[] digits = new String[5];  
        Arrays.fill(operator, "0");  
        Arrays.fill(digits, "0");  
  
        int i = 0;  
        boolean flag = false;  
        while( st.hasMoreTokens() ){  
  
            if( exp.charAt(0) == '-' && !flag ){  
                String haha = st.nextToken();  
                flag = true;  
                continue;  
            }  
            else{  
                operator[i] = st.nextToken();  
                i++;  
            }  
  
        }  
        int j = 0;  
        while( ma.hasMoreTokens() ){  
            digits[j] = ma.nextToken();  
            j++;  
        }  
  
        boolean e = false;  
        for( int k = 0; k < j-1; k++ ){  
            if(exp.charAt(0) == '-' || operator[k].equals("0") ){  
                break;  
            }  
            System.out.print(digits[k] + " ");  
            System.out.print(operator[k] + " ");  
            e = true;  
        }  
        if( e ){  
            System.out.print(digits[j-1] + " = ");  
        }  
  
        boolean yep = false;  
        if( i == 2 ){  
            if( operator[1].equals("*") || operator[1].equals("/")  || operator[1].equals("%") ){  
                if( operator[0].equals("+") || operator[0].equals("-") ) {  
                    yep = true;  
                    String tp;  
                    tp = operator[1];  
                    operator[1] = operator[0];  
                    operator[0] = tp;  
  
                    String str;  
                    str = digits[1];  
                    digits[1] = digits[0];  
                    digits[0] = str;  
  
                    str = digits[2];  
                    digits[2] = digits[1];  
                    digits[1] = str;  
                }  
  
            }  
        }  
        BigDecimal sum = new BigDecimal(digits[0]);  
        if( exp.charAt(0) == '-'){  
            BigDecimal tmp = BigDecimal.ZERO;  
            sum = tmp.subtract(sum);  
  
        }  
  
  
        i = 0;  
  
        for( int k = 1; k < j; k++ ){  
            BigDecimal b = new BigDecimal(digits[k]);  
            if( operator[i].equals("+") ){  
                sum = sum.add(b);  
            }  
            else if( operator[i].equals("-") ){  
                if(yep){  
                    sum = b.subtract(sum);  
                }  
                else{  
                    sum = sum.subtract(b);  
                }  
            }  
            else if( operator[i].equals("*") ){  
                sum = sum.multiply(b);  
            }  
            else if( operator[i].equals("/") ){  
                sum = sum.divide(b, 1 , RoundingMode.CEILING);  
            }  
            else if( operator[i].equals("%") ){  
                sum = sum.remainder(b);  
            }  
            i++;  
        }  
  
        return sum;  
    }  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
  
        while( input.hasNext() ){  
            String exp = input.nextLine();  
            BigDecimal ans = calculate(exp);  
            // BigDecimal 四捨五入的寫法 .setScale( 想要留取的位數, RoundingMode.HALF_UP)  
            System.out.println(ans.setScale(1, RoundingMode.HALF_UP));  
        }  
    }  
}  