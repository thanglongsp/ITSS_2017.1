package entity;

import common.Constants;
import common.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Copy extends Entity {

    private int sequenceNumber;
    private String bookNumber;
    private String typeOfCopy;
    private float price;
    private int status;

    public Copy(int sequenceNumber, String bookNumber, String typeOfCopy, float price, int status) {
        this.sequenceNumber = sequenceNumber;
        this.bookNumber = bookNumber;
        this.typeOfCopy = typeOfCopy;
        this.price = price;
        this.status = status;
    }

    public Copy() {
    }

    /**
     * Lay danh sach copy da duoc muon
     *
     * @return tra ve list sach da duoc muon
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public List<Copy> getBorrowedCopies() throws SQLException, ClassNotFoundException {
        connectDB();
        List<Copy> copies = new ArrayList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM copy WHERE status = 2");
        while (rs.next()) {
            Copy temp = new Copy();
            temp.setSequenceNumber(rs.getInt("sequence_number"));
            temp.setBookNumber(rs.getString("book_number"));
            temp.setTypeOfCopy(rs.getString("type_of_copy"));
            temp.setPrice(rs.getFloat("price"));
            temp.setStatus(rs.getInt("status"));
            copies.add(temp);
        }
        closeConnect();
        return copies;
    }

    /**
     * Cap nhat trang thai cua ban copy
     *
     * @param sequenceNumber so thu tu cua sach
     * @param bookNumber     ma sach
     * @param state          trang thai cua sach
     * @return tra ve 1 neu cap nhat thanh cong, nguoc lai tra ve 0
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public int updateBorrowedCopyState(int sequenceNumber, String bookNumber, int state) throws SQLException, ClassNotFoundException {
        connectDB();
        String query = "UPDATE copy SET status = \"" + state + "\" WHERE sequence_number = \"" + sequenceNumber + "\""
                + "AND book_number = \"" + bookNumber + "\"";
        System.out.println(query);
        Statement stm = conn.createStatement();
        return stm.executeUpdate(query);
    }

    /**
     * Lay danh sach toan bo cac ban copy
     *
     * @return danh sach copy
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public List<Copy> getAllCopies() throws SQLException, ClassNotFoundException {
        connectDB();
        List<Copy> copies = new ArrayList<>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM copy");
        while (rs.next()) {
            Copy temp = new Copy();
            temp.setSequenceNumber(rs.getInt("sequence_number"));
            temp.setBookNumber(rs.getString("book_number"));
            temp.setTypeOfCopy(rs.getString("type_of_copy"));
            temp.setPrice(rs.getFloat("price"));
            temp.setStatus(rs.getInt("status"));
            copies.add(temp);
        }
        closeConnect();
        return copies;
    }

    /**
     * Dang ky copy moi
     *
     * @param bookNumber ma sach cua copy can dang ky
     * @param typeOfCopy loai cua copy
     * @param price      gia sach
     * @return tra ve so copy duoc them vao
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int registerNewCopy(String bookNumber, int typeOfCopy, float price) throws SQLException, ClassNotFoundException {
        connectDB();
        Copy copy = new Copy();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT sequence_number FROM copy where book_number = \"" + bookNumber + "\" order by sequence_number DESC limit 1");
        int result;
        if (rs.next()) {
            int sequenceNumber = Integer.parseInt(rs.getString("sequence_number")) + 1;
            result = stm.executeUpdate("INSERT INTO copy VALUES ('" + sequenceNumber + "','" + bookNumber + "','" + typeOfCopy + "','" + price + "','1')");
        } else {
            result = stm.executeUpdate("INSERT INTO copy VALUES ('1','" + bookNumber + "','" + typeOfCopy + "','" + price + "','1')");
        }
        closeConnect();
        return result;
    }

    /**
     * Kiem tra xem copy co ton tai hay khong
     *
     * @param sequence   so thu tu cua sach
     * @param bookNumber ma sach
     * @return "ok" neu copy ton tai, null neu copy khong ton tai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public String checkCopyNotExist(String sequence, String bookNumber) throws SQLException, ClassNotFoundException {
        connectDB();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM copy WHERE sequence_number = \"" + sequence + "\" and book_number = \"" + bookNumber + "\"");
        if (rs.next()) {
            return "ok";
        } else {
            JOptionPane.showMessageDialog(null, "Copy not exist!");
            closeConnect();
            return null;
        }
    }
    
    /**
     * Cap nhat thong tin copy
     *
     * @param sequenceNumber so thu tu copy
     * @param bookNumber     ma sach
     * @param typeOfCopy     loai copy
     * @param price          gia copy
     * @param status         trang thai cua ban copy
     * @return tra ve so thuoc tinh duoc cap nhat
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int updateCopyInfor(int sequenceNumber, String bookNumber, int typeOfCopy, float price, int status) throws SQLException, ClassNotFoundException {
        connectDB();
        int result = 0;
        if (typeOfCopy >= 0) {
            String query = "UPDATE copy SET type_of_copy = \"" + typeOfCopy + "\" WHERE sequence_number = \"" + sequenceNumber + "\" and book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            result++;
        }
        if (price > 0) {
            String query = "UPDATE copy SET price = \"" + price + "\" WHERE sequence_number = \"" + sequenceNumber + "\" and book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            result++;
        }
        if (status > 0) {
            String query = "UPDATE copy SET status = \"" + status + "\" WHERE sequence_number = \"" + sequenceNumber + "\" and book_number = \"" + bookNumber + "\"";
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            result++;
        }
        closeConnect();
        return result;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTypeOfCopy() {
        return typeOfCopy;
    }

    public void setTypeOfCopy(String typeOfCopy) {
        this.typeOfCopy = typeOfCopy;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Lay ra mot ban copy chua duoc muon cua sach
     *
     * @param bookNumber ma sach
     * @return tra ve so thu tu cua ban copy
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int getAvailableCopy(String bookNumber) throws SQLException, ClassNotFoundException {
        int returnValue = -1;
        String queryString = "SELECT sequence_number FROM copy WHERE book_number = ? AND status = 1 LIMIT 1";
        connectDB();
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setString(1, bookNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            returnValue = rs.getInt("sequence_number");
        }
        closeConnect();
        return returnValue;
    }

    /**
     * Thay doi trang thai copy
     *
     * @param bookNumber     ma sach
     * @param sequenceNumber so thu tu copy
     * @param status         trang thai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public void changeStatus(String bookNumber, int sequenceNumber, int status) throws SQLException, ClassNotFoundException {
        connectDB();
        String querysString = "UPDATE copy SET status = ? WHERE book_number = ? AND sequence_number = ?";
        PreparedStatement ps = conn.prepareStatement(querysString);
        ps.setInt(1, status);
        ps.setString(2, bookNumber);
        ps.setInt(3, sequenceNumber);
        ps.executeUpdate();
        closeConnect();
    }

}
