/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Daokh
 */
public class Tang {
    private String ID_tang;
    private String name_tang;

    public Tang(String ID_tang, String name_tang) {
        this.ID_tang = ID_tang;
        this.name_tang = name_tang;
    }

    public Tang(String name_tang) {
        this.name_tang = name_tang;
    }

    public String getID_tang() {
        return ID_tang;
    }

    public void setID_tang(String ID_tang) {
        this.ID_tang = ID_tang;
    }

   

    public String getName_tang() {
        return name_tang;
    }

    public void setName_tang(String name_tang) {
        this.name_tang = name_tang;
    }

    
}
