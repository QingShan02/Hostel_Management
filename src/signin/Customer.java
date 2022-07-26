/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signin;

/**
 *
 * @author Daokh
 */
public class Customer extends User{

    private String Ma_KH;
    private String HoTen;
    private String SDT;
    private String mail;
    private int TrangThai;

    public Customer() {
    }

    public Customer(String Ma_KH, String HoTen, String SDT, String mail, int TrangThai, String User) {
        super(User);
        this.Ma_KH = Ma_KH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.mail = mail;
        this.TrangThai = TrangThai;
    }



    public String getMa_KH() {
        return Ma_KH;
    }

    public void setMa_KH(String Ma_KH) {
        this.Ma_KH = Ma_KH;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
