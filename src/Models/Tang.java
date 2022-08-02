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
    private int ID_tang;
    private String name_tang;
    private int MaNT;

    public Tang(int ID_tang, String name_tang, int MaNT) {
        this.ID_tang = ID_tang;
        this.name_tang = name_tang;
        this.MaNT = MaNT;
    }

    public Tang(int ID_tang) {
        this.ID_tang = ID_tang;
    }

    public int getID_tang() {
        return ID_tang;
    }

    public void setID_tang(int ID_tang) {
        this.ID_tang = ID_tang;
    }

    public String getName_tang() {
        return name_tang;
    }

    public void setName_tang(String name_tang) {
        this.name_tang = name_tang;
    }

    public int getMaNT() {
        return MaNT;
    }

    public void setMaNT(int MaNT) {
        this.MaNT = MaNT;
    }
    
}
