import java.util.Scanner;
class CLIApp{
    public static void main(String[] args){
        System.out.println("hello world");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what do you want to do?");
        
        String userInput = scanner.nextLine();
        
        System.out.println("you chose:"+userInput);
        
        System.out.println("Complete Todo App, Bye!");
        scanner.close();
    }
}