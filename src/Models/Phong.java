/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Daokh
 */
public class Phong {
    private int Ma_PHG;
    private String ten_PHG;
    private long GiaPhong;
    private int Dientich;
    private String mota;
    private String hinh;
    private int soluong;
    private String id;
    private int Ma_NT;
    private String name_Tang;

    public Phong(int Ma_PHG, String ten_PHG, long GiaPhong, int Dientich, String mota, String hinh, int soluong, String id, int Ma_NT, String name_Tang) {
        this.Ma_PHG = Ma_PHG;
        this.ten_PHG = ten_PHG;
        this.GiaPhong = GiaPhong;
        this.Dientich = Dientich;
        this.mota = mota;
        this.hinh = hinh;
        this.soluong = soluong;
        this.id = id;
        this.Ma_NT = Ma_NT;
        this.name_Tang = name_Tang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMa_NT() {
        return Ma_NT;
    }

    public void setMa_NT(int Ma_NT) {
        this.Ma_NT = Ma_NT;
    }

    public String getName_Tang() {
        return name_Tang;
    }

    public void setName_Tang(String name_Tang) {
        this.name_Tang = name_Tang;
    }





    public Phong() {
    }

    public int getMa_PHG() {
        return Ma_PHG;
    }

    public void setMa_PHG(int Ma_PHG) {
        this.Ma_PHG = Ma_PHG;
    }

    public String getTen_PHG() {
        return ten_PHG;
    }

    public void setTen_PHG(String ten_PHG) {
        this.ten_PHG = ten_PHG;
    }

    public long getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(long GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public int getDientich() {
        return Dientich;
    }

    public void setDientich(int Dientich) {
        this.Dientich = Dientich;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
