class Solution {
    public String reverseVowels(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] sChar = s.toCharArray();
        char[] result = new char[sChar.length];
        for(char c : sChar){
            if(c == 'a' ||c == 'i' ||c == 'u' ||c == 'e' ||c == 'o'||c == 'A'||c == 'I'||c == 'U'||c == 'E'||c == 'O'){
                stack.add(c);
            }
        }
        for(int i = 0; i< sChar.length; i++){
            if(sChar[i] == 'a' ||sChar[i] == 'i' ||sChar[i] == 'u' ||sChar[i] == 'e' ||sChar[i] == 'o'||sChar[i] == 'A'||sChar[i] == 'I'||sChar[i] == 'U'||sChar[i] == 'E'||sChar[i] == 'O'){
                result[i] = stack.pollLast();
            } else{
                result[i] = sChar[i];
            }
        }
        return String.valueOf(result);
    }
}