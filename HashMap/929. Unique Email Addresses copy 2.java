class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email :emails){
            String[] part = email.split("@");
            String local = part[0].replace(".","");
            uniqueEmails.add(local.split("\\+")[0]+ "@"+part[1]);
        }
        return uniqueEmails.size();
    }
}