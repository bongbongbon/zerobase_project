package api;

import java.net.URL;

import dto.WifiDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiJsonService {
	
	ApiParser parser = new ApiParser();
	
	
	public WifiDTO requestApi(int start, int end) throws Exception {
		
		OkHttpClient client = new OkHttpClient();
		
		 String url = "http://openapi.seoul.go.kr:8088/6566634150727564363264436a4d79/json/TbPublicWifiInfo/"
	                + start + "/" + end;

	        URL urlRequest = new URL(url); 
	        Request request = new Request.Builder() 
	                .url(urlRequest)
	                .get()
	                .build();

	        Response response = client.newCall(request).execute();
	        String json = response.body().string(); 
	        
	        return parser.parse(json); 
	        
	}
	
	
	
    public int getTotalPageCount() throws Exception {     
        WifiDTO dto = requestApi(0, 1);
        int totalCount = dto.getTotalcount();  


        int count = (totalCount / 1000); 

        if ((totalCount % 1000) > 0) { 
            count++;
        }

        return count;
    }

    

    public int getTotalCount() throws Exception {  
        WifiDTO dto = requestApi(0, 1); 
        int totalCount = dto.getTotalcount();  

        return totalCount;
    }
	

}
