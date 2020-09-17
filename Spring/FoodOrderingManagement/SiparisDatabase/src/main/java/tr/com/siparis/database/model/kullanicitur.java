package tr.com.siparis.database.model;

public class kullanicitur {

	private int kullaniciturid;
	private String kullanicituradi;
	public int getKullaniciturid() {
		return kullaniciturid;
	}
	public void setKullaniciturid(int kullaniciturid) {
		this.kullaniciturid = kullaniciturid;
	}
	public String getKullanicituradi() {
		return kullanicituradi;
	}
	public void setKullanicituradi(String kullanicituradi) {
		this.kullanicituradi = kullanicituradi;
	}
	@Override
	public String toString() {
		return "kullanicitur [kullaniciturid=" + kullaniciturid + ", kullanicituradi=" + kullanicituradi + "]";
	}
	public kullanicitur(int kullaniciturid, String kullanicituradi) {
		super();
		this.kullaniciturid = kullaniciturid;
		this.kullanicituradi = kullanicituradi;
	}
	public kullanicitur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
