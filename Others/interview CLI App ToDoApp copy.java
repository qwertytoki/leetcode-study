import java.util.*

class ToDoItem{
    private String task;
    private boolean isCompleted;
    
    public ToDoItem(Stirng task, boolean isCompleted){
        this.task = task;
        this.isCompleted = isCompleted;
    }
    //getter setter
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
    private List<ToDoItem> toDoList;

    public TodoApp(){
        this.toDoList = new ArrayList<>();
    } 

    public void addTask(String task){
        toDoList.add(new ToDoItem(task, false));
    }

    public void showAllList(){
        if(toDoList.isEmpty()){
            System.out.println("There is no ToDo now. Please add ToDo.");
        }
        for(int i =0;i<toDoList.size(); i++){
            System.out.println(task.getTask());
        }
    }
    

    public static void main(String[] args){
        ToDoApp app = new ToDoApp();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("ToDo App start");
            System.out.println("Select the option:");
            System.out.println("1: add ToDo");
            System.out.println("2: show all ToDos");
            System.out.println("3: exit App");
            int option = -1;
            if(scanner.hasNextInt()){
                option = scanner.nextLine();
            }else{
                System.out.println("invalid input, please input 1-3");
            }

            switch(option){
                case 1:
                    System.out.println("Please input ToDo");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.println("-------ToDo List start---------");
                    app.showAllList();
                    System.out.println("-------ToDo List end---------");
                    break;
                case 3:
                    System.out.println("Bye.");
                    scanner.close();
                    return;
                default:
                    System.out.println("invalid input. please input 1-3");
                
            }
        }

        
    }
}