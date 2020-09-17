package tr.com.siparis.database.model;

public class salata {

	private int salataid;
	private String salataadi;
	public int getSalataid() {
		return salataid;
	}
	public void setSalataid(int salataid) {
		this.salataid = salataid;
	}
	public String getSalataadi() {
		return salataadi;
	}
	public void setSalataadi(String salataadi) {
		this.salataadi = salataadi;
	}
	@Override
	public String toString() {
		return "salata [salataid=" + salataid + ", salataadi=" + salataadi + "]";
	}
	public salata(int salataid, String salataadi) {
		super();
		this.salataid = salataid;
		this.salataadi = salataadi;
	}
	public salata() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
