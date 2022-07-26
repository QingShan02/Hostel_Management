/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signin;

/**
 *
 * @author Daokh
 */
public class ChuNhaTro {
    private String maChu;
    private String tenChu;
    private String DT;
    private String email;
    private String usernameChu;

    public ChuNhaTro() {
    }

    public ChuNhaTro(String maChu) {
        this.maChu = maChu;
    }

    public ChuNhaTro(String maChu, String tenChu, String DT) {
        this.maChu = maChu;
        this.tenChu = tenChu;
        this.DT = DT;
    }
    
    public ChuNhaTro(String maChu, String tenChu, String DT, String email, String usernameChu) {
        this.maChu = maChu;
        this.tenChu = tenChu;
        this.DT = DT;
        this.email = email;
        this.usernameChu = usernameChu;
    }

    public String getMaChu() {
        return maChu;
    }

    public void setMaChu(String maChu) {
        this.maChu = maChu;
    }

    public String getTenChu() {
        return tenChu;
    }

    public void setTenChu(String tenChu) {
        this.tenChu = tenChu;
    }

    public String getDT() {
        return DT;
    }

    public void setDT(String DT) {
        this.DT = DT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsernameChu() {
        return usernameChu;
    }

    public void setUsernameChu(String usernameChu) {
        this.usernameChu = usernameChu;
    }
    
}
