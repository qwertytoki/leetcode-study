class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)== ' ')continue;
            for(int j = i; j<s.length(); j++){
                if(s.charAt(j)== ' ' || j == s.length()-1){
                    if(j == s.length()-1 && s.charAt(j)!= ' ')j++;
                    list.add(s.substring(i,j));
                    i = j;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i>=0; i--){
            sb.append(list.get(i));
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}