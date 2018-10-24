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
public class UpdateBookInforController {

    Book mBook;

    public UpdateBookInforController() {
        mBook = new Book();
    }

    /**
     * Kiem tra sach co ton tai khong
     *
     * @param bookNumber ma sach
     * @return "ok" neu sach ton tai, null neu sach khong ton tai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public String checkBookNotExist(String bookNumber) throws SQLException, ClassNotFoundException{
        return mBook.checkBookNotExist(bookNumber);   
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

    public int UpdateBookInfor(String bookNumber, String title, String authors, String publisher, int status, String isbn) throws SQLException, ClassNotFoundException {
        return mBook.updateBookInfor(bookNumber, title, authors, publisher, status, isbn);
    }
}
