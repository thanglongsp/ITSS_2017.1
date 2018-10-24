/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.LibrarianUI;
import entity.Book;
import java.sql.SQLException;
import java.util.List;
import java.lang.NullPointerException;

/**
 *
 * @author thanglongsp
 */
public class RegisterNewBookController {
    Book mBook;
    
    public RegisterNewBookController(){
        mBook = new Book();
    }

    /**
     * Lay toan bo sach tren db
     *
     * @return tra ve dach sach chua toan bo sach tren db
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public List<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        return mBook.getAllBooks();
    }

    /**
     * Kiem tra sach co ton tai khong
     *
     * @param bookNumber ma sach
     * @return "ok" neu sach ton tai, null neu sach khong ton tai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public String checkBook(String bookNumber) throws SQLException, ClassNotFoundException{
        return mBook.checkBook(bookNumber);
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

    public int registerNewBooks(String bookNumber,String title,String publisher,String authors,String isbn) throws SQLException, ClassNotFoundException{
        return mBook.registerNewBooks(bookNumber, title, publisher, authors, isbn);
    }
}
