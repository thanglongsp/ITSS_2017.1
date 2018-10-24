/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import boundary.LoginUI;
import boundary.UserUI;
import entity.Book;

import java.sql.SQLException;

/**
 *
 * @author longdragon
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        LoginUI loginUi = new LoginUI();
        loginUi.setVisible(true);
    }
    
}
