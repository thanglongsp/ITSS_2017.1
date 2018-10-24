abstract class View {

	abstract void draw();

	/**
	 * Display a successful message
	 * @param message a string tobe display on screen
	 */
	protected void displaySuccessfulMessage(String message){
		this.display('success', message);
		return;
	}

	/**
	 * Display an error message
	 * @param message a string tobe display on screen
	 */
	protected void displayErrorMessage(String message){
		this.display('error', message);
		return;
	}
}