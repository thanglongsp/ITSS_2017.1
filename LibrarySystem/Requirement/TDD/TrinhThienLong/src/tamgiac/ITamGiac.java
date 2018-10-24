package tamgiac;

public interface ITamGiac {

	/**
	 * Kiem tra a + b > c
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public boolean kiemTraDoDai(float a, float b, float c);
	
	/**
	 * Kiem tra 3 canh da cho co tao thanh 1 tam giac hay khong.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public boolean isTamGiac(float a, float b, float c);
}
