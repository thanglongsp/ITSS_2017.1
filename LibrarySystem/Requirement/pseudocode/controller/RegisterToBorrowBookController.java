class RegisterToBorrowBookController {
	private int cardId;
	private Book book;

	/**
	 * Luu lai thong tin dang ky cua nguoi dung vao bang du lieu Registration
	 */
	public void register(){
		// Tao mot doi tuong cua Model Registration
		Registration record = new Registration();
		// set cac thong tin can thiet cho doi tuong
		// registrationId, bookId, cardId, Ngay Dang Ky, Trang thai
		record.setBookId(book.getId());
		// ... tuong tu voi cac attributes khac
		record.save(); // Luu lai dang ky vao trong DB
	}

	/**
	 * Kiem tra the cua nguoi dung da het han hay chua
	 * @return true neu card da het han, nguoc lai return false
	 */
	public boolean isCardExpired(){
		// Su dung phuong thuc static findById() lop Card de tim the co ID = cardId trong DB, tra lai doi tuong la Card
		Card card = Card::findById(this.getCardId());
		// Lay ngay het han cua the
		// So sanh voi ngay hien tai
		// Neu da qua han, return TRUE, nguoc lai return FALSE
		if (card.getExpiredDate() < CURRENT_DATE) return true;
		return false;
	}

	/**
	 * Kiem tra nguoi dung co sach qua han chua tra hay khong
	 * @return TRUE neu dung, FALSE neu sai
	 */
	public boolean hasAnyOverdueUnreturnedBook(){
		// Lay danh sach sach chua tra cua nguoi dung
		List<BorrowedHistory> list = BorrowedHistory.getListUnreturnedBook(this.cardId);
		// Duyet tung object trong danh sach
		while (element = list.next()) {
			if (element.getExpiredDate() < CURRENT_DATE) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Kiem tra trang thai cua cuon sach nay co con de muon hay khong
	 * @return TRUE neu co the muon, FALSE neu nguoc lai
	 */
	public boolean isBookAvailable(){
		// Su dung phuong thuc countUnborrowedCopies() cua class Book
		// Neu count > 0 return TRUE
		// nguoc lai return FALSE
		if (this.getBook().countUnborrowedCopies() > 0) return true;
		return false;
	}

	/**
	 * Kiem tra tong so sach ma nguoi nay muon co lon hon 5 hay khong
	 * @return TRUE neu tong so sach > 5, FALSE neu nguoc lai
	 */
	public boolean isOverLimit(){
		// lay ra danh sach copy ma nguoi dung da dang ky muon
		// dem so sach trong danh sach, neu > 5 return TRUE
		// nguoc lai return flase
		Registration registration = Registration.findByCardId(this.getCardId());
		if (registration.getCopiesList().size() > 5) return true;
		return false;
	}
}