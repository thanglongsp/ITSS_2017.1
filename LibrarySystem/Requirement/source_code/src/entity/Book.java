package entity;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

import common.Constants;
import common.Entity;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Book extends Entity {

    private String bookNumber;
    private String title;
    private String publisher;
    private String authors;
    private int status;
    private String isbn;

    /**
     * Khoi tao doi tuong cua lop Book
     *
     * @param bookNumber ma so cua sach
     * @param title      tieu de sach
     * @param publisher  nha xuat ban sach
     * @param authors    cac tac gia cua sach
     * @param isbn       ma ISBN cua sach
     * @param status     trang thai cua sach
     */
    public Book(String bookNumber, String title, String publisher, String authors, int status, String isbn) {
        this.bookNumber = bookNumber;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.status = status;
        this.isbn = isbn;
    }

    public Book() {
    }

    /**
     * Tim sach
     *
     * @param keyword keyword de tim sach, cu the la tieu de
     * @return tra ve danh sach sach tim duoc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public List<Book> searchBooks(String keyword) throws SQLException, ClassNotFoundException {
        connectDB();
        List<Book> books = new ArrayList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM book WHERE title LIKE '%" + keyword + "%'");
        while (rs.next()) {
            Book temp = new Book();
            temp.setBookNumber(rs.getString("book_number"));
            temp.setTitle(rs.getString("title"));
            temp.setPublisher(rs.getString("publisher"));
            temp.setAuthors(rs.getString("authors"));
            temp.setStatus(rs.getInt("status"));
            temp.setIsbn(rs.getString("isbn"));
            books.add(temp);
        }
        closeConnect();
        return books;
    }

    /**
     * Kiem tra sach co ton tai khong
     *
     * @param bookNumber ma sach
     * @return "ok" neu sach ton tai, null neu sach khong ton tai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public String checkBook(String bookNumber) throws SQLException, ClassNotFoundException {
        connectDB();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM book WHERE book_number = \"" + bookNumber + "\"");
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Book existed !");
            return "ok";
        } else {
            closeConnect();
            return null;
        }
    }

    /**
     * Kiem tra sach co ton tai khong
     *
     * @param bookNumber ma sach
     * @return "ok" neu sach ton tai, null neu sach khong ton tai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public String checkBookNotExist(String bookNumber) throws SQLException, ClassNotFoundException {
        connectDB();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM book WHERE book_number = \"" + bookNumber + "\"");
        if (rs.next()) {
            return "ok";
        } else {
            JOptionPane.showMessageDialog(null, "Book not exist!");
            closeConnect();
            return null;
        }
    }

    /**
     * Dang ky sach moi
     *
     * @param bookNumber tuong tu nhu id cua sach moi dang ky vao
     * @param title      tieu de sach
     * @param publisher  nha xuat ban sach
     * @param authors    tac gia sach
     * @param isbn       seri sach do nha xuat ban tao
     * @return tra ve ket qua cua sql
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int registerNewBooks(String bookNumber, String title, String publisher, String authors, String isbn) throws SQLException, ClassNotFoundException {
        connectDB();
        Book book = new Book();
        Statement stm = conn.createStatement();
        int i = stm.executeUpdate("INSERT INTO book VALUES ('" + bookNumber + "','" + publisher + "','" + title + "','" + authors + "','1','" + isbn + "')");
        closeConnect();
        return i;
    }

//    /**
//     * Cap nhat trang thai cua sach da duoc muon
//     *
//     * @param bookNumber ma sach
//     * @param state      trang thai cua sach
//     * @return tra ve trang thai cua viec update sach
//     * @throws SQLException           neu co loi khi tuong tac voi db
//     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
//     */
//
//    public int updateBorrowedBookState(int bookNumber, int state) throws SQLException, ClassNotFoundException {
//        connectDB();
//        String query = "UPDATE book SET status = \"" + state + "\" WHERE book_number = " + bookNumber;
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery(query);
//        if (!rs.next()) {
//            return Constants.UPDATE_FAIL;
//        }
//        return Constants.UPDATE_SUCCESS;
//    }

    /**
     * Lay toan bo sach tren db
     *
     * @return tra ve dach sach chua toan bo sach tren db
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public List<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        connectDB();
        List<Book> books = new ArrayList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM book");
        while (rs.next()) {
            Book temp = new Book();
            temp.setBookNumber(rs.getString("book_number"));
            temp.setTitle(rs.getString("title"));
            temp.setPublisher(rs.getString("publisher"));
            temp.setAuthors(rs.getString("authors"));
            temp.setStatus(rs.getInt("status"));
            temp.setIsbn(rs.getString("isbn"));
            books.add(temp);
        }
        closeConnect();
        return books;
    }

    /**
     * Cap nhat thong tin sach
     *
     * @param bookNumber tuong tu nhu id cua sach
     * @param title      tieu de sach
     * @param publisher  nha xuat ban sach
     * @param authors    tac gia sach
     * @param status     trang thai cua sach
     * @param isbn       seri sach do nha xuat ban tao
     * @return tra ve 1
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int updateBookInfor(String bookNumber, String title, String authors, String publisher, int status, String isbn) throws SQLException, ClassNotFoundException {
        connectDB();
        if (!title.equals("")) {
            String query = "UPDATE book SET title = \"" + title + "\" WHERE book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        if (!authors.equals("")) {
            String query = "UPDATE book SET authors = \"" + authors + "\" WHERE book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        if (!publisher.equals("")) {
            String query = "UPDATE book SET publisher = \"" + publisher + "\" WHERE book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        if (!isbn.equals("")) {
            String query = "UPDATE book SET isbn = \"" + isbn + "\" WHERE book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        if (status > 0) {
            String query = "UPDATE book SET status = \"" + status + "\" WHERE book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
        }
        return 1;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Tim sach theo ma sach
     *
     * @param bookNumber ma sach
     * @return tra ve sach tim duoc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public Book findByBookNumber(String bookNumber) throws SQLException, ClassNotFoundException {
        Book book = null;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select * from book where book_number = ?");
        ps.setString(1, bookNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            book = new Book(bookNumber,
                    rs.getString("title"),
                    rs.getString("publisher"),
                    rs.getString("authors"),
                    rs.getInt("status"),
                    rs.getString("isbn")
            );
        }
        closeConnect();
        return book;
    }

    /**
     * Kiem tra xem sach con co available copy hay khong
     *
     * @param bookNumber ma sach
     * @return tra ve false neu khong con, true neu co
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public boolean isAvailable(String bookNumber) throws SQLException, ClassNotFoundException {
        boolean returnValue = false;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as sl FROM copy WHERE book_number = ? AND status = ?");
        ps.setString(1, bookNumber);
        ps.setInt(2, Constants.UNBORROWED);
        ResultSet rs = ps.executeQuery();
        rs.next();
        returnValue = rs.getInt("sl") != 0;
        closeConnect();
        return returnValue;
    }
}
