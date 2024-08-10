class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1 || s.length()==1) return s;

        List<StringBuilder> sbs =new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            sbs.add(new StringBuilder());
        }   
        int level = 0;
        int step = 1;
        for(int i = 0; i<s.length(); i++){
            StringBuilder sb = sbs.get(level);
            sb.append(s.charAt(i));
            level += step;
            if(level==0 || level >= numRows-1){
                step *= -1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb: sbs){
            result.append(sb);
        }
        return result.toString();
    }
}