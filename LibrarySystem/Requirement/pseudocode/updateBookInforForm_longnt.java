class UpdateBookInforForm {
    private Book book;
	private int numberBook;
	private final UpdateBookController updateBookInforController; 
	private ActionControl actionControl;
        
    /**
	 * Tao ra form chua thong tin cua book tuong ung
	 * @param  numberBook
	 * @return Object UpdateBookInforForm chua thong tin cua book tuong ung
	 */
        
        public updateBookInfor(int numberBook){
        book = Book::findById(numberBook);
        updateBookInforController = new UpdateBookInforController(book);
        }
        
    /**
	 * implement abstract method cua lop View, render giao dien ra man hinh gom cac thong tin chi tiet cua Book
	 */
        private void draw(){
		display(book.getTitle());
		display(book.getPublisher());
		display(book.getAuthors());
		display(book.getNumberOfCopies());
        display(book.getTypeOfCopy());
        display(book.getPriceOfCopy());
		Button UpdateBtn = new Button('Update');
		UpdateBtn.display();
		
        //Hien thi form chua thong tin cua Book, 
        //librarian chinh sua thong tin Book qua form sau do nhan 'Update'
       
		Form form = new Form();
		form.addField("Number Book", book.getNumberBook());
		form.addField('Title', book.getBookTitle());
		form.addField('Publisher', book.getPublisher());
        form.addField('Authors', book.getAuthors());
        form.addField('Number of copies', book.getNumberOfCopies());
        form.addField('Type of copy', book.getTypeOfCopy());
        form.addField('Price Of copy', book.getPriceOfCopy());
		form.display();
		Button updateBtn = new Button('Update');
		updateBtn.display();
 		return ;
                }
                this.display('error', message);
 		return;
 	public interface ActionControl{
    	    void setOnClickUpdate();
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
