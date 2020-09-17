package tr.com.siparis.sistemi.web.model;

public class WebSiparisModel {

	public String siparisId;
	public String masaAdi;
	public String corbaAdi;
	public String yemekAdi;
	public String salataAdi;
	public String tatliAdi;
	public String siparisDurumu;
	
	public String getSiparisId() {
		return siparisId;
	}
	public void setSiparisId(String siparisId) {
		this.siparisId = siparisId;
	}
	public String getMasaAdi() {
		return masaAdi;
	}
	public void setMasaAdi(String masaAdi) {
		this.masaAdi = masaAdi;
	}
	public String getCorbaAdi() {
		return corbaAdi;
	}
	public void setCorbaAdi(String corbaAdi) {
		this.corbaAdi = corbaAdi;
	}
	public String getYemekAdi() {
		return yemekAdi;
	}
	public void setYemekAdi(String yemekAdi) {
		this.yemekAdi = yemekAdi;
	}
	public String getSalataAdi() {
		return salataAdi;
	}
	public void setSalataAdi(String salataAdi) {
		this.salataAdi = salataAdi;
	}
	public String getSiparisDurumu() {
		return siparisDurumu;
	}
	public void setSiparisDurumu(String siparisDurumu) {
		this.siparisDurumu = siparisDurumu;
	}
	public String getTatliAdi() {
		return tatliAdi;
	}
	public void setTatliAdi(String tatliAdi) {
		this.tatliAdi = tatliAdi;
	}
	public WebSiparisModel(String siparisId, String masaAdi, String corbaAdi, String yemekAdi, String salataAdi,
			String tatliAdi, String siparisDurumu) {
		super();
		this.siparisId = siparisId;
		this.masaAdi = masaAdi;
		this.corbaAdi = corbaAdi;
		this.yemekAdi = yemekAdi;
		this.salataAdi = salataAdi;
		this.tatliAdi = tatliAdi;
		this.siparisDurumu = siparisDurumu;
	}
	public WebSiparisModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WebSiparisModel [siparisId=" + siparisId + ", masaAdi=" + masaAdi + ", corbaAdi=" + corbaAdi
				+ ", yemekAdi=" + yemekAdi + ", salataAdi=" + salataAdi + ", tatliAdi=" + tatliAdi + ", siparisDurumu="
				+ siparisDurumu + "]";
	}

	
}
