/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Copy;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pnam2
 */
public class UpdateBorrowedBookInfoController {
   Copy copy;

   public UpdateBorrowedBookInfoController() {
       copy = new Copy();
   }

    /**
     * Lay danh sach copy da duoc muon
     *
     * @return tra ve list sach da duoc muon
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

   public List<Copy> getBorrowedCopies() throws SQLException, ClassNotFoundException{
       return copy.getBorrowedCopies();
   }

    /**
     * Cap nhat trang thai cua ban copy
     *
     * @param sequenceNumber so thu tu cua sach
     * @param bookNumber     ma sach
     * @param state          trang thai cua sach
     * @return tra ve 1 neu cap nhat thanh cong, nguoc lai tra ve 0
     * @throws SQLException           neu co loi khi tuong tac voi db
     * @throws ClassNotFoundException neu load class trong connectDb khong thanh cong
     */

    public int updateState(int sequenceNumber, String bookNumber, int state) throws SQLException, ClassNotFoundException {
        return copy.updateBorrowedCopyState(sequenceNumber, bookNumber, state);
    }
  
}
