package taskManagementSystem;

import java.util.List;

public class User {
    private String name;
    private String email; 

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getUserName(){
        return this.name;
    }

    public String getUserEmail(){
        return this.email;
    }

}
