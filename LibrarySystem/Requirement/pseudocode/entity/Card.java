class Card extends Model{
	private String name;
	private int id;
	private Date expiredDate;
	private Date birthday;
	
	/**
	 * Khoi tao doi tuong cua lop Card
	 * @param  name        xau ky tu ten chu the
	 * @param  id          ID card
	 * @param  expiredDate ngay het han cua the
	 * @param  birthday    ngay sinh chu the
	 * @return             object cua lop Card
	 */
	public Card(String name, int id, String expiredDate, String birthday){
		super();
		setId(id);
		setName(name);
		setExpiredDate(expiredDate);
		setBirthday(birthday);
	}

	/**
	 * Tim card trong DB theo ID
	 * @param  id ID card
	 * @return    object Card or null if not found
	 */
	public static Card findById(int id){
		String query  = 
			"SELECT * 
			FROM " + dbName + ".Card 
			WHERE id = " + id;
		Statement st = this.conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if (rs.next() != null) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Date expiredDate = rs.getDate("expiredDate");
			Date birthday = rs.getDate("birthday");	
		} else return null;
		
		Card card = new Card(id, name, expiredDate, birthday);
		return card;
	}

	/**
	 * update card with new information
	 * @throws SQLException if there was a problem when working with DB.
	 */
	public void update(){
		String query = "UPDATE " + dbName + ".Card " +
			"SET name = " + this.name + "," + "expiredDate = " + this.expiredDate + "birthday = " + this.birthday +
			"WHERE id = " + this.id;
		try{
			DB::beginTransaction();
			Statement st = this.conn.createStatement();
			st.executeQuery(query);
			DB::commit();
		} catch (SQLException e) {
			DB::rollback();
		}
	}


	public void setId(int id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setExpiredDate(Date expiredDate){
		this.expiredDate = expiredDate;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	public void getId(){
		return this.id;
	}

	public void getName(){
		return this.name;
	}

	public void getExpiredDate(){
		return this.expiredDate;
	}

	public void getBirthday(){
		return this.birthday;
	}

}