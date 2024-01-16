class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> mailSet = new HashSet<>();
        for(String email :emails){
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];
            local = local.replace(".", "").split("\\+")[0];
            email = local + "@" + domain;
            mailSet.add(email);
        }
        return mailSet.size();
    }
}