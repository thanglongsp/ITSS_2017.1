package entity;

import common.Entity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.Constants;

import java.sql.ResultSet;

public class History extends Entity {
    private int historyId;
    private int cardId;
    private Date borrowedDate;

    /**
     * Kiem tra xem co sach chua tra qua han hay khong
     *
     * @param cardId ma the
     * @return true neu co sach chua tra qua han, false neu khong co
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public boolean hasOverdueUnreturnedBook(int cardId) throws SQLException, ClassNotFoundException {
        boolean returnValue = false;
        String queryString = "SELECT COUNT(*) as sl\n" +
                "FROM `borrowed-history` JOIN `borrowed-history_copy` \n" +
                "WHERE card_id = ? AND `borrowed-history_copy`.`status` = ? and CURRENT_DATE > (`borrowed-date` + 14)";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setInt(1, cardId);
        ps.setInt(2, Constants.UNRETURNED);
        ResultSet rs = ps.executeQuery();
        rs.next();
        returnValue = rs.getInt("sl") != 0;
        closeConnect();
        return returnValue;
    }

    /**
     * Dem so sach chua duoc tra
     *
     * @param cardId ma the
     * @return tra ve so sach chua duoc tra
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int countUnreturnedBooks(int cardId) throws SQLException, ClassNotFoundException {
        int returnValue = 0;
        String queryString = "SELECT COUNT(*) as sl \n" +
                "FROM `borrowed-history` JOIN `borrowed-history_copy` \n" +
                "WHERE card_id = ? AND `borrowed-history_copy`.`status` = ?";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setInt(1, cardId);
        ps.setInt(2, Constants.UNRETURNED);
        ResultSet rs = ps.executeQuery();
        rs.next();
        returnValue = rs.getInt("sl");

        return returnValue;
    }

    /**
     * Kiem tra xem sach co dang duoc muon hay khong
     * @param cardId ma the
     * @param bookNumber ma sach
     * @return true neu sach dang duoc muon, false neu khong
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public boolean isBorrowing(int cardId, String bookNumber) throws SQLException, ClassNotFoundException {
        boolean returnValue = false;
        String queryString = "SELECT COUNT(*) as sl \n" +
                "FROM `borrowed-history` JOIN `borrowed-history_copy` \n" +
                "WHERE card_id = ? AND `borrowed-history_copy`.`status` = 0 AND book_number = ?";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setInt(1, cardId);
        ps.setString(2, bookNumber);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if (rs.getInt("sl") > 0) {
            returnValue = true;
        }
        closeConnect();
        return returnValue;
    }
}
