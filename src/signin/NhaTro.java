/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signin;

/**
 *
 * @author Daokh
 */
public class NhaTro extends ChuNhaTro{
    private String Ma_NT;
    private long GiaPhong;
    private int DienTich;
    private String DiaChi;
    private String Mota;
    private String Hinh;
    private String Minh;
    public NhaTro() {
    }

    public NhaTro(String Ma_NT, long GiaPhong, int DienTich, String DiaChi, String Mota, String Hinh, String maChu) {
        super(maChu);
        this.Ma_NT = Ma_NT;
        this.GiaPhong = GiaPhong;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
        this.Mota = Mota;
        this.Hinh = Hinh;
    }

    public NhaTro(String Ma_NT, long GiaPhong, int DienTich, String DiaChi, String Mota, String Hinh, String maChu, String tenChu, String DT) {
        super(maChu, tenChu, DT);
        this.Ma_NT = Ma_NT;
        this.GiaPhong = GiaPhong;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
        this.Mota = Mota;
        this.Hinh = Hinh;
    }
    
    

    public String getMa_NT() {
        return Ma_NT;
    }

    public void setMa_NT(String Ma_NT) {
        this.Ma_NT = Ma_NT;
    }

    public long getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(long GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public int getDienTich() {
        return DienTich;
    }

    public void setDienTich(int DienTich) {
        this.DienTich = DienTich;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
    
    
}
