package CRUD;

import JDBC.Book;
import JDBC.JDBCUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertData extends HttpServlet {

     Connection conn;

    @Override
    public void init() throws ServletException {
        conn = JDBCUtil.getConnection();
        System.out.println("INIT MEthod Called ===========>");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // code==========>
        int bookID = Integer.parseInt(request.getParameter("bookId"));
        String bookTitle = request.getParameter("bookTitle");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        out.write("<h1>" + bookID + "</h1>");
        out.write("<h1>" + bookTitle + "</h1>");
        out.write("<h1>" + bookPrice + "</h1>");

        Book b = new Book(bookID, bookTitle, bookPrice);
        JDBCUtil.insertData(conn, b);
        System.out.println("Data Inserted Successfully============>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        // code==========>
        PrintWriter out = response.getWriter();
        int bookID = Integer.parseInt(request.getParameter("bookId"));
        String bookTitle = request.getParameter("bookTitle");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        out.write("<h1>" + bookID + "</h1>");
        out.write("<h1>" + bookTitle + "</h1>");
        out.write("<h1>" + bookPrice + "</h1>");

        Book b = new Book(bookID, bookTitle, bookPrice);
        JDBCUtil.insertData(conn, b);
        System.out.println("Data Inserted Successfully============>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
