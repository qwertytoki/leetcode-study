
class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0) {
                words.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
            sb.setLength(0);
        }

        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }
}
