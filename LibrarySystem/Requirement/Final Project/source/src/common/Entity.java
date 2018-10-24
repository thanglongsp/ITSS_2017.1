/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author longdragon
 */
public class Entity {
    
    protected Connection conn;

    /**
     * Ket noi db
     *
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public void connectDB() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system_db", "root", "");
            Statement st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in connectDB()");
        }
        
    }

    /**
     * Ngat ket noi
     *
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public void closeConnect() throws SQLException, ClassNotFoundException{
        if (conn != null) {
            System.out.println("Close connection.");
            conn.close();
            conn = null;
        }
    }
    
}
