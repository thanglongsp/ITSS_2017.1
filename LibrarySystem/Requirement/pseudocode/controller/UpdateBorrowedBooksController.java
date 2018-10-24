import java.sql.SQLException;
import java.sql.Statement;

class UpdateBorrowedBooksController{
    private Copy copy;
    private String status;

    /**
     * Cap nhat trang thai sach duoc muon
     * @param copy  ban sao cua cuon sach can thai doi trang thai
     * @return      true neu cap nhat trang thai thanh cong, false neu that bai
     */

    boolean updateBorrowedBook(Copy copy){
        // Cap nhat trang thai cua sach trong database o bang COPY
        copy.updateStatus(status);
    }
}