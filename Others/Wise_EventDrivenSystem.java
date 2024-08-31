
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Wise_EventDrivenSystem {

    public static void main(String[] args) {

        EventDrivenSystem system = new EventDrivenSystem();
        system.subscribeToEvent("TRANSACTION_COMPLETED", data -> System.out.println("Service1 received" + data));
        system.subscribeToEvent("TRANSACTION_COMPLETED", data -> System.out.println("Service2 received" + data));

        system.publishEvent("TRANSACTION_COMPLETED", "Transaction ID :12345");
        system.publishEvent("TRANSACTION_PROCESSING", "Transaction ID :12346");
    }

}

class EventDrivenSystem {

    Map<String, List<Consumer<String>>> eventMap;

    public EventDrivenSystem() {
        eventMap = new ConcurrentHashMap<>();
    }

    public void publishEvent(String eventType, String data) {
        if (!eventMap.containsKey(eventType)) {
            System.out.println("no event is registered eventType: " + eventType);
            return;
        }
        for (Consumer<String> consumer : eventMap.get(eventType)) {
            consumer.accept(data);
        }
    }

    public void subscribeToEvent(String eventType, Consumer<String> handler) {
        if (!eventMap.containsKey(eventType)) {
            eventMap.put(eventType, new ArrayList<>());
        }
        List<Consumer<String>> consumers = eventMap.get(eventType);
        consumers.add(handler);
    }
}
