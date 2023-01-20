class Solution {
    public List<String> generateParenthesis(int n) {
        // brute force
        // recuring solution

        List<String> result = new ArrayList<>();
        generateAll(new char[n*2], 0, result);
        return result;
    }

    private void generateAll(char[] current, int position, List<String> result){
        if(current.length == position){
            if(isValid(current)){
                result.add(new String(current));
            }
        }else{
            current[position] = '(';
            generateAll(current,position+1,result);
            current[position] = ')';
            generateAll(current,position+1,result);
        }
    }

    private boolean isValid(char[] current){
        int balance = 0;
        for(char c : current){
            if(c=='('){
                balance++;
            }else{
                balance--;
                if(balance<0){
                    return false;
                }
            }
        }
        return balance==0;
    }
}