/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package controller;

import common.Constants;
import entity.Card;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longdragon
 */
public class CardController {
    
    Card card;
    
    /**
     *
     */
    public CardController(){
        card = new Card();
    }

    /**
     * Khoi tao thong tin de cap nhat
     *
     * @param cardId ma the
     * @return tra ve the tim duoc
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public Card initInformationForUpdate(String cardId) throws SQLException, ClassNotFoundException {
        // validte card id
        return card.findById(cardId);
    }

    /**
     * Thay doi trang thai the
     *
     * @param cardId ma the
     * @param status trang thai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public void changeStatus(int cardId, int status) throws SQLException, ClassNotFoundException {
        // validate
        card.changeStatus(cardId, status);
    }

    /**
     * Cap nhat thong tin the
     *
     * @param cardId ma the
     * @param name ten chu the
     * @param expiredDateString ngay het han
     * @param birthdayString ngay sinh
     * @return Constants.SUCCESS neu thanh cong, Constants.FAILED neu that bai
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */
    public int update(int cardId, String name, String expiredDateString, String birthdayString) throws SQLException, ClassNotFoundException {
        // validate
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date expiredDate, birthday;
        
        try {
            expiredDate = (Date) df.parse(expiredDateString);
            System.out.println(expiredDate.toString());
        } catch (ParseException e) {
            return Constants.ERR_INVALID_DATE;
        }
        
        try {
            birthday = (Date) df.parse(birthdayString);
            System.out.println(birthday.toString());
        } catch (ParseException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (card.update(cardId, name, expiredDateString, birthdayString) > 0) {
            return Constants.SUCESS;
        }
        return Constants.FAILED;
    }

}
