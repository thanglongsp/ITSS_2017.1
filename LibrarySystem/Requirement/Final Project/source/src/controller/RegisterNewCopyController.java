/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.LibrarianUI;
import entity.Copy;
import java.sql.SQLException;
import java.util.List;
import java.lang.NullPointerException;

/**
 *
 * @author thanglongsp
 */
public class RegisterNewCopyController {
    Copy mCopy;
    
    public RegisterNewCopyController(){
        mCopy = new Copy();
    }

    /**
     * Lay danh sach toan bo cac ban copy
     *
     * @return danh sach copy
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public List<Copy> getAllCopies() throws SQLException, ClassNotFoundException {
       return mCopy.getAllCopies();
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
    
    public int registerNewCopy(String bookNumber,int typeOfCopy,float price) throws SQLException, ClassNotFoundException{
        return mCopy.registerNewCopy(bookNumber, typeOfCopy, price);
    }
}
