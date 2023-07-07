class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails){
            String[] split = email.split("@");
            String first = split[0];
            String second = split[1];
            first = first.replace(".","").split("\\+")[0];
            email = first + "@" + second;
            emailSet.add(email);
        }
        System.out.println(emailSet);
        return emailSet.size();
    }
}
// time:O(N)
// space:O(N)