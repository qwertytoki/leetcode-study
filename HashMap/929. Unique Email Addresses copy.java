class Solution {
    public int numUniqueEmails(String[] emails) {
        //1 devide local and domain part
        //2 domain -> just put to Set. everything will not be ignored.
        //3 local  -> . and + will be ignored. + will ignore all character after it.
        Set<String> uniqueEmail = new HashSet<>();
        for(String email:emails){
            String local = email.split("@")[0];
            String domain = email.split("@")[1];
            String convertedLocal = convertLocal(local);
            uniqueEmail.add(convertedLocal + "@" + domain);
        }

        return uniqueEmail.size();
    }

    private String convertLocal(String local){
        char[] localArray = local.toCharArray();
        char[] converted = new char[localArray.length];
        int idx = 0;
        for(char c:localArray){
            if(c == '.') continue;
            if(c == '+') break;
            converted[idx++] = c;
        }
        return String.valueOf(Arrays.copyOf(converted,idx));
    }
}