package controller;

import entity.Book;

import java.sql.SQLException;
import java.util.List;

public class SearchBookController {
    Book mBook;

    public SearchBookController() {
        mBook = new Book();
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
        return mBook.searchBooks(keyword);
    }
}
