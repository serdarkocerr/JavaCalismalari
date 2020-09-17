package tr.com.siparis.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class anayemek {
	@Id
	private int anayemekid;
	private String anayemekadi;
	public int getAnayemekid() {
		return anayemekid;
	}
	@Override
	public String toString() {
		return "anayemek [anayemekid=" + anayemekid + ", anayemekadi=" + anayemekadi + "]";
	}
	public void setAnayemekid(int anayemekid) {
		this.anayemekid = anayemekid;
	}
	public String getAnayemekadi() {
		return anayemekadi;
	}
	public void setAnayemekadi(String anayemekadi) {
		this.anayemekadi = anayemekadi;
	}
	public anayemek(int anayemekid, String anayemekadi) {
		super();
		this.anayemekid = anayemekid;
		this.anayemekadi = anayemekadi;
	}
	public anayemek() {
	}
	
	
}
