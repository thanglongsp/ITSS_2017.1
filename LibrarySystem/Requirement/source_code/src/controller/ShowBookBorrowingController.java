/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Registration;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thanglongsp
 */
public class ShowBookBorrowingController {
    Registration mBook;
    
    public List<Registration> showBookBorrowing(int card_id,int user_id) throws SQLException, ClassNotFoundException{
        return  mBook.showBookBorrowing(card_id,user_id);
    }
    
}
