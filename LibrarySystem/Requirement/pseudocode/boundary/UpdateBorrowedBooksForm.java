class UpdateBorrowedBooksForm extends View{
    private final UpdateBorrowedBooksController controller;
    private String status;

    /**
     * Hien thi form tim kiem sach
     * voi truong trang thai sach
     */
    void draw(){
        Form form = new Form();
        form.addField("Status", status);
        form.display();
        Button btn = new Button("Update");
        btn.display();
    }
    /**
     * Khoi tao form voi controller
     */
    public UpdateBorrowedBooksForm() {
        this.controller = new UpdateBorrowedBooksController();
    }

    /**
     * Cap nhat thong tin sach
     */
    void updateBorrowedBook(){
        //Neu cap nhat thanh cong hien thi thong bao thanh cong
        if (controller.updateBorrowedBook(status)) displaySuccessfulMessage("Updated successfully");
        else displayErrorMessage("Update failed.");
    }
}