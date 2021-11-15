/*
當字串中帶有 `+ * | \` 等符號時要寫 `\\` 轉義，因為他們在正則表達示中有相應的不同意義
最後放 0 的原因 -> limit is 0; array contains all substrings
Positive Lookahead or Lookbehind 觀念
“((?=@)|(?<=@))” -> 才會把 運算子 還有 運算元 都單獨切開
*/
String[] array = str.split("((?=\\+|-|\\*|/|\\)|\\(|%)|(?<=\\+|-|\\*|/|\\)|\\(|%))",0);

/*
預設 ans 賦值 可控制小數點位數 ex 0.000 -> 小數點後三位
*/
BigDecimal ans = new BigDecimal("0.000");

/*
取運算子的部分用 StringTokenizer 更為方便
*/
StringTokenizer st = new StringTokenizer(str,"0123456789.");
boolean flag = true;
while(st.hasMoreTokens()){
    System.out.print( flag ? st.nextToken() : " " + st.nextToken());
    flag = false;
}