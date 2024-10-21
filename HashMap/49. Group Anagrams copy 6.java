class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);
            List strList = map.getOrDefault(sortedStr, new ArrayList<>());
            strList.add(str);
            map.put(sortedStr, strList);
        }
        return new ArrayList(map.values());
    }
}

class Main{
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}

public static void main(String args[]){
    System.out.println("Hello World!");
}

class Main{
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}