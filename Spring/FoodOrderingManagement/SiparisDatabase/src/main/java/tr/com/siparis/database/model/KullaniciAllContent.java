package tr.com.siparis.database.model;

public class KullaniciAllContent {

	public int kullaniciId;
	public String kullaniciAdi;
	public String kullaniciSoyadi;
	public int kullaniciTurId;
	public String kullaniciTurAdi;
	public String kullaniciSifre;
	@Override
	public String toString() {
		return "db_KullaniciAllContent [kullaniciId=" + kullaniciId + ", kullaniciAdi=" + kullaniciAdi
				+ ", kullaniciSoyadi=" + kullaniciSoyadi + ", kullaniciTurId=" + kullaniciTurId + ", kullaniciTurAdi="
				+ kullaniciTurAdi + ", kullaniciSifre=" + kullaniciSifre + "]";
	}
	public int getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getKullaniciSoyadi() {
		return kullaniciSoyadi;
	}
	public void setKullaniciSoyadi(String kullaniciSoyadi) {
		this.kullaniciSoyadi = kullaniciSoyadi;
	}
	public int getKullaniciTurId() {
		return kullaniciTurId;
	}
	public void setKullaniciTurId(int kullaniciTurId) {
		this.kullaniciTurId = kullaniciTurId;
	}
	public String getKullaniciTurAdi() {
		return kullaniciTurAdi;
	}
	public void setKullaniciTurAdi(String kullaniciTurAdi) {
		this.kullaniciTurAdi = kullaniciTurAdi;
	}
	public String getKullaniciSifre() {
		return kullaniciSifre;
	}
	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	public KullaniciAllContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param kullaniciId
	 * @param kullaniciAdi
	 * @param kullaniciSoyadi
	 * @param kullaniciTurId
	 * @param kullaniciTurAdi
	 * @param kullaniciSifre
	 */
	public KullaniciAllContent(int kullaniciId, String kullaniciAdi, String kullaniciSoyadi, int kullaniciTurId,
			String kullaniciTurAdi, String kullaniciSifre) {
		super();
		this.kullaniciId = kullaniciId;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciSoyadi = kullaniciSoyadi;
		this.kullaniciTurId = kullaniciTurId;
		this.kullaniciTurAdi = kullaniciTurAdi;
		this.kullaniciSifre = kullaniciSifre;
	}
}
