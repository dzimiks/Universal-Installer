package gui.panels.custom;

public class CustomPanelJSONModel {

	private Addable tip;
	private String vrednost;

	public CustomPanelJSONModel(Addable tip, String vrednost) {
		// TODO Auto-generated constructor stub
		this.tip = tip;
		this.vrednost = vrednost;

	}

	public Addable getTip() {
		return tip;
	}

	public void setTip(Addable tip) {
		this.tip = tip;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	
	@Override
	public String toString() {		
		return tip.toString() + "~" + vrednost;
	}

}
