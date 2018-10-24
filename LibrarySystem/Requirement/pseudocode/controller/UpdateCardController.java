class UpdateCardController {
	private Card card;
	private UpdateCardForm form;
	
	/**
	 * Su dung method save cua model card de luu lai the cung thong tin moi
	 */
	public void update(){
		card.update()
	}

	/**
	 * validate thong tin duoc dien trong form
	 * @return true neu du lieu hop le, nguoc lai return false
	 */
	public boolean validateInput(){
		// su dung regex de validate cac truong du lieu
		// Neu du lieu thoa man return true
		// else return false
	}

	/**
	 * Tim kiem thong tin the trong DB
	 * @return true neu tim thay the, false neu nguoc lai
	 */
	public boolean isCardExist(){
		if (Card::findById(card.getId()) != null) return true;
		return false;
	}
}