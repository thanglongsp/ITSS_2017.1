class UpdateCardForm extends View implements ActionListener{
	private Card card;
	private final UpdateCardController updateCardController; //composition
	private ActionControl actionControl;

	/**
	 * Tao ra form chua thong tin cua card tuong ung
	 * @param  cardId card's ID
	 * @return        Object UpdateCardForm chua thong tin cua card tuong ung
	 */
	public UpdateCardForm(int cardId){
		this.setCard(Card::findById(cardId));
		updateCardController = new UpdateCardController(this.getCard());
	}

	/**
	 * implement abstract method cua lop View, render giao dien ra man hinh gom cac thong tin chi tiet cua Card
	 */
	public void draw(){
		// Hien thi form chua thong tin cua the, 
		// librarian chinh sua thong tin the qua form sau do nhan 'Update'
		Form form = new Form();
		form.addField("ID", card.getId());
		form.addField('Name', card.getName());
		form.addField("Expired Date", card.getExpiredDate());
		form.addField("Birthday", card.getBirthday());
		form.display();
		Button updateBtn = new Button('Update');
		updateBtn.display();
		return ;
	}

	/**
	 * Su dung cac method cua UpdateCardController de kiem tra logic va dua ra cac thong bao tuong ung.
	 */
	public void updateCard(){
		if (this.updateCardController.validateInput() == false) {
			this.displayErrorMessage("Truong thong tin nay nhap chua dung. hay nhap lai");
			return;
		}
		if (this.updateCardController.isCardExist() == false) {
			this.displayErrorMessage("The chua ton tai.");
			return;
		}
		// Neu khong vi pham cac dieu kien tren, luu lai the voi thong tin moi
		this.updateCardController.update();
		this.displaySuccessfulMessage("Cap nhat thong tin the thanh cong!"); // dua ra thong bao thanh cong
		return;
	}

	@override
	public void actionPerformed(ActionEvent e) {
		switch(e.getSource()){
			case btnUpdate:
				// thực thi hàm trong interface
			case ... :
		}
	}

	public interface ActionControl{
	    void setOnClickUpdate();
	}

	public void setActionControl(ActionControl actionControl){
	    this.actionControl = actionControl;
	}

	public void setCard(Card card){
		this.card = card;
	}

	public void getCard(){
		return this.card;
	}
}