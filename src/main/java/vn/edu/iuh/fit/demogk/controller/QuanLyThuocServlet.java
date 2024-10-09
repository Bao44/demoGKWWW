package vn.edu.iuh.fit.demogk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.demogk.dao.QuanLyLoaiThuocDAO;
import vn.edu.iuh.fit.demogk.dao.QuanLyThuocDAO;
import vn.edu.iuh.fit.demogk.entities.LoaiThuoc;
import vn.edu.iuh.fit.demogk.entities.Thuoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/action")
public class QuanLyThuocServlet extends HttpServlet {
    private QuanLyLoaiThuocDAO quanLyLoaiThuocDAO = new QuanLyLoaiThuocDAO();
    private QuanLyThuocDAO quanLyThuocDAO = new QuanLyThuocDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "addThuoc":
                boolean result = false;
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(req.getParameter("MATHUOC"));
                thuoc.setTenThuoc(req.getParameter("TENTHUOC"));
                thuoc.setNamsx(Integer.parseInt(req.getParameter("NAMSX")));
                thuoc.setDonGia(Double.parseDouble(req.getParameter("GIA")));
                thuoc.setLoaiThuoc(new LoaiThuoc(req.getParameter("MALOAI")));
                try {
                    result = quanLyThuocDAO.addThuoc(thuoc);
                    System.out.println(result);
                    if (result) {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Them thuoc thanh cong!'); location='index.jsp' </script>");
                    } else {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Them thuoc khong thanh cong!'); location='addThuoc.jsp' </script>");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "danhSachThuoc":
                try {
                    List<Thuoc> danhSachThuoc = quanLyThuocDAO.getAll();
                    session.setAttribute("danhSachThuoc", danhSachThuoc);
                    req.getRequestDispatcher("/danhSachThuoc.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error retrieving drug list", e);
                }
                break;
            case "danhSachLoaiThuoc":
                try {
                    List<LoaiThuoc> danhSachLoaiThuoc = quanLyLoaiThuocDAO.getAll();
                    session.setAttribute("danhSachLoaiThuoc", danhSachLoaiThuoc);
                    req.getRequestDispatcher("/danhSachLoaiThuoc.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error retrieving drug type list", e);
                }
                break;
            case "danhSachThuocTheoLoai":
                String maLoai = req.getParameter("MALOAI");
                try {
                    List<Thuoc> danhSachThuocTheoLoai = quanLyThuocDAO.getAllByLoai(maLoai);
                    session.setAttribute("danhSachThuocTheoLoai", danhSachThuocTheoLoai);
                    req.getRequestDispatcher("/danhSachThuocTheoLoai.jsp").forward(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException("Error retrieving drug list by type", e);
                }
                break;
        }
    }
}
