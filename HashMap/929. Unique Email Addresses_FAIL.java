class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        
        // procedure to get unique mails
        for(String email : emails){
            String[] strArray = email.split("@",0);
            // transfer to char array
            char[] array = strArray[0].toCharArray();
            char[] convertedArray = new char[array.length];
            int idx = 0;
            for(char c : array){
            // remove . 
                if(c == '.') continue;
            // remove after +
                if(c == '+')break;
            // remove after@
                if(c == '@')break;
                
                convertedArray[idx++] = c;
            
            }
            
            // convert it to String
            String convertedStr = String.valueOf(convertedArray)+ strArray[1];
            System.out.println(convertedStr);
            // put to Set 
            emailSet.add(convertedStr);
        }
        return emailSet.size();
    }
}