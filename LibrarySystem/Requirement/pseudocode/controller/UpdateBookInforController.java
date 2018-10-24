class UpdateBookInforController {
 	private Book book;
 
	/**
	 *@param book là một đối tượng của lớp Book
	 *@return true or false -> kiem tra thong tin book voi du lieu duoc lay tu form
	 */
 	public void updateBookInfor(){
		if (isBookExist() == false) {
			form.displayErrorMessage("Sach chua ton tai.");
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

		book.saveUpdateBookInfor();
		form.displaySuccessfulMessage("Cap nhat thong tin book thanh cong!");
		return;
	
	
	
 	}

	 private boolean isBookExist(){ //Kiem tra cac dieu kien dau vao.
		if (Book::findByNumberBook(Book.getNumberBook()) != null) return true;
		return false;
	//Kiem tra xem sach muon them da ton tai hay chua?
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