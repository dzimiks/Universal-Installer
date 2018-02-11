package gui.model;

import java.util.ArrayList;

import gui.model.tree.Node;

public class CopyModule {
	private String name;
	private String lockPath;
	private ArrayList<CopyParameter> parameters = new ArrayList<>();
	
	public CopyModule(){
		
	}
	
	public CopyModule(Module m){
		this.name = m.getName();
		this.lockPath = m.getLocalPath();
		for(Node p: m.getChildren()){
			parameters.add(new CopyParameter((Parameter)p));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CopyParameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<CopyParameter> parameters) {
		this.parameters = parameters;
	}

	public String getLockPath() {
		return lockPath;
	}
	
}
