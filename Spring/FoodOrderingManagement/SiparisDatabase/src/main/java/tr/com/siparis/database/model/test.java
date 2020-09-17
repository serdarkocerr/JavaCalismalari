package tr.com.siparis.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class test {

	@Id
	private int testid;
	private String testadi;
	public int getTestid() {
		return testid;
	}
	
	
	public test() {
	}


	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getTestadi() {
		return testadi;
	}
	public void setTestadi(String testadi) {
		this.testadi = testadi;
	}
	public test(int testid, String testadi) {
		super();
		this.testid = testid;
		this.testadi = testadi;
	}
	@Override
	public String toString() {
		return "test [testid=" + testid + ", testadi=" + testadi + "]";
	}
	
}
