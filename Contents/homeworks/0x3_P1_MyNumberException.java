import java.util.*;  
  
public class Main {  
  
    // 編寫例外狀況，需要 extends Exception
    // 模板為 static class <例外狀況名稱> extends Exception
    static class MyNumberFormatException extends Exception {  
  
    }  
    // 在頭宣告 throws 內部依據要求不符者 throw
    public static String Dec2Hex(int dec) throws MyNumberFormatException{  
        String hex = "";  
        String token = "ABCDEF";  
        while(dec > 0){  
            // 16進位取 每位%16
            int tmp = dec % 16;  
            if(tmp > 9){
                // 如果是 10~15 就先減10後利用 token 去讀取 ABCDEF  
                hex = hex.concat(String.valueOf(token.charAt(tmp-10)));  
            }  
            else{  
                hex = hex.concat(String.valueOf(tmp));  
            }  
            dec /= 16;  
        }  
        // 因為是從 dec 的尾開始接字串 因此反而越尾端會在字串越前面 所以要 reverse
        StringBuilder st = new StringBuilder(hex);  
        st.reverse();  
        return String.valueOf(st);  
    }  
    public static int hex2D(String hexString) throws MyNumberFormatException {  
        int dec = 0;  
        for(int i = 0; i < hexString.length(); i++){  
            if(hexString.charAt(i) >= 'A' && hexString.charAt(i) <= 'F'){  
                dec = dec*16 + (hexString.charAt(i) - 'A' + 10);  
            }  
            else if(hexString.charAt(i) >= '0' && hexString.charAt(i) <= '9'){  
                dec = dec + (hexString.charAt(i) - '0');  
            }  
            else{  
                // 一般程式會自動拋出內建例外 但如果是自定的就要設 throw new <你的例外>
                throw new MyNumberFormatException();  
            }  
        }  
        return dec;  
    }  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        int intn = input.nextInt();  
        String endl = input.nextLine();  
        String str1 = input.nextLine();  
        String str2 = input.nextLine();  
  
        // 一定要用 try 和 catch 接 必要時還會有 finally
        // 在此判斷是否有例外產生
        try{  
            System.out.println(Dec2Hex(intn));  
            System.out.println(hex2D(str1));  
            System.out.println(hex2D(str2));  
        }  
        // catch <Exception class 名稱> 
        // 這裡的 e 是自訂物件名稱
        // 若抓到了例外
        catch (MyNumberFormatException e) {  
            System.out.println("String is no HEX");  
        }  
  
    }  
}  