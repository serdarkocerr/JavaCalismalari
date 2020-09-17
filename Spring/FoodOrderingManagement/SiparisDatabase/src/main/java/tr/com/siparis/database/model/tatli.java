package tr.com.siparis.database.model;

public class tatli {
	private int tatliid;
	private String tatliadi;
	public int getTatliid() {
		return tatliid;
	}
	public void setTatliid(int tatliid) {
		this.tatliid = tatliid;
	}
	public String getTatliadi() {
		return tatliadi;
	}
	public void setTatliadi(String tatliadi) {
		this.tatliadi = tatliadi;
	}
	@Override
	public String toString() {
		return "tatli [tatliid=" + tatliid + ", tatliadi=" + tatliadi + "]";
	}
	public tatli(int tatliid, String tatliadi) {
		super();
		this.tatliid = tatliid;
		this.tatliadi = tatliadi;
	}
	public tatli() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
