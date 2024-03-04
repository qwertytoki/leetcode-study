import java.util.*;
import lombok.*;

@Data
@AllArgsConstructor
public class ToDoItem{
    private String task;
    private boolean isCompleted;

    public getItem(){
        return (isCompleted: "[X]" ? "[]") + task;
    }
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
        return tasks;
    }

    public static void main(String args[]){
        
    }


}



