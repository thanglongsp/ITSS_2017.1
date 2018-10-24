/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Copy;

import java.sql.SQLException;

/**
 * @author thanglongsp
 */
public class UpdateCopyInforController {
    Copy mCopy;

    public UpdateCopyInforController() {
        mCopy = new Copy();
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
        return mCopy.checkCopyNotExist(sequence, bookNumber);
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

    public int UpdateCopyInfor(int sequenceNumber, String bookNumber, int typeOfCopy, float price, int status) throws SQLException, ClassNotFoundException {
        return mCopy.updateCopyInfor(sequenceNumber, bookNumber, typeOfCopy, price, status);
    }

}
