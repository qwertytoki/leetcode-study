
class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> charLists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            charLists.add(new ArrayList<>());
        }
        int current = 0;
        boolean goingUp = true;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = charLists.get(current);
            list.add(s.charAt(i));
            if (goingUp) {
                current++;
                if (current == numRows - 1) {
                    goingUp = false;
                }
            } else {
                current--;
                if (current == 0) {
                    goingUp = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> cList : charLists) {
            for (char c : cList) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
