/**
你看到在建構式參數與物件資料成員同名時，可用this加以區別
*/

public class CashCard {
    
    private String number;
    private int balance;
    private int bonus;

    public CashCard(String number, int balance, int bonus) {
        this.number = number;     
        // 參數number指定給這個物件的number

        this.balance = balance;   
        // 參數balance指定給這個物件的balance
        
        this.bonus = bonus;        
        // 參數bonus指定給這個物件的bonus
    }
    ...
}