package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryDTO {
	
	   private String id;
	   private Double lat;
	    private Double lnt;
	    private String date;


}
