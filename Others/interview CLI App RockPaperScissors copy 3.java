import java.util.*;

class CLIApp{
    private static final String[] hands = {"Rock", "Paper", "Scissors"};
    public static void main(String[] args){
        int[] result = new int[]{0,0,0}; // 0: win, 1:lose, 2:draw
        while(true){
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("Rock, Paper, Scissors...");
            System.out.println("Please input Rock:0, Paper:1, Scissors:2");
            int userHand = getUserHand(scanner);
            if(userHand == -1)continue;
            System.out.println("User Hand :"+ hands[userHand]);
            int cpuHand = random.nextInt(3);
            System.out.println("cpu Hand :"+ hands[cpuHand]);
            
            judge(userHand, cpuHand, result);
            
            System.out.println("Finish? type yes or no");
            String isFinish = scanner.nextLine();
            if(isFinish.equals("yes")){
                System.out.println("Finish!!!");
                showResult(result);
                scanner.close();
                return;
            }
        }
    }
    
    private static int getUserHand(Scanner scanner){
        int userHand = -1;
        if(scanner.hasNextInt()){
            userHand = scanner.nextInt();
            scanner.nextLine();
        }else{
            System.out.println("invalid hand! please input 0,1,2. ");
            return -1;
        }
        
        if(userHand< 0 || userHand>2){
            System.out.println("invalid hand! please input 0,1,2. ");
            return -1;
        }
        return userHand;
    }
    private static void showResult(int[] result){
        System.out.println("Win:" + result[0]);
        System.out.println("Lose:" + result[1]);
        System.out.println("Draw:" + result[2]);
    }

    private static void judge(int userHand, int cpuHand, int[] result){
        if(cpuHand == userHand){
            System.out.println("draw!");
            result[2]++;
            showResult(result);
        }
        else if((userHand == 0 && cpuHand ==1)||
            (userHand == 1 && cpuHand ==2)||
            (userHand == 2 && cpuHand ==0)
        ){
            System.out.println("you lose!");
            result[1]++;
            showResult(result);
        }else{
            System.out.println("you win!");
            result[0]++;
            showResult(result);
        }
    }
}