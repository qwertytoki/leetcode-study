
import java.util.*;
import java.util.function.Consumer;

public class Wise_EventDrivenSystem {

    public static void main(String[] args) {
        Consumer<String> printWithPrefix = (data) -> System.out.println("Prefix: " + data);
        printWithPrefix.accept("Hello world!");
    }

}
