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
public class LendBookController {

    Registration registration;
    Card card;

    public LendBookController() {
        registration = new Registration();
        card = new Card();
    }

    public List<Registration> getRegistered(int cardId) throws SQLException, ClassNotFoundException {
        return registration.getRegistered(cardId);
    }

    public void acceptRegistration(List<Integer> reg_id) throws SQLException, ClassNotFoundException {
        registration.acceptRegistration(reg_id);
    }

    public Card findCardById(int cardId) throws SQLException, ClassNotFoundException {
        return card.findById(Integer.toString(cardId));
    }
}
