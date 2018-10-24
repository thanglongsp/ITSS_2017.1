/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package entity;

import common.Entity;
import common.Constants;
import common.Session;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author longdragon
 */
public class Registration extends Entity {

    private int id;
    private int userId;
    private Date registeredDate;
    private int status;
    private String bookNumber;
    private int sequenceNumber;

    public Registration(int id, int userId, Date registeredDate, int status, String bookNumber, int sequenceNumber) {
        this.id = id;
        this.userId = userId;
        this.registeredDate = registeredDate;
        this.status = status;
        this.bookNumber = bookNumber;
        this.sequenceNumber = sequenceNumber;
    }
    
    public List<Registration> showBookBorrowing(int card_id,int user_id) throws SQLException, ClassNotFoundException {
        connectDB();
        List<Registration> books = new ArrayList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT book_number,sequence_number FROM registration , borrower WHERE borrower.card_id = \"" + card_id + "\" and borrower.user_id = \""+user_id+"\" and borrower.user_id = registration.user_id");
        while (rs.next()) {
            Registration temp = new Registration();
            temp.setBookNumber(rs.getString("book_number"));
            temp.setSequenceNumber(rs.getInt("sequence_number"));    
        }
        closeConnect();
        return books;
    }


    public Registration() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * Dem so sach da duoc dang ky muon
     *
     * @return so luong sach da duoc dang ky
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int countRegistedBooks() throws SQLException, ClassNotFoundException {
        int returnValue = 0;
        String queryString = "SELECT COUNT(*) as sl \n" +
                "FROM user JOIN registration \n" +
                "ON user.user_id = registration.user_id \n" +
                "WHERE user.username = ? AND registration.status = ?";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setString(1, Session.currentUser);
        ps.setInt(2, Constants.CHUALAY);
        ResultSet rs = ps.executeQuery();
        rs.next();
        returnValue = rs.getInt("sl");

        return returnValue;
    }

    /**
     * Luu thong tin dang ky muon sach
     *
     * @param userId         id cua nguoi dung
     * @param bookNumber     ma sach
     * @param sequenceNumber so thu tu sach
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public void save(int userId, String bookNumber, int sequenceNumber) throws SQLException, ClassNotFoundException {
        String queryString = "INSERT\n" +
                "INTO registration(user_id, registered_date, book_number, sequence_number)\n" +
                "VALUES(?, CURRENT_DATE, ?, ?)";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setInt(1, userId);
        ps.setString(2, bookNumber);
        ps.setInt(3, sequenceNumber);
        ps.executeUpdate();
        closeConnect();
    }

    /**
     * Kiem tra xem sach da duoc dang ky muon hay chua
     *
     * @param bookNumber ma sach
     * @return true neu sach da duoc danng ky muon, false neu chua
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public boolean isRegistered(String bookNumber) throws SQLException, ClassNotFoundException {
        boolean returnValue = false;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as sl FROM registration WHERE book_number = ? AND status = ?");
        ps.setString(1, bookNumber);
        ps.setInt(2, Constants.CHUALAY);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if (rs.getInt("sl") > 0) {
            returnValue = true;
        }
        closeConnect();
        return returnValue;
    }

    /**
     * Xem toan bo dang ky muon sach
     *
     * @return toan bo danh sach dang ky
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public List<Registration> getAll() throws SQLException, ClassNotFoundException {
        List<Registration> list = null;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select * from registration");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Registration(
                    rs.getInt("registration_id"),
                    rs.getInt("user_id"),
                    rs.getDate("registered_date"),
                    rs.getInt("status"),
                    rs.getString("book_number"),
                    rs.getInt("sequence_number")
            ));
        }
        closeConnect();
        return list;
    }

}
