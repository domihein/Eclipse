package test;


public class EnumTest2 {
	public static void main(String[] args) {
		System.out.println("Alkoholgehalt von Bananen: " + Alkohol.BANANE.alkoholgehalt() + " %");
	}
}

enum Alkohol {
	WEIN(12), BIER(4.5), BANANE(1), WASSER(0);

	private final double alkoholgehaltProzent;

	// Konstruktor mit Parameteruebergabe:
	Alkohol(double alkoholgehaltProzent) {
		this.alkoholgehaltProzent = alkoholgehaltProzent;
	}

	public double alkoholgehalt() {
		return alkoholgehaltProzent;
	}
}