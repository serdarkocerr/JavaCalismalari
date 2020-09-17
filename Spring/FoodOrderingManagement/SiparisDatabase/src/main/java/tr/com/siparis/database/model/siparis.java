package tr.com.siparis.database.model;

public class siparis {

	private int siparisid;
	private int masaid;
	private int kullaniciid;
	private String siparisDurumu;
	public int getSiparisid() {
		return siparisid;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	public int getMasaid() {
		return masaid;
	}
	public void setMasaid(int masaid) {
		this.masaid = masaid;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public String getSiparisDurumu() {
		return siparisDurumu;
	}
	public void setSiparisDurumu(String siparisDurumu) {
		this.siparisDurumu = siparisDurumu;
	}
	@Override
	public String toString() {
		return "siparis [siparisid=" + siparisid + ", masaid=" + masaid + ", kullaniciid=" + kullaniciid
				+ ", siparisDurumu=" + siparisDurumu + "]";
	}
	public siparis(int siparisid, int masaid, int kullaniciid, String siparisDurumu) {
		super();
		this.siparisid = siparisid;
		this.masaid = masaid;
		this.kullaniciid = kullaniciid;
		this.siparisDurumu = siparisDurumu;
	}
	public siparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
