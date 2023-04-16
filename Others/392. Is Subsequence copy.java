class Solution {
    String source, target;
    Integer leftBound, rightBound;
    public boolean isSubsequence(String s, String t) {
        this.source = s;
        this.target = t;
        this.leftBound = s.length();
        this.rightBound = t.length();
        return isSubsequence(0, 0);
    }

    private boolean isSubsequence(int left, int right){
        if(leftBound == left){
            return true;
        }
        if(rightBound == right){
            return false;
        }
        if(source.charAt(left) == target.charAt(right)){
            ++left;
        }
        ++right;
        return isSubsequence(left,right);
    }
}