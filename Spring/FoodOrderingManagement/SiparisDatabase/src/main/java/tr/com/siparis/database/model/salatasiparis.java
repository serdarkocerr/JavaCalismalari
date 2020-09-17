package tr.com.siparis.database.model;

public class salatasiparis {

	private int salataid;
	private int siparisid;
	public int getSalataid() {
		return salataid;
	}
	public void setSalataid(int salataid) {
		this.salataid = salataid;
	}
	public int getSiparisid() {
		return siparisid;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	@Override
	public String toString() {
		return "salatasiparis [salataid=" + salataid + ", siparisid=" + siparisid + "]";
	}
	public salatasiparis(int salataid, int siparisid) {
		super();
		this.salataid = salataid;
		this.siparisid = siparisid;
	}
	public salatasiparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
