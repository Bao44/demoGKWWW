package vn.edu.iuh.fit.demogk.dao;

import vn.edu.iuh.fit.demogk.connection.ConnectDB;
import vn.edu.iuh.fit.demogk.entities.LoaiThuoc;
import vn.edu.iuh.fit.demogk.entities.Thuoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyThuocDAO {
    public List<Thuoc> getAll() throws SQLException, ClassNotFoundException {
        List<Thuoc> list = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM thuoc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maThuoc = resultSet.getString("MATHUOC");
            String tenThuoc = resultSet.getString("TENTHUOC");
            int namsx = resultSet.getInt("NAMSX");
            Double gia = resultSet.getDouble("GIA");
            String maLoai = resultSet.getString("MALOAI");
            Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, namsx, gia, new LoaiThuoc(maLoai));
            list.add(thuoc);
        }
        return list;
    }

    public boolean addThuoc(Thuoc thuoc) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "INSERT INTO thuoc(maThuoc, tenThuoc, namsx, gia, maLoai) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, thuoc.getMaThuoc());
        preparedStatement.setString(2, thuoc.getTenThuoc());
        preparedStatement.setInt(3, thuoc.getNamsx());
        preparedStatement.setDouble(4, thuoc.getDonGia());
        preparedStatement.setString(5, thuoc.getLoaiThuoc().getMaLoai());
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Thuoc> getAllByLoai(String maLoai) throws SQLException, ClassNotFoundException {
        List<Thuoc> list = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM thuoc WHERE maLoai = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, maLoai);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String maThuoc = resultSet.getString("MATHUOC");
            String tenThuoc = resultSet.getString("TENTHUOC");
            int namsx = resultSet.getInt("NAMSX");
            Double gia = resultSet.getDouble("GIA");
            LoaiThuoc loaiThuoc = new LoaiThuoc(resultSet.getString("MALOAI"));
            Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, namsx, gia, loaiThuoc);
            list.add(thuoc);
        }
        return list;
    }
}
