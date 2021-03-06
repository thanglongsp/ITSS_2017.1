class Copy extends Model {
    private int bookNumber;
    private int sequenceNumber;
    private String typeOfCopy;
    private int price;
    private String status;

    /**
     * Khoi tao object cua lop Copy
     *
     * @param bookNumber     ma so sach
     * @param sequenceNumber so thu tu cua ban copy
     * @param typeOfCopy     loai copy
     * @param price          gia cua ban copy
     * @param status         trang thai cua ban copy
     * @return object cua lop copy
     */

    public Copy(int bookNumber, int sequenceNumber, String typeOfCopy, int price, String status) {
        this.bookNumber = bookNumber;
        this.sequenceNumber = sequenceNumber;
        this.typeOfCopy = typeOfCopy;
        this.price = price;
        this.status = status;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getTypeOfCopy() {
        return typeOfCopy;
    }

    public void setTypeOfCopy(String typeOfCopy) {
        this.typeOfCopy = typeOfCopy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Cap nhat trang thai cua sach duoc muon
     * @param status    trang thai can chuyen ve
     * @return bool     tra ve trang thai cua cau lenh cap nhat du lieu trong database
     * @throws SQLException Xay ra loi trong qua trinh tuong tac voi database
     */

    boolean updateStatus(String status) {
        String copyQuery = "update COPY set STATUS = "
                + status
                + "where BOOK_NUMBER = "
                + this.getBookNumber();
        try {
            Statement statement = conn.createStatement();
            boolean bool = statement.execute(copyQuery);
            statement.close();
            return bool;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}