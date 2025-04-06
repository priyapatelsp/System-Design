package taskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManagement {
    private static TaskManagement instance;
    private HashMap <User, List<Task>> userTaskMap;
    List<Task> taskLists;


    public void TaskManagement(){
        userTaskMap = new HashMap<>();
        taskLists = new ArrayList<>();
    }

    public static synchronized TaskManagement getInstance() {
        if (instance == null) {
            instance = new TaskManagement();
        }
        return instance;
    }


    public void createNewTask(Task task){
        System.out.println("create new task");
        if(taskLists==null){
            taskLists =new ArrayList<>();
        }
            taskLists.add(task);
        
       // task.getUser().getUserTasks().add(task);
        assignTask(task.getUser(),task);
        System.out.println("Task Created");
    }

    public void deleteTask(Task task){
        taskLists.remove(task);
        if (task != null) {
            unassignTaskFromUser(task);
        }
        System.out.println("Task Created");
    }

    public void unassignTaskFromUser(Task task){
        List<Task> userTaskList = userTaskMap.get(task.getUser());
        if(userTaskList.contains(task)) userTaskList.remove(task);
        System.out.println("removed task from user");
    }

    public User createNewUser(){
        User user = new User("user1","email");
        System.out.println("User Created");
        return user;
    }

    public void assignTask(User user, Task task){
        if(userTaskMap==null) userTaskMap = new HashMap<>();
        userTaskMap.computeIfAbsent(user, k -> new CopyOnWriteArrayList<>()).add(task);
        System.out.println("Task assigned!");
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : taskLists) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public List<Task> filterTasks(State state, Date startDate, Date endDate, int priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskLists) {
            if (task.getState() == state &&
                    task.getDueDate().compareTo(startDate) >= 0 &&
                    task.getDueDate().compareTo(endDate) <= 0 &&
                    task.getPriority() == priority) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markTaskAsCompleted(Task task) {
        if (task != null) {
            synchronized (task) {
                task.setState(State.COMPLETE);
            }
        }
    }

    public List<Task> getTaskHistory(User user) {
        return new ArrayList<>(userTaskMap.getOrDefault(user, new ArrayList<>()));
    }

}
