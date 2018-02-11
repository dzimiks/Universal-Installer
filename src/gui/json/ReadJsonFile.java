package gui.json;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import gui.model.CopySoftware;

@SuppressWarnings("unused")
public class ReadJsonFile {

	public ReadJsonFile(){
		super();
	}
	/*
	 * Metoda uzima json fajl koji korisnik bira
	 * Cita taj json i braca softver
	 * */
	public static CopySoftware readJsonFile(File file) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("Reading from " + file);
		CopySoftware copySoftware= mapper.readValue(file, CopySoftware.class);
		
		return copySoftware;
	}
}
