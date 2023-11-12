import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Todo {
    
    private List<Task> listOfTasks;
    private int completedWorkload;

    public Todo() {
        listOfTasks = new ArrayList<>();
        completedWorkload = 0;
    }

    public void addTask(String description, int priority, int minutes) {
        if ((priority<=4&&priority>=1)||minutes>=0) {
            listOfTasks.add(new Task(description, priority, minutes));
        } 
        if (priority>4||priority<1) {
            System.out.println(description + " has invalid priority");
        }
        if (minutes<0) {
            System.out.println(description + " has invalid workload");
        }
    }

    public void print() {
        if (listOfTasks.isEmpty()==true) {
            System.out.println("Todo:\n-----");
            System.out.println("You're all done for today! #TodoZero");
        } else {
            System.out.println("Todo:\n-----");
            for (Task task : listOfTasks) {
                System.out.println(task.toString());
            }
        }
        if (completedWorkload>0) {
            System.out.println(completedWorkload + " minutes of work done!");
        }
    }

    public void completeTask(int index) {
        try {
            listOfTasks.get(index);
            completedWorkload = completedWorkload + listOfTasks.get(index).getWorkload();
            listOfTasks.remove(index);
        } catch ( IndexOutOfBoundsException e ) {
            System.out.println("Invalid index");
        }
    }

    public void printPriority(int limit) {
        boolean tasksExists = false;

        System.out.println("Filtered todo:\n--------------");

        for (Task task : listOfTasks) {
            if (task.getPriority()<=limit) {
                System.out.println(task.toString());
                tasksExists = true;
            }
        
        if (!tasksExists) {
            System.out.println("No tasks with given priority");
            }
        }
    }

    public void printPrioritized() {
        System.out.println("Prioritized todo:\n-----------------");
        listOfTasks.sort(Comparator
            .comparing(Task::getPriority)
            .thenComparing(Task::getWorkload)
        );
        for (Task task : listOfTasks) {
            System.out.println(task.toString());
        }  
    } 
}
