package tr.com.siparis.database.model;

public class masa {

	private int masaid;
	private String masaadi;
	public int getMasaid() {
		return masaid;
	}
	public void setMasaid(int masaid) {
		this.masaid = masaid;
	}
	public String getMasaadi() {
		return masaadi;
	}
	public void setMasaadi(String masaadi) {
		this.masaadi = masaadi;
	}
	@Override
	public String toString() {
		return "masa [masaid=" + masaid + ", masaadi=" + masaadi + "]";
	}
	public masa(int masaid, String masaadi) {
		super();
		this.masaid = masaid;
		this.masaadi = masaadi;
	}
	public masa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
