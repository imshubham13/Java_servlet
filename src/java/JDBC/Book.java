package JDBC;

public class Book {

    int bookId;
    String bookTitle;
    int bookPrice;

    public Book(int bookID, String bookTitle, int bookPrice) {
        this.bookId = bookID;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

}
