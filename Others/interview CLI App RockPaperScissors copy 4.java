import java.util.*;


/**
 * CLI app 
 * 1 get user input 
 * 2 get CPU input
 * 3 judge
 * 4 show the result
 * 
 */

class CLIApp{
    private String[] hands = new int[]{"Rock","Paper","Scissors"};

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System,in);    
        System.out.println("Rock, Paper, Scissors....");
        System.out.println("Please input Rock:0, Paper:1, Scissors:2");
        int userHand = -1;
        if(scanner.hasNextInt()){
            userHand = scanner.nextInt();
            scanner.nextLine();
        }else{
            System.out.println("invalid input, please input 0 or 1 or 2");
            scanner.nextLine();
            continue;
        }
        Random random = new Random();
        random.getInt(3);
        
    }

}