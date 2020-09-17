package tr.com.siparis.database.model;

public class kullanici {

	private int kullaniciid;
	private String kullaniciadi;
	private String kullanicisoyadi;
	private int kullaniciturid;
	private String sifre;
	public int getKullaniciid() {
		return kullaniciid;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public String getKullaniciadi() {
		return kullaniciadi;
	}
	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}
	public String getKullanicisoyadi() {
		return kullanicisoyadi;
	}
	public void setKullanicisoyadi(String kullanicisoyadi) {
		this.kullanicisoyadi = kullanicisoyadi;
	}
	public int getKullaniciturid() {
		return kullaniciturid;
	}
	public void setKullaniciturid(int kullaniciturid) {
		this.kullaniciturid = kullaniciturid;
	}
	public kullanici() {
		super();
		// TODO Auto-generated constructor stub
	}
	public kullanici(int kullaniciid, String kullaniciadi, String kullanicisoyadi, int kullaniciturid, String sifre) {
		super();
		this.kullaniciid = kullaniciid;
		this.kullaniciadi = kullaniciadi;
		this.kullanicisoyadi = kullanicisoyadi;
		this.kullaniciturid = kullaniciturid;
		this.sifre = sifre;
	}
	@Override
	public String toString() {
		return "kullanici [kullaniciid=" + kullaniciid + ", kullaniciadi=" + kullaniciadi + ", kullanicisoyadi="
				+ kullanicisoyadi + ", kullaniciturid=" + kullaniciturid + ", sifre=" + sifre + "]";
	}
	
}
