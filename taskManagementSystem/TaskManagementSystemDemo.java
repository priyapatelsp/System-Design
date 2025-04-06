package taskManagementSystem;

import java.util.Date;
import java.util.List;

public class TaskManagementSystemDemo {
    public static void run() {
       TaskManagement taskManager = TaskManagement.getInstance();

        // Create users
        User user1 = new User( "John Doe", "john@example.com");
        User user2 = new User( "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("Task1", "describtion1", new Date(), 1, State.ASSIGNED, user2);
        Task task2 = new Task( "Task 2", "Description 2", new Date(), 2,State.ASSIGNED, user2);
        Task task3 = new Task( "Task 3", "Description 3", new Date(), 1, State.ASSIGNED,user1);

        // Add tasks to the task manager
        taskManager.createNewTask(task1);
        taskManager.createNewTask(task2);
        taskManager.createNewTask(task3);

        // Update a task
        task2.setTitle("Updated title");
       // taskManager.updateTask(task2);

        // Search tasks
        List<Task> searchResults = taskManager.searchTasks("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

    }

    public static void main(String[] args){
        run();
    }


}
