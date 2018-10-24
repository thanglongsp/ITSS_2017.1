package controller;

import boundary.BookDetailsUI;
import common.Session;
import entity.Book;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class BookController {
    Book mBook;

    /**
     * Init sach
     */
    public BookController() {
        mBook = new Book();
    }

    /**
     * Hien thi thong tin sach
     *
     * @param bookNumber ma sach
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public void show(String bookNumber) throws SQLException, ClassNotFoundException{
        BookDetailsUI bookDetailsUi = new BookDetailsUI();
        Book book = new Book();
        book = mBook.findByBookNumber(bookNumber);
        if (book == null) {
            System.out.println("Error in show ok bookcontroller.");
        } else {
            bookDetailsUi.setContent(book.getTitle(), book.getAuthors(), book.getIsbn(), bookNumber, book.getPublisher());
            bookDetailsUi.setVisible(true);
        }
        
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BookController controller = new BookController();
        Session.currentUser = "demo";
        controller.show("it9234");
    }
}
