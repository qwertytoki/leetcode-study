class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        
        // procedure to get unique mails
        for(String email : emails){
            // transfer to char array
            char[] array = email.toCharArray();
            char[] convertedArray = new char[array.length()];
            int idx = 0;
            for(char c : array){
            // remove . 
                if(c == ".") continue;
            // remove after +
                if(c == "+")break;
            // remove after@
                if(c == "@")break;
                
                covertedArray[idx++]= c;
            
            }
            
            // convert it to String
            String convertedStr = convertedArray.toString();
            // put to Set 
            emailSet.add(convertedStr);
        }
        
        return emailSet.length();
    }
}