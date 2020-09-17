package tr.com.siparis.database.model;

public class corba {

	private int corbaid;
	private String corbaadi;
	public int getCorbaid() {
		return corbaid;
	}
	public void setCorbaid(int corbaid) {
		this.corbaid = corbaid;
	}
	public String getCorbaadi() {
		return corbaadi;
	}
	public void setCorbaadi(String corbaadi) {
		this.corbaadi = corbaadi;
	}
	@Override
	public String toString() {
		return "corba [corbaid=" + corbaid + ", corbaadi=" + corbaadi + "]";
	}
	public corba(int corbaid, String corbaadi) {
		super();
		this.corbaid = corbaid;
		this.corbaadi = corbaadi;
	}
	public corba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
