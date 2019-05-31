public class Siparis {

	String isim;
	float fiyat;

	public Siparis(String isim, float fiyat) {
		this.isim = isim;
		this.fiyat = fiyat;
	}

	public String toString() {
		return isim + ": " + fiyat + "₺";
	}
}
