import java.util.Scanner;

public class Main {

    // 宣告 Exception 類別 (除了變數名稱外 格式是固定的
    static class NullDenominatorException extends Exception {
    }
    static class Fraction{
        private static int deci;
        private String str;

        // 在頭宣告 throws 內部依據要求不符者 throw
        public Fraction(String str) throws NullDenominatorException {
            deci = 0;
            for(int i = str.length()-1; i >= 0; i--){
                if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                    throw new NullDenominatorException();
                }
                deci += Math.pow(2, str.length()-1-i)*Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }

        public static int getDecimal(){
            return deci;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str;
        while(input.hasNextLine()){
            str = input.next();

            // 一定要用 try 和 catch 接 必要時還會有 finally
            try{
                Fraction fraction = new Fraction(str);
                System.out.println(Fraction.getDecimal());
            }
            catch(NullDenominatorException e){
                System.out.println("String no Binary");
                break;
            }
        }
    }
}