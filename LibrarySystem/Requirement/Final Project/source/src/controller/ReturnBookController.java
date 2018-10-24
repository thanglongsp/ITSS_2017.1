/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Card;
import entity.Copy;
import entity.Registration;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pnam2
 */
public class ReturnBookController {

    Registration registration;
    Card card;

    public ReturnBookController() {
        registration = new Registration();
        card = new Card();
    }

    public List<Registration> returnBook(int cardId,int userID) throws SQLException, ClassNotFoundException {
        return registration.returnBook(cardId,userID);
    }
}
