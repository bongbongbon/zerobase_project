package api;

import com.google.gson.Gson;

import dto.MainDTO;
import dto.WifiDTO;

public class ApiParser {
	
	
	private Gson gson = new Gson();
	
	public WifiDTO parse(String json) {
		
		try {
			MainDTO mainDTO = gson.fromJson(json, MainDTO.class);
			
			return mainDTO.getTbPublicWifiInfo();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
