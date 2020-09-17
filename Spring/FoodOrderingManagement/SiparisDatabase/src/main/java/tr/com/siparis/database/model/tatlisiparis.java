package tr.com.siparis.database.model;

public class tatlisiparis {

	private int siparisid;
	private int tatliid;
	public int getSiparisid() {
		return siparisid;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	public int getTatliid() {
		return tatliid;
	}
	public void setTatliid(int tatliid) {
		this.tatliid = tatliid;
	}
	@Override
	public String toString() {
		return "tatlisiparis [siparisid=" + siparisid + ", tatliid=" + tatliid + "]";
	}
	public tatlisiparis(int siparisid, int tatliid) {
		super();
		this.siparisid = siparisid;
		this.tatliid = tatliid;
	}
	public tatlisiparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
