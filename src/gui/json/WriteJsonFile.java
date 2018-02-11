package gui.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gui.model.CopySoftware;
import gui.model.Module;
import gui.model.Parameter;
import gui.model.Software;
import gui.model.tree.Node;


@SuppressWarnings("unused")
public class WriteJsonFile {
	
	public WriteJsonFile(){
		super(); 
	}
	
	/*
	 * Metoda uzima obelezeni softver, koji se kastuje u copySoftver 
	 * j pravi json fajl od njega
	 * */
	public static void writeJson(CopySoftware copySoftware) throws JsonGenerationException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("Resources",copySoftware.getName()+".json");
		
		System.out.println("Writing software in " + file.toString());
			
		mapper.writeValue(file, copySoftware);
	}

}
