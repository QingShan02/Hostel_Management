/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.NhaTro;

/**
 *
 * @author Daokh
 */
public class Customer {

    private int Ma_KH;
    private String HoTen;
    private String SDT;
    private String mail;
    private int nguoiDD;
    private int Ma_PHG;
    public Customer() {
    }


    public int getNguoiDD() {
        return nguoiDD;
    }

    public void setNguoiDD(int nguoiDD) {
        this.nguoiDD = nguoiDD;
    }

    public int getMa_KH() {
        return Ma_KH;
    }

    public void setMa_KH(int Ma_KH) {
        this.Ma_KH = Ma_KH;
    }

    public Customer(int Ma_KH, String HoTen, String SDT, String mail, int nguoiDD, int Ma_PHG) {
        this.Ma_KH = Ma_KH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.mail = mail;
        this.nguoiDD = nguoiDD;
        this.Ma_PHG = Ma_PHG;
    }

    public int getMa_PHG() {
        return Ma_PHG;
    }

    public void setMa_PHG(int Ma_PHG) {
        this.Ma_PHG = Ma_PHG;
    }





    


    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
