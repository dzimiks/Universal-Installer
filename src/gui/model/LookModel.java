package gui.model;

public class LookModel {
	
	private String naziv;
	private String vrednsot;
	private String path;
	
	public LookModel(String naslov, String vrednost, String path){
		this.naziv = naslov;
		this.vrednsot = vrednost;	
		this.path = path;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getVrednsot() {
		return vrednsot;
	}

	public void setVrednsot(String vrednsot) {
		this.vrednsot = vrednsot;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LookModel)) {
			return false;
		}
		LookModel other = (LookModel) obj;
		if (vrednsot == null) {
			if (other.vrednsot != null) {
				return false;
			}
		} else if (!vrednsot.equals(other.vrednsot)) {
			return false;
		}
		return true;
	}
	
	
	
	
}
