import java.util.*;

/**
 * Simple ToDo App
 * CLI app
 * add task
 * show the list of tasks
 * complete tasks 
 * exit
 * 
 * ((("HERE")))
 * what do you want to do?
 * 
 * 1 add task
 * 2 show all the todos
 * 3 make the task done
 * 9 exit app
 * please choose 1 ~ 4
 * (user input 1 ~ 9)
 * 
 * small validation
 * - is integer check
 * - is valid number check
 * -> if invalid, return error message and ask them to input again
 * 
 * if user input valid way, follow the procedure.
 * once it finish, we return to "HERE"
 * 
 * 
 * the way to show all the todos
 * if no todos here: 
 * show "There is no ToDo now."
 * 
 * we show ToDO list as following 
 * 
 * ----------ToDo list start---------------
 * [] 1. discuss the spec
 * [] 2. write the code
 * [X] 3. deploy and test  // [X] means completed task
 * ----------ToDo list start---------------
 */

class ToDoItem{
    private String task;
    // private String taskDetail;
    private boolean isCompleted;
    // private LocalDateTime dueDate;

    public ToDoItem(String task){
        this.task = task;
        this.isCompleted = false;
    }
    //getter and setter
    public String getTask(){
        return task;
    }
    public boolean isCompleted(){
        return isCompleted;
    }
    public void setTask(String task){
        this.task = task;
    }
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
}

class ToDoApp{
    private List<ToDoItem> taskList;
    private final String OPTION_NUMBER = "1,2 or 9";
    private final String ERROR_MESSAGE = "invalid input, please choose "+ OPTION_NUMBER;

    public ToDoApp(){
        taskList = new ArrayList<>();
    }

    public void addTask(String task){
        taskList.add(new ToDoItem(task));
    }

    public void showAllTasks(){
        if(taskList.isEmpty()){
            System.out.println("There is no task now.");
            return;
        }
        System.out.println("-------------ToDo List start----------");
        for(int i =0; i< taskList.size(); i++){
            String displayText = (taskList.get(i).isCompleted()?"[X] ":"[] ")+(i+1)+". "+ taskList.get(i).getTask();
            System.out.println(displayText);
        }
        System.out.println("-------------ToDo List end----------");
    }

    // public void setCompleted(int toDoNumber){
        //TODO implement here.
    // }
    
    public static void main(String[] args){
        ToDoApp app = new ToDoApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("ToDo App start!");
        while(true){
            System.out.println("1 add task");
            System.out.println("2 show all the todos");
            System.out.println("9 exit app");
            System.out.println("please choose " + app.OPTION_NUMBER);
            int option = -1;
            if(scanner.hasNextInt()){
                option = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println(app.ERROR_MESSAGE);
                scanner.nextLine();
            }
            switch (option){
                case 1:
                    System.out.println("Please input todo:");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    System.out.println("ToDo added!");
                    break;
                case 2:
                    app.showAllTasks();
                    break;
                case 9:
                    System.out.println("bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println(app.ERROR_MESSAGE);
            }
        }
        

    }

    
}