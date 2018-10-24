import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class SearchBookController{
    private String query;
    /**
     * Kiem tra xem truong du lieu da duoc nhap hay chua
     * @return      tra ve false neu xau query la rong, nguoc lai tra ve true
     */
    public boolean checkInputField() {
        if (query == null) {
            return false;
        }
        return true;
    }

    /**
     * Tim sach trong database
     *
     * @param query         xau nhap vao de tim kiem
     * @return books        tra ve danh sach sach tim duoc
     * @throws SQLException tra ve loi khi tuong tac voi database
     */
    List<Book> searchBooksFromDb(String query) throws SQLException {
        // Lay du lieu tu database
        String bookQuery = "select * from " + bookDb +
                "where TITLE = " + query;
        int i = 0;
        List<Book> books = new ArrayList<>();
        Statement statement = this.conn.createStatement();
        ResultSet resultSet = statement.executeQuery(bookQuery);

        /**
         * Neu khong tim thay sach, hien thi thong bao loi
         */

        if (resultSet == null) {
            return null;
        }
        /**
         * Luu thong tin sach vao mang roi hien thi
         */
        while (resultSet.next()) {
            //Luu thong tin sach vao mang books
            books.get(i).setBookNumber(resultSet.getInt("BOOK_NUMBER"));
            books.get(i).setTitle(resultSet.getString("TITLE"));
            books.get(i).setPublisher(resultSet.getString("PUBLISHER"));
            books.get(i).setAuthors(resultSet.getString("AUTHORS"));
            books.get(i).setIsbn(resultSet.getString("ISBN"));

            String copyQuery = "select * from " + copyDb
                    + "where BOOK_NUMBER = " + books.get(i).getBookNumber();
            ResultSet resultSet1 = statement.executeQuery(copyQuery);
            int j = 0;
            //Luu thong tin copy vao truong copy trong mang books
            while (resultSet1.next()) {
                books.get(i).getCopies().get(j).setBookNumber(resultSet1.getInt("BOOK_NUMBER"));
                books.get(i).getCopies().get(j).setSequenceNumber(resultSet1.getInt("SEQUENCE_NUMBER"));
                books.get(i).getCopies().get(j).setTypeOfCopy(resultSet1.getString("TYPE_OF_COPY"));
                books.get(i).getCopies().get(j).setPrice(resultSet1.getInt("PRICE"));
                books.get(i).getCopies().get(j).setStatus(resultSet1.getString("STATUS"));
                j++;
                resultSet1.close();
            }
            i++;
        }
        statement.close();
        resultSet.close();
        return books;
    }
}