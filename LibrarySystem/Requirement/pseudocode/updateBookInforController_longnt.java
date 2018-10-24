class UpdateBookInforController {
 	private Book book;
 
	/**
	 * update thong tin book voi du lieu duoc lay tu form
	 */
 	public void updateBook(){
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

		book.save();
		form.displaySuccessfulMessage("Cap nhat thong tin book thanh cong!");
		return;
	
	
	
 	}
	 private boolean isBookExist(){
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
	/*
	 *su dung regex de validate cac truong du lieu
	 *Neu du lieu thoa man return true
	 *else return false
	 */
	}
 }