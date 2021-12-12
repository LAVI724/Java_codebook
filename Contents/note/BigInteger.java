// BigInteger 有內建搜尋 nextProbablePrime
BigInteger n = new BigInteger(String.valueOf(1000000));
for(int i = 0; i < 10; i++){
    BigInteger ans = n.nextProbablePrime();
    System.out.println(ans);
    n = ans;
}
    
