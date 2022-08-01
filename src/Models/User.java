package Models;

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
public class User implements Serializable {

    String User;
    String Pass;
    boolean Remember;
    boolean isLogin;

    public boolean isRemember() {
        return Remember;
    }

    public void setRemember(boolean Remember) {
        this.Remember = Remember;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public User(String User, String Pass, boolean Remember, boolean isLogin) {
        this.User = User;
        this.Pass = Pass;
        this.Remember = Remember;
        this.isLogin = isLogin;
    }

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
