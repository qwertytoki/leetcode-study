class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] cArray = s.toCharArray();
        for(char c:cArray){
            if(c == '{' || c =='(' || c == '['){
                stack.add(c);
            }else{
                char a = stack.isEmpty() ? '!' : stack.pollLast();
                switch(c){
                    case ')': 
                    if(a != '('){
                        return false; 
                    }
                    break;
                    case ']': 
                    if(a != '['){
                        return false; 
                    }
                    break;
                    case '}': 
                    if(a != '{'){
                        return false; 
                    }
                    break;
                } 
            }
        }   
        return stack.isEmpty(); 
    }
}