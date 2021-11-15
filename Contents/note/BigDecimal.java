// 利用 BigDecimal 去取小數點並四捨五入  
            BigDecimal ans = new BigDecimal(a);  
            System.out.println( ans.setScale(3, RoundingMode.HALF_UP));

            