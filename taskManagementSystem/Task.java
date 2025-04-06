package taskManagementSystem;
import java.util.Date;

public class Task {

    private String title;
    private String description;
    private Date dueDate;
    private Integer priority;
    private State state;
    private User user;

    public Task(String title,String description,Date dueDate,Integer priority,State state, User user){
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.priority = priority;
            this.state = state;
            this.user = user;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public Date getDueDate(){
        return this.dueDate;
    }
    public Integer getPriority(){
        return this.priority;
    }
    public State getState(){
        return this.state;
    }
    public User getUser(){
        return this.user;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void getDescription(String description){
         this.description = description;
    }
    public void setDueDate(Date date){
        this.dueDate = date;
    }
    public void setPriority(Integer priority){
         this.priority = priority;
    }
    public void setState(State state){
        this.state = state;
    }
    public void setUser(User user){
        this.user = user;
    }


}