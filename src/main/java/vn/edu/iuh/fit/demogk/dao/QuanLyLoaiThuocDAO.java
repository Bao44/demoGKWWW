package vn.edu.iuh.fit.demogk.dao;

import vn.edu.iuh.fit.demogk.connection.ConnectDB;
import vn.edu.iuh.fit.demogk.entities.LoaiThuoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyLoaiThuocDAO {

    public List<LoaiThuoc> getAll() throws SQLException, ClassNotFoundException {
        List<LoaiThuoc> list = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM loaithuoc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            String maLoai = resultSet.getString("MALOAI");
            String tenLoai = resultSet.getString("TENLOAI");
            LoaiThuoc loaiThuoc = new LoaiThuoc(maLoai, tenLoai);
            list.add(loaiThuoc);
        }
        return list;
    }
}
