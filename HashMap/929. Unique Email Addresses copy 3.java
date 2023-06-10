class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email:emails){
            String[] dividedEmail = email.split("@");
            String name = dividedEmail[0];
            name = name.replace(".","");
            name = name.split("\\+")[0];
            emailSet.add(name + "@" +dividedEmail[1]);
        }

        return emailSet.size();
    }
}