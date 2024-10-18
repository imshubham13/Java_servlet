package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUtil {

    static Connection conn;

    public static Connection getConnection() {

        try {
            //Load JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookdb";
            //Database connection create
            conn = DriverManager.getConnection(url, "root", "");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void insertData(Connection conn, Book b) {
        String sql = "insert into book values (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.bookId);
            ps.setString(2, b.bookTitle);
            ps.setInt(3, b.bookPrice);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateData(int bookId, String bookTitle) {

        try {
            String sql = "update book set bookTitle=? where bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookTitle);
            ps.setInt(2, bookId);
            ps.executeUpdate();
            System.out.println("Updated Successfully =======>");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteData(int bookId) {

        try {
            String sql = "delete from book where bookId=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List readData(Connection conn) {
        System.out.println("ID" + "      " + "Title" + "    " + "Price");
        List<Book> record = null;
        try {
            record = new ArrayList();
            String sql = "select * from book";
            int count = 0;
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                int bookId = rs.getInt("bookId");
                String bookTitle = rs.getString("bookTitle");
                int bookPrice = rs.getInt("bookPrice");

                System.out.println(bookId + "    " + bookTitle + "       " + bookPrice);

                Book b = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3));
                record.add(b);
            }
            if (count == 0) {
                System.out.println("No data Found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return record;
    }

    public static void searchData(Connection conn, int bookId) {
        String sql = "select * from book where bookId=?";

        int count = 0;

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                int bookID = rs.getInt("bookId");
                String bookTitle = rs.getString("bookTitle");
                int bookPrice = rs.getInt("bookPrice");

                System.out.println(bookID + "    " + bookTitle + "       " + bookPrice);

            }
            if (count == 0) {
                System.out.println("No data Found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
