import java.util.*;
class CLIApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] hands = {"Rock","Paper","Scissors"};
        
        System.out.println("Rock(0), Paper(1), Scissors(2)....");
        int userHand = scanner.nextInt();
        if(userHand < 0 || userHand > 2){
            System.out.println("invalid input");
            return;
        }
        int cpuHand = random.nextInt(3);
        System.out.println("cpu hand:"+ hands[cpuHand]);
        if(userHand == cpuHand){
            System.out.println("draw!");
        }else if(
            (userHand == 0 && cpuHand ==1)||
            (userHand == 1 && cpuHand ==2)||
            (userHand == 2 && cpuHand ==0)
        ){
            System.out.println("you lose!");
        }else{
            System.out.println("you win!");
        }
        scanner.close();
    }
}
