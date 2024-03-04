import java.util.*;
import lombok.*;

@Data
@AllArgsConstructor
public class ToDoItem{
    private String task;
    private boolean isCompleted;
}


import java.util.*;
public class ToDoApp{
    private List<ToDoItem> tasks;

    public TodoApp(){
        tasks = new ArrayList<>();
    }
    
    public addTask(String task){
        tasks.add(new ToDoItem(task, false));
    }

    public void showAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("There is no task now.");
            return;
        }
        for(ToDoItem task:tasks){
            System.out.println(task.getTask());
        }
    }

    public static void main(String args[]){
        TodoApp app = new ToDoApp();
        Scanner scanner = new Scanner();

        while(true){
            System.out.println("ToDo App");
            System.out.println("1: Add task");
            System.out.println("2: Show added tasks");
            System.out.println("3: Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    System.out.println("Please input a task.");
                    String task = scanner.nextLine();
                    app.addTask();
                    break;
                case 2:
                    app.showAllTasks();
                    break;
                case 3:
                    System.out.println("Exiting, bye.");
                    return;
                default:
                    System.out.println("Please type option 1~3");
            }
        }
    }


}



