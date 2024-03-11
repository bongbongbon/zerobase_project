package dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WifiDTO {

		@SerializedName("list_total_count")
	    private int totalcount;

	    @SerializedName("RESULT")
	    private ResultDTO result;

	    @SerializedName("row")
	    private List<RowDTO> wifiDetails;
}
