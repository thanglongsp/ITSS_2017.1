class Registration extends Model{
	private int cardId;
	private Date registeredDate;
	private List<Copy> copies; // danh sach sach da dang ky muon

	/**
	 * Khoi tao doi tuong lop Registration
	 * @param  cardId         ID card nguoi muon sach
	 * @param  registeredDate ngay dang ky muon sach
	 * @return                object Registration
	 */
	public Registration(int cardId, Date registeredDate){
		setCardId(cardId);
		setRegisteredDate(registeredDate);
		setCopiesList();
	}

	/**
	 * Phuong thuc static tim kiem du lieu trong DB, tao ra doi tuong tuong ung tu ket qua tra ve.
	 * @param  cardId ID the nguoi dang ky muon sach
	 * @return        object lop Registraion
	 */
	public static Registration findByCardId(int cardId){
		// Lay du lieu tu bang Registration
		String query  = 
			"SELECT * " + 
			"FROM " + dbName + ".Registration " + 
			"WHERE cardId = " + cardId;
		Statement st = this.conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if (rs.next() != null) {
			int id = rs.getInt("cardId");
			Date registeredDate = rs.getDate("registeredDate");
			Registration registration = new Registration(id, registeredDate);
			// tao list copies:
			String query = "select copy_id from registration_copy where card_id = " + id;
			ResultSet rs = executeQuery(query);
			while(rs.next() != null){
				registration.getCopiesList().add(new Copy("Thon tin lay duoc tu truy van"));
			}
		} else return null;

		return registration;
	}

	/**
	 * Luu thong tin cua object registration vao DB
	 * @throws SQLException xay ra loi khi luu du lieu vao DB
	 */
	public void save(){
		// Tao cau truy van
		// danh dau trang thai DB truoc khi thuc hien SQL statement
		// excute statement
		// neu xay ra loi rollback() DB ve trang thai truoc do
		String query = "insert into Registration values ...";
		try{
			DB::beginTransaction();
			Statement st = this.conn.createStatement();
			st.executeQuery(query);
			DB::commit();
		} catch (SQLException e) {
			DB::rollback();
		}
	}

	public void setCardId(int cardId){
		this.cardId = cardId;
	}

	public void setRegisteredDate(Date date){
		this.registeredDate = date;
	}

	public void setCopiesList(){
		this.copies = new List<Copy>;
	}

	public int getCardid(){
		return this.cardId;
	}

	public Date getRegisteredDate(){
		return this.registeredDate;
	}

	public getCopiesList(){
		return this.copies;
	}
}