package tr.com.siparis.database.model;

public class corbasiparis {

	private int corbaid;
	private int siparisid;
	public int getCorbaid() {
		return corbaid;
	}
	public void setCorbaid(int corbaid) {
		this.corbaid = corbaid;
	}
	public int getSiparisid() {
		return siparisid;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	@Override
	public String toString() {
		return "corbasiparis [corbaid=" + corbaid + ", siparisid=" + siparisid + "]";
	}
	public corbasiparis(int corbaid, int siparisid) {
		super();
		this.corbaid = corbaid;
		this.siparisid = siparisid;
	}
	public corbasiparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
