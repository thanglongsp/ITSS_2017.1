class RegisterNewBookForm {
    private Book book;
	private int numberBook;
	private final registerNewBookController RegisterNewBookController; 
	private ActionControl actionControl;
	/**
	 *@param numberBook
	 *@return new book or new copy of exist book, if successed -> true, else -> false
	 */
	 
	//Sử dụng tính đa hình
	//nếu đầu vào là numberBook thì là "addNewCopyOfExistBook"
	//còn không mặc định là "createNewBookEntryAndCopy"
	
        public registerNewBook(){
			Book book = new Book();
			registerNewBookController = new RegisterNewBookController(book);
		}
		
        public registerNewBook(int numberBook){
        book = Book::findById(numberBook);
        registerNewBookController = new RegisterNewBookController(book);
        }
	
	/**
	*Nhập dữ liệu đăng ký từ bàn phím
	*/
		Scanner input = new Scanner(System.in);
		if(numberBook != null){
		Register r1 = new Register(numberBook);
		
		System.out.println("+Number of copies : ");
		book.numberBook = input.nextInt();
		
		System.out.println("+Type of copy: ");
		book.typeOfCopy = input.nextLine();
		
		System.out.println("+Price of copy: ");
		book.priceOfCopy = input.nextLine();
		}
	else {
		Register r1 = new Register();
		
		System.out.println("+Title : ");
		book.title = input.nextInt();
		
		System.out.println("+Publisher: ");
		book.publisher = input.nextLine();
		
		System.out.println("+Authors: ");
		book.authors = input.nextLine();
		
		System.out.println("+Number of copies : ");
		book.numberBook = input.nextInt();
		
		System.out.println("+Type of copy: ");
		book.typeOfCopy = input.nextLine();
		
		System.out.println("+Price of copy: ");
		book.priceOfCopy = input.nextLine();
		
	}

    /**
	 *Hiển thị thông tin của sách vừa nhập vào
	 *nếu là sách mới đăng ký thì thông tin là đầy đủ
	 *nếu là sách thêm bản copy, thì như trong mô tả, 
	 *hệ thống sẽ tự động thêm numberBook và numberCopy
 	 */

        private void drawForm(){
		display(book.getTitle());
		display(book.getPublisher());
		display(book.getAuthors());
		display(book.getNumberOfCopies());
        display(book.getTypeOfCopy());
        display(book.getPriceOfCopy());
		Button registerBtn = new Button('register');
		registerBtn.display();
	/** 
     * Hien thi form chua thong tin cua sách mới add, 
     * librarian xem lại thong tin đã nhập qua form sau do nhan 'register'
     */
		Form form = new Form();
		form.addField("Number Book", book.getNumberBook());
		form.addField('Title', book.getBookTitle());
		form.addField('Publisher', book.getPublisher());
        form.addField('Authors', book.getAuthors());
        form.addField('Number of copies', book.getNumberOfCopies());
        form.addField('Type of copy', book.getTypeOfCopy());
        form.addField('Price Of copy', book.getPriceOfCopy());
                
		form.display();
		Button registerBtn = new Button('register');
		registerBtn.display();
 		return ;
                }
                this.display('error', message);
 		return;
 	public interface ActionControl{
    	    void setOnClickregister();
	}

	public void setActionControl(ActionControl actionControl){
	    this.actionControl = actionControl;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public void getBook(){
		return this.book;
        }

}
