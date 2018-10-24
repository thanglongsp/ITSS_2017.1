class UpdateBookInforController {
 	private Book book;
	private int numberbook;
	
	/**
	 *@param numberbook
	 *@param book là đối tượng của lớp Book
	 *@return true or false -> check condition input
	 *register book voi data duoc lay tu form
	 */
	 
 	public void registerNewBook(){ //Kiểm tra điều kiện đối với "createNewBookEntryAndCopy"
		if (isExistTitle == true && isExistAuthor) == true && isExistpiblisher == true { 
			// nếu sách mới đăng ký trùng tên tác giả, nhà xuất bản, tiêu đề với sách trong thư viện, thì đưa ra thông báo sách đã tồn tại
			form.displayErrorMessage("Sách đã tồn tại ! yêu cầu nhập lại.");
			return;
		}
		if (isEmptyField() == true) {
			form.displayErrorMessage("Phai dien day du thong tin! hay nhap lai");
			return;
		}
		
		if (validateInput() == false) {
			form.displayErrorMessage("ky tu khong hop le! hay nhap lai");
			return;
		}

		book.saveRegisterNewBook();
		form.displaySuccessfulMessage("Cap nhat thong tin book thanh cong!");
		return;
 	}

	public void registerNewBook(numberbook){ //Kiểm tra điều kiện đối với "add new copy of exist book"
		if (isBookExist() == false) {
			form.displayErrorMessage("Sach chua ton tai. hay nhap lai");
			return;
		}
		
		if (isEmptyField() == true) {
			form.displayErrorMessage("Phai dien day du thong tin! hay nhap lai");
			return;
		}
		
		if (validateInput() == false) {
			form.displayErrorMessage("ky tu khong hop le! hay nhap lai");
			return;
		}

		book.saveRegisterNewBook();
		form.displaySuccessfulMessage("Cap nhat thong tin book thanh cong!");
		return;
 	}
	
	
	
	
	private boolean duplicateBook(){ //Kiểm tra sự trùng lặp sách, đối với thêm sách mới
	if (isExistTitle == true && isExistAuthor) == true && isExistpiblisher == true) {
	return false;
	}else return true;
	}
		
	
	 private boolean isBookExist(){
		if (Book::findById(Book.getId()) != null) return true;
		return false;
	
	 //Kiem tra xem co ton tai empty field khong?
	 //Neu co tra ve "true" -> yeu cau nhap lai.
	 //else return fale
	 
	}
	 
	 private boolean isEmptyField(){
		if (isEmptyField() == true) 
			else return false;
	
	//Kiem tra xem co ton tai empty field khong?
	//Neu co tra ve "true" -> yeu cau nhap lai.
	//else return fale
	
	}

	private boolean validateInput(){
	
	//su dung regex de validate cac truong du lieu
	//Neu du lieu thoa man return true
	//else return false
	
	}
	
 }
