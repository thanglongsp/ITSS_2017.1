package controller;

import boundary.LibrarianUI;
import boundary.UserUI;
import common.Constants;
import common.Session;
import entity.User;
import java.sql.SQLException;

public class LoginController {
    User user;
    
    public LoginController(){
        user = new User();
    }

    /**
     * Kiem tra dang nhap
     *
     * @param username ten dang nhap
     * @param password mat khau
     * @return trang thai xac thuc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int checkLogin(String username, char[] password) throws SQLException, ClassNotFoundException {
        int result;
        result = user.auth(username, password);
        if (result == Constants.LOGIN_SUCCESS) {
            Session.currentUser = username;
        }
        return result;
    }

    /**
     * Chuyen huong sau khi dang nhap
     *
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public void redirectUser() throws SQLException, ClassNotFoundException {
        switch(user.getRole(Session.currentUser)){
            case Constants.LIB:
                LibrarianUI libUI = new LibrarianUI();
                libUI.setVisible(true);
                break;
            case Constants.ADM:
                break;
            case Constants.USR:
                UserUI userUI = new UserUI();
                userUI.setVisible(true);
                break;
            default: // case USR
                System.out.println("something wrong at redirect user");
        }
    }

}
