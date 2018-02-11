package gui.panels.custom;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GlavniPanelToString {
	
	private ArrayList<CustomPanelJSONModel> lista;
	
	public GlavniPanelToString(GlavniPanel panel) {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<>();
		dodajUListu(panel);
		
	}
	
	private void dodajUListu(GlavniPanel panel){
		for(int i = 0; i < panel.getComponentCount(); i++){
			
			if(panel.getComponent(i).isVisible()){
				if(panel.getComponent(i) instanceof MojCheckBox){
					
					lista.add(new CustomPanelJSONModel(Addable.CHECKBOX, ((MojCheckBox)panel.getComponent(i)).getCb().getText()));
					
				}else if(panel.getComponent(i) instanceof MojTextField){
					
					lista.add(new CustomPanelJSONModel(Addable.TEXTFIELD, ((MojTextField)panel.getComponent(i)).getTf().getText()));
					
				}else if(panel.getComponent(i) instanceof MojLabel){
					
					lista.add(new CustomPanelJSONModel(Addable.LABEL, ((MojLabel)panel.getComponent(i)).getJl().getText()));
					
				}
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		for(CustomPanelJSONModel customPanelJSONModel: lista){
			sb.append(customPanelJSONModel);
			sb.append("-");
		}
		if(!lista.isEmpty())
			sb.deleteCharAt(sb.lastIndexOf("-"));
		
		return sb.toString();
	}
}
