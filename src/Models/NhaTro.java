/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Daokh
 */
public class NhaTro extends ChuNhaTro{
    private int Ma_NT;
    private String Ten_NT;
    private String diaDiemNT;

    public NhaTro(int Ma_NT, String Ten_NT, String diaDiemNT, String maChu) {
        super(maChu);
        this.Ma_NT = Ma_NT;
        this.Ten_NT = Ten_NT;
        this.diaDiemNT = diaDiemNT;
    }

    public String getTen_NT() {
        return Ten_NT;
    }

    public void setTen_NT(String Ten_NT) {
        this.Ten_NT = Ten_NT;
    }



    public int getMa_NT() {
        return Ma_NT;
    }

    public void setMa_NT(int Ma_NT) {
        this.Ma_NT = Ma_NT;
    }



    public String getDiaDiemNT() {
        return diaDiemNT;
    }

    public void setDiaDiemNT(String diaDiemNT) {
        this.diaDiemNT = diaDiemNT;
    }
    
}
