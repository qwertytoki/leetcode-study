class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        int step =1;

        for(char c : s.toCharArray()){
            rows.get(currRow).append(c);
            currRow += step;
            if(currRow == 0 || currRow == numRows -1){
                step *= -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row:rows){
            result.append(row);
        }
        return result.toString();
        
    }
}