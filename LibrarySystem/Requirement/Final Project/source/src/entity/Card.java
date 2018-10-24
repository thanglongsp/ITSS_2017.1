package entity;

import common.Entity;
import common.Session;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Card extends Entity {

    private int cardId;
    private String name;
    private Date expiredDate;
    private String activationCode;
    private int status;
    private String birthday;

    public Card(int cardId, String name, Date expiredDate, String activationCode, int status, String birthday) {
        this.cardId = cardId;
        this.name = name;
        this.expiredDate = expiredDate;
        this.activationCode = activationCode;
        this.status = status;
        this.birthday = birthday;
    }

    public Card() {
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Tim the
     *
     * @param cardId ma the
     * @return tra ve the tim duoc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public Card findById(String cardId) throws SQLException, ClassNotFoundException {
        Card card = null;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select * from card where binary card_id = ?");
        ps.setString(1, cardId);
//        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
//        System.out.println(rs.toString());
        if (rs.next()) {
            System.out.println(rs.getInt("card_id") + rs.getString("name") + rs.getDate("expiration_date") + rs.getString("activation_code"));

            card = new Card(
                    rs.getInt("card_id"),
                    rs.getString("name"),
                    rs.getDate("expiration_date"),
                    rs.getString("activation_code"),
                    rs.getInt("status"),
                    rs.getString("birthday")
            );
        }
        closeConnect();
        return card;
    }

    public int getStatus() {
        return this.status;
    }

    /**
     * Thay doi trang thai the (kich hoat va ngung kich hoat)
     *
     * @param cardId    ma the
     * @param newStatus trang thai moi cua the
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public void changeStatus(int cardId, int newStatus) throws SQLException, ClassNotFoundException {
        connectDB();
        PreparedStatement ps = conn.prepareStatement("update card set status = ? where card_id = ?");
        ps.setInt(1, newStatus);
        ps.setInt(2, cardId);
        System.out.println(ps);
        int count = ps.executeUpdate();
        System.out.println("count : " + count);
        closeConnect();
    }

    /**
     * Cap nhat thong tin the
     *
     * @param cardId      ma the
     * @param name        ten chu the
     * @param expiredDate ngay het han
     * @param birthday    ngay sinh
     * @return tra ve 1 neu cap nhat thanh cong, 0 neu khong
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public int update(int cardId, String name, String expiredDate, String birthday) throws SQLException, ClassNotFoundException {
        connectDB();
        PreparedStatement ps = conn.prepareStatement("update card set name = ?, expiration_date = ?, birthday = ? where card_id = ?");
        ps.setString(1, name);
        ps.setString(2, expiredDate);
        ps.setString(3, birthday);
        ps.setInt(4, cardId);
        System.out.println(ps);
        int count = ps.executeUpdate();
        System.out.println("count update: " + count);
        closeConnect();
        return count;
    }

    /**
     * Lay card cua user hien tai
     *
     * @return tra ve id card cua user hien tai, -1 neu khong co
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int getCurrentUserCard() throws SQLException, ClassNotFoundException {
        int returnValue = 0;
        String queryString = "select borrower.card_id FROM borrower INNER JOIN user ON borrower.user_id = user.user_id WHERE user.username = ?";

        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setString(1, Session.currentUser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            returnValue = rs.getInt("card_id");
        } else {
            returnValue = -1;
        }
        closeConnect();
        return returnValue;
    }

    /**
     * Kiem ta xem the da het han hay chua
     *
     * @return true neu the chua het han, nguoc lai tra ve false
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public boolean isCardExpired() throws SQLException, ClassNotFoundException {
        String querysString = "SELECT COUNT(*) as sl\n"
                + "FROM ( \n"
                + "    (borrower INNER JOIN user ON borrower.user_id = user.user_id) \n"
                + "    INNER JOIN card ON borrower.card_id = card.card_id \n"
                + "    ) \n"
                + "WHERE user.username = ? and CURRENT_DATE <= card.expiration_date";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(querysString);
        ps.setString(1, Session.currentUser);
        ResultSet rs = ps.executeQuery();
        rs.next();
        boolean returnValue = rs.getInt("sl") == 0;
        closeConnect();
        return returnValue;
    }

}
