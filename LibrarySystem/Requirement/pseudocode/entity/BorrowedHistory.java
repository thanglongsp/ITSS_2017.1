class BorrowedHistory {
	private int cardId;
	private int bookId;
	private Date borrowedDate;
	private Date expiredDate;
	private int status; 

	public BorrowedHistory(int cardId, int bookId, Date borrowedDate, Date expiredDate, int status){
		setCardId(cardId);
		// tuong tu voi cac attributes con lai
	}

	public static List<BorrowedHistory> getListUnreturnedBook(int cardId){
		// Khoi tao 1 danh sach rong
		// Truy van DB bang BorrowedHistory
		// Tim cac record co cardId = cardId AND status = UNRETURNED
		// tao object cua lop BorrowedHistory
		// Add vao danh sach
		List list = new List<BorrowedHistory>;
		String query = "select * from BorrowedHistory where card_id = " + cardId + " AND status = 'UNRETURED'";
		ResultSet rs = excuteQuery(query);
		while(rs.next()){
			// tao object, add vao list
			list.add(new BorrowedHistory("thong tin lay duoc tu ResultSet"));
		}
		return list;
	}


	public	int getCardId(){
		return this.cardId;
	}

	public Date getExpiredDate(){
		return this.expiredDate;
	}

	// ...
	
	public void setCardId(int cardId){
		this.cardId = cardId;
	}

	//...
}