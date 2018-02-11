package gui.model;

import gui.panels.custom.GlavniPanel;

public class CopyParameter {
	private String name;
	private String filePath;
	private String value;
	private Type type;

	
	public CopyParameter(){
		
	}
	
	public CopyParameter(Parameter p){
		this.name = p.getName();
		this.type = p.getType();
		this.filePath = p.getFilePath();
		this.value = p.getValue();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getfilePath() {
		return filePath;
	}

	public void setfilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}
