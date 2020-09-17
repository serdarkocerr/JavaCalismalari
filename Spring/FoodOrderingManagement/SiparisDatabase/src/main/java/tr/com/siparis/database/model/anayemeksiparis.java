package tr.com.siparis.database.model;

import javax.persistence.Entity;

//@Entity
public class anayemeksiparis {

	private int siparisid;
	private int anayemekid;
	public int getSiparisid() {
		return siparisid;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	public int getAnayemekid() {
		return anayemekid;
	}
	public void setAnayemekid(int anayemekid) {
		this.anayemekid = anayemekid;
	}
	@Override
	public String toString() {
		return "anayemeksiparis [siparisid=" + siparisid + ", anayemekid=" + anayemekid + "]";
	}
	public anayemeksiparis(int siparisid, int anayemekid) {
		super();
		this.siparisid = siparisid;
		this.anayemekid = anayemekid;
	}
	public anayemeksiparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
