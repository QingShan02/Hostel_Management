package signin;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TRA
 */
public class User implements Serializable{
   String User;
   String Pass;
//   int Remember;

//    public User(String User) {
//        this.User = User;
//    }

//    User(String text, char[] password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public int getRemember() {
//        return Remember;
//    }
//
//    public void setRemember(int Remember) {
//        this.Remember = Remember;
//    }
    public User() {
    }

    public User(String User, String Pass) {
        this.User = User;
        this.Pass = Pass;
//        this.Remember = Remember;
    }



    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }


    public void setUser(String User) {
        this.User = User;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

   
   
}
