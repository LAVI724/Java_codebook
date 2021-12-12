import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        while(input.hasNextLine()){
            str = input.next();
            try{
                System.out.println(bin2Dec(str));
            }
            catch(BinaryFormatException e){
                System.out.println("String no Binary");
                break;
            }
        }
    }
    public static class BinaryFormatException extends Exception {
    }
    public static int bin2Dec(String str) throws BinaryFormatException{
        int deci = 0;
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                throw new BinaryFormatException();
            }
            deci += Math.pow(2, str.length()-1-i)*Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return deci;
    }
}