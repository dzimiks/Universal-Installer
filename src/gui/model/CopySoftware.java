
package gui.model;

import java.util.ArrayList;

import gui.model.tree.Node;

public class CopySoftware {
	private String name;
	private ArrayList<CopyModule> modules = new ArrayList<>();
	
	public CopySoftware(){
		
	}
	
	public CopySoftware(Software sw){
		this.name = sw.getName();
		
		for(Node m: sw.getChildren()){
			modules.add(new CopyModule((Module)m));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CopyModule> getModules() {
		return modules;
	}

	public void setModules(ArrayList<CopyModule> modules) {
		this.modules = modules;
	}

	
	
}
