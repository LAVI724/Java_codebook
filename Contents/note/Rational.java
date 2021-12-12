static class Rational {

    private int Molecular, Denominator;

    // 設立 consturctor 接收兩個整數參數為 分子/分母 的初值
    public Rational( int m, int d){
        this.Molecular = m;
        this.Denominator = d;
    }

    // 分別創立 Molecular、Denominator 的 get 和 set member methods
    public int getMolecular() {
        return this.Molecular;
    }
    public int getDenominator() {
        return this.Denominator;
    }
    // set member methods -> 為了讓 private 的參數可以使用的 member function
    public int setMolecular(){
        return this.Molecular;
    }
    public int setDenominator(){
        return this.Denominator;
    }
    
    // 整數的四則運算
    public Rational add( Rational rt2 ) {

        int d = this.Denominator * rt2.Denominator;
        int m = (( this.Molecular * ( d / this.Denominator )) + ( rt2.Molecular * ( d / rt2.Denominator )));

        BigInteger gcdn = BigInteger.valueOf(m).gcd( BigInteger.valueOf(d) );
        m =  Integer.parseInt( String.valueOf( BigInteger.valueOf(m).divide(gcdn) ) );
        d =  Integer.parseInt( String.valueOf( BigInteger.valueOf(d).divide(gcdn) ) );

        if( m == 0 || d == 0 ){
            return new Rational(0,0);
        }
        else if( m < 0 && d < 0 ){
            return new Rational( -m, -d );
        }
        return new Rational( m, d );
    }
    
                    ...
        
}
public static void main(String[] args) {

                ...

    if( oper.equals("+") ){
        // 要設立一個 Ration div 去接回傳回來的 Rational class 型態
        // 之後取 Molecular 和 Denominator 都是用他去接
        Rational div = rt1.add(rt2);
        if( div.Molecular == 0 ){
            System.out.println("0");
        }
        else if( div.Molecular % div.Denominator == 0 ){
            System.out.println(div.Molecular / div.Denominator);
        }
        else{
            System.out.println("(" + div.Molecular + "/ " + div.Denominator + ")");
        }
    }

                    ...
}