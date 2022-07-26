package signin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TRA
 */
public class User {
   String User;
   String Pass;
   String Role;
   int Remember;

    public User(String User) {
        this.User = User;
    }

    public int getRemember() {
        return Remember;
    }

    public void setRemember(int Remember) {
        this.Remember = Remember;
    }
    public User() {
    }

    public User(String User, String Pass, String Role, int Remember) {
        this.User = User;
        this.Pass = Pass;
        this.Role = Role;
        this.Remember = Remember;
    }



    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

    public String getRole() {
        return Role;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
   
   
}
