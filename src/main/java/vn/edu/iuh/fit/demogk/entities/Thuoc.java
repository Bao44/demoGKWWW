package vn.edu.iuh.fit.demogk.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "thuoc")
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maThuoc;
    private String tenThuoc;
    private int namsx;
    private double donGia;
    @ManyToOne
    private LoaiThuoc loaiThuoc;

    public Thuoc(String maThuoc, String tenThuoc, int namsx, double donGia, LoaiThuoc loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.namsx = namsx;
        this.donGia = donGia;
        this.loaiThuoc = loaiThuoc;
    }

    public Thuoc() {
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setDonViTinh(int namsx) {
        this.namsx = namsx;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", namsx='" + namsx + '\'' +
                ", donGia=" + donGia +
                ", loaiThuoc=" + loaiThuoc.getMaLoai() +
                '}';
    }
}
