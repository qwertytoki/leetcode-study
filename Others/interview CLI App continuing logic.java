import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("input something");
            String userInput = scanner.nextLine();
            System.out.println("user input: " + userInput);
            System.out.println("finish? yes or no");
            String isFinish = scanner.nextLine();
            if(isFinish.equals("yes")){
                System.out.println("finished");
                break;
            }
        }
    }
}