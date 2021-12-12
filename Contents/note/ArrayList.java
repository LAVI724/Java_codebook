public static void removeDuplicate(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            // 第一次出現此元素
            int first = list.indexOf(list.get(i));
            // 最後一次出現此元素
            int last = list.lastIndexOf(list.get(i));
            
            if(first == last){
                list.remove(i);
                i--;
            }
        }
    }