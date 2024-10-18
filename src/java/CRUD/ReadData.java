package CRUD;

import JDBC.Book;
import JDBC.JDBCUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadData extends HttpServlet {

    Connection conn;

    @Override
    public void init() throws ServletException {
        conn = JDBC.JDBCUtil.getConnection();
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        Code ========>
        List<Book> recordList = JDBCUtil.readData(conn);

        for (Book b : recordList) {
            out.println("<table border=1>");
            out.write("<tr>");
            out.write("<td>" + b.getBookId() + "</td>");
            out.write("<td>" + b.getBookTitle() + "</td>");
            out.write("<td>" + b.getBookPrice() + "</td>");
            out.write("</tr>");
            out.println("</table>");

        }

        JDBC.JDBCUtil.readData(conn);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
