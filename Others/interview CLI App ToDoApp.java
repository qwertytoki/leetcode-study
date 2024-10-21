import java.util.*;


class ToDoItem{
    private String task;
    private boolean isCompleted;

    public ToDoItem(String task, boolean isCompleted){
        this.task = task;
        this.isCompleted = isCompleted;
    }

    public String getTask(){
        return task;
    }

    public boolean isCompleted(){
        return isCompleted;
    }
    public void setTask(String task){
        this.task = task;
    }

    public void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
}

class ToDoApp{
    
    private List<ToDoItem> tasks;

    public ToDoApp(){
        tasks = new ArrayList<>();
    }
    
    public void addTask(String task){
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

    public static void main(String[] args){
        ToDoApp app = new ToDoApp();
        Scanner scanner = new Scanner(System.in);

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
                    app.addTask(task);
                    break;
                case 2:
                    app.showAllTasks();
                    break;
                case 3:
                    System.out.println("Exiting, bye.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please type option 1~3");
            }
        }
    }


}



