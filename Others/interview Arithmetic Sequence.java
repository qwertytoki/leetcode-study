// "static void main" must be defined in a public class.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(arithmeticSequence(2,3,5));
    }
    
    public static List<Integer> arithmeticSequence(int a, int d, int n){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int number = d*i + a;
            result.add(number);
        }
        return result;
    }
}