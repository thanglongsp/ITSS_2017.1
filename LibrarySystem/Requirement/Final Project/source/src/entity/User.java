package entity;

import common.Constants;
import common.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import jdk.nashorn.internal.parser.TokenType;

public class User extends Entity{
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String phoneNumber;
    private String gender;
    private int role;

    /**
     * Xac thuc dang nhap
     *
     * @param username ten dang nhap
     * @param password mat khau
     * @return trang thai xac thuc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int auth(String username, char[] password) throws SQLException, ClassNotFoundException{
        int state = Constants.WRONG_EMAIL;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select * from user where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            state = Constants.WRONG_EMAIL;
            System.out.println("wrong email.");
        } else {
            String realPass = rs.getString("password");
            int cmpRes = realPass.compareTo(String.valueOf(password));
            if (cmpRes == 0 && rs.getInt("status") == 1) {
                state = Constants.LOGIN_SUCCESS;
                System.out.println("login success");
            } else if (cmpRes == 0 && rs.getInt("status") != 1) {
                state = Constants.ACC_NOT_ACTIVATED;
                System.out.println("accout is not activated");
            } else {
                state = Constants.WRONG_PASS;
                System.out.println("wrong password");
            }
        }
        closeConnect();
        return state;
    }

    /**
     * Lay thong tin tai khoan (ten dang nhap va mat khau)
     *
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    
    public void getAll() throws SQLException, ClassNotFoundException{
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select * from user where username = ?");
        ps.setString(1, "long");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(username + " " + password);
        }
        closeConnect();
    }

    /**
     * Lay vai tro cua nguoi dung
     *
     * @param username ten dang nhap
     * @return vai tro cua nguoi dung
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int getRole(String username) throws SQLException, ClassNotFoundException {
        int returnValue = -1;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("select role from user where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            returnValue = rs.getInt("role");
        }
        closeConnect();
        return returnValue;
    }

    /**
     * Lay id cua nguoi dung
     *
     * @param uname ten dang nhap
     * @return id cua nguoi dung
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int getId(String uname) throws SQLException, ClassNotFoundException{
        int returnValue = -1;
        connectDB();
        PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM user WHERE username = ?");
        ps.setString(1, uname);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            returnValue = rs.getInt("user_id");
        }
        closeConnect();
        return returnValue;
    }
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        User user = new User();
//        user.getAll();
//    }
}
