package tamgiac;

public class TamGiac implements ITamGiac {

	public boolean kiemTraDoDai(float a, float b, float c) {
		return a + b > c;
	}

	public boolean isTamGiac(float a, float b, float c) {
		return kiemTraDoDai(a, b, c) && kiemTraDoDai(a, c, b) && kiemTraDoDai(c, b, a);
	}

}
