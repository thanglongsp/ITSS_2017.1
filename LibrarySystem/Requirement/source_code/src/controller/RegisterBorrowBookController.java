/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package controller;

import common.Constants;
import common.Session;
import entity.Card;
import entity.Book;
import entity.Copy;
import entity.User;
import entity.History;
import entity.Registration;

import java.sql.SQLException;

/**
 * @author longdragon
 */
public class RegisterBorrowBookController {

    /**
     * Kiem ta xem the da het han hay chua
     *
     * @return true neu the chua het han, nguoc lai tra ve false
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    private boolean isCardExpired() throws SQLException, ClassNotFoundException {
        Card card = new Card();
        return card.isCardExpired();
    }

    /**
     * Kiem tra xem co sach chua tra qua han hay khong
     *
     * @return true neu co sach chua tra qua han, false neu khong co
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    private boolean hasOverdueUnreturnedBook() throws SQLException, ClassNotFoundException {
        Card card = new Card();
        History history = new History();
        int cardId = card.getCurrentUserCard();
        if (cardId == -1) {
            System.out.println("Nguoi dung ko co card");
            return false;
        }
        return history.hasOverdueUnreturnedBook(cardId);
    }

    /**
     * Kiem tra xem sach con co available copy hay khong
     *
     * @param bookNumber ma sach
     * @return tra ve false neu khong con, true neu co
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */


    private boolean isBookAvailable(String bookNumber) throws SQLException, ClassNotFoundException {
        Book book = new Book();
        return book.isAvailable(bookNumber);
    }

    /**
     * Kiem tra co qua gioi han muon sach hay khong
     * @param limit gioi han
     * @return false neu khong qua gioi han, true neu qua gioi han
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    private boolean isOverLimit(int limit) throws SQLException, ClassNotFoundException {
        int nUnreturnedBook = 0;
        int nRegisteredBook = 0;
        History history = new History();
        Registration registration = new Registration();
        Card card = new Card();
        int cardId = card.getCurrentUserCard();
        nUnreturnedBook = history.countUnreturnedBooks(cardId);
        nRegisteredBook = registration.countRegistedBooks();
        System.out.println("sum = " + (nRegisteredBook + nUnreturnedBook));
        return !(nUnreturnedBook + nRegisteredBook < limit);
    }

    /**
     * Kiem tra xem sach da duoc dang ky muon hay chua
     *
     * @param bookNumber ma sach
     * @return true neu sach da duoc dang ky muon hoac dang duoc muon, false neu chua duoc muon hay dang ky
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    private boolean isRegistered(String bookNumber) throws SQLException, ClassNotFoundException {
        boolean param1 = false, param2 = false;
        Registration registration = new Registration();
        History history = new History();
        Card card = new Card();
        int cardId = card.getCurrentUserCard();
        param1 = registration.isRegistered(bookNumber);
//        return
        param2 = history.isBorrowing(cardId, bookNumber);
        return param1 || param2;
    }

    /**
     * Dang ky muon sach
     *
     * @param bookNumber ma sach
     * @return tra ve Constants.CARDEXPIRED neu the het han,
     * Constants.OVERDUEBOOK neu co sach qua han,
     * Constants.BOOKNOTAVAILABLE neu sach khong co san,
     * Constants.OVERLIMIT neu qua gioi han muon,
     * Constants.BOOKREGISTERED neu sach da duoc dang ky muon,
     * Constants.REGISTERSUCCESS neu dang ky muon thanh cong
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int register(String bookNumber) throws SQLException, ClassNotFoundException {
        if (isCardExpired()) {
            return Constants.CARDEXPIRED;
        }
        if (hasOverdueUnreturnedBook()) {
            return Constants.OVERDUEBOOK;
        }
        if (!isBookAvailable(bookNumber)) {
            return Constants.BOOKNOTAVAILABLE;
        }

        if (isOverLimit(5)) {
            return Constants.OVERLIMIT;
        }

        if (isRegistered(bookNumber)) {
            return Constants.BOOKREGISTERED;
        }

        return Constants.REGISTERSUCCESS; // success
    }

    /**
     * Luu thong tin dang ky muon sach
     *
     * @param bookNumber ma sach
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public void save(String bookNumber) throws SQLException, ClassNotFoundException {
        int userId = -1;
        int sequenceNumber = -1;
        Registration registration = new Registration();
        User user = new User();
        Copy copy = new Copy();
        userId = user.getId(Session.currentUser);
        sequenceNumber = copy.getAvailableCopy(bookNumber);
        System.out.println("userId = " + userId + "sequence Number = " + sequenceNumber);
        copy.changeStatus(bookNumber, sequenceNumber, Constants.REGISTERED);
        registration.save(userId, bookNumber, sequenceNumber);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Session.currentUser = "long";
        RegisterBorrowBookController controller = new RegisterBorrowBookController();
        if (controller.isCardExpired()) {
            System.out.println("expired");
        } else System.out.println("un-expired");

        if (controller.hasOverdueUnreturnedBook()) {
            System.out.println("Has overdue unreturned book");
        } else System.out.println("hasn't overdue unreturned book");

        if (controller.isBookAvailable("it9234")) {
            System.out.println("XX1234 is available");
        } else System.out.println("XX1234 is un-available");

        if (controller.isOverLimit(3)) {
            System.out.println("Overlimit 5");
        } else System.out.println("not-Overlimit 5");

        if (controller.isRegistered("it9234")) {
            System.out.println("Da dang ky, khong the dang ky them");
        } else System.out.println("Chua dang ky it9234. ban co the dang ky them");
//        controller.save("it9234");
    }


}
