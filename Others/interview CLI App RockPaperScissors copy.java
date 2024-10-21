import java.util.*;

class CLIApp{
    private static final String[] hands = {"Rock", "Paper", "Scissors"};
    public static void main(String[] args){
        while(true){
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("Rock, Paper, Scissors...");
            System.out.println("Please input Rock:0, Paper:1, Scissors:2");
            int userHand = scanner.nextInt();
            if(userHand< 0 || userHand>2){
                System.out.println("invalid hand! please input 0,1,2. ");
                return;
            }
            System.out.println("User Hand :"+ hands[userHand]);
            int cpuHand = random.nextInt(3);
            scanner.nextLine(); 
            System.out.println("cpu Hand :"+ hands[cpuHand]);
            
            if(cpuHand == userHand){
                System.out.println("draw!");
            }
            else if((userHand == 0 && cpuHand ==1)||
                (userHand == 1 && cpuHand ==2)||
                (userHand == 2 && cpuHand ==0)
            ){
                System.out.println("you lose!");
            }else{
                System.out.println("you win!");
            }
            System.out.println("Finish? type yes or no");
            String isFinish = scanner.nextLine();
            if(isFinish.equals("yes")){
                System.out.println("Finish!!!");
                scanner.close();
                return;
            }
        }
    }
}


// get user input value
// get random cpu hand 
// make a result
// show the result