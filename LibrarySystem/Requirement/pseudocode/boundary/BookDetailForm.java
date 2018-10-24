class BookDetailForm extends View implements ActionListener{
	private Book book;
	private int cardId;
	private final RegisterToBorrowBookController registerController;
	private ActionControl actionControl;

	/**
	 * Khoi tao doi tuong lop BookDetailForm
	 * @param  bookId ID sach can hien thi thong tin
	 */
	public BookDetailForm(int bookId, int cardId){
		this.setBook(Book::findById(bookId));
		this.setCardId(cardId);
		this.setRegisterController(new RegisterToBorrowBookController(this.getBook(), cardId));
	}

	/**
	 * implement abstract class cua lop View, render giao dien ra man hinh
	 * gom cac thong tin chi tiet cua sach va Btn 'Register'
	 */
	public void draw(){
		// Add book information into view (title, author, publisher, isbn, book number ...)
		this.addField(book.getTitle());
		// tuong tu voi cac truong du lieu khac
		this.display();
		Button registerBtn = new Button('Register');
		registerBtn.display();
	}

	/**
	 * Su dung cac method cua RegisterController de kiem tra cac dieu kien logic, dua ra thong bao loi / thanh cong.
	 */
	public void registerToBorrow(){
		if (this.registerController.isCardExpired() == true){ // Neu the da het han
			this.displayErrorMessage("The cua ban da het han."); // Dua ra thong bao loi
			return;
		}
		if (this.registerController.hasAnyOverdueUnreturnedBook() == true){ // Neu nguoi dung co sach qua han chua tra
			this.displayErrorMessage("Ban con sach qua han chua tra, khong the muon them sach."); // Dua ra thong bao loi
			return;
		}
		if (this.registerController.isBookAvailable() == false){
			this.displayErrorMessage("Sach nay da duoc muon het, hay chon sach khac.");
			return;
		}
		if (this.registerController.isOverLimit() == true) { // Neu so sach nguoi dung muon lon hon 5 cuon
			this.displayErrorMessage("Ban chi duoc muon toi da 5 cuon sach."); // dua ra thong bao loi
			return;
		}

		// Neu Khong vi pham cac dieu kien tren
		this.registerController.register(); // Luu lai thong tin muon sach cua nguoi dung vao DB
		this.displaySuccessfulMessage("Ban da dang ky muon sach thanh cong."); // Dua ra thong bao thanh cong
		return;
	}

	@override
	public void actionPerformed(ActionEvent e) {
		switch(e.getSource()){
			case btnRegister:
				// thực thi hàm trong interface
			case ... :
		}
	}

	public interface ActionControl{
	    void setOnClickRegister();
	}

	public void setActionControl(ActionControl actionControl){
	    this.actionControl = actionControl;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public void setRegisterController(RegisterToBorrowBookController controller){
		this.registerController = controller;
	}
	public Book getBook(){
		return this.book;
	}

	public getRegisterController(){
		return this.registerController;
	}
}