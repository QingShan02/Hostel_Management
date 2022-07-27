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
    private int Ma_NT;
    private String TenPhong;
    private long GiaPhong;
    private int DienTich;
    private String DiaChi;
    private String Mota;
    private String Hinh;
    private int SoLuong;
    private String NgayHH;
    public NhaTro() {
    }

    public NhaTro(int Ma_NT, String TenPhong, long GiaPhong, int DienTich, String DiaChi, String Mota, String Hinh, int SoLuong, String NgayHH, String maChu) {
        super(maChu);
        this.Ma_NT = Ma_NT;
        this.TenPhong = TenPhong;
        this.GiaPhong = GiaPhong;
        this.DienTich = DienTich;
        this.DiaChi = DiaChi;
        this.Mota = Mota;
        this.Hinh = Hinh;
        this.SoLuong = SoLuong;
        this.NgayHH = NgayHH;
    }

    public NhaTro(int Ma_NT) {
        this.Ma_NT = Ma_NT;
    }

    public int getMa_NT() {
        return Ma_NT;
    }

    public void setMa_NT(int Ma_NT) {
        this.Ma_NT = Ma_NT;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getNgayHH() {
        return NgayHH;
    }

    public void setNgayHH(String NgayHH) {
        this.NgayHH = NgayHH;
    }

    
    
    
}
