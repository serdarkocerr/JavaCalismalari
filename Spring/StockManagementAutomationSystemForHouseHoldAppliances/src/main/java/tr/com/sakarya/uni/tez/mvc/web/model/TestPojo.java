package tr.com.sakarya.uni.tez.mvc.web.model;

public class TestPojo {

	public String pName;
	public String lName;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestPojo other = (TestPojo) obj;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TestPojo [pName=" + pName + ", lName=" + lName + "]";
	}
	
	
}
