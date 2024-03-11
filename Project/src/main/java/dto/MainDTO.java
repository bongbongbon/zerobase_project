package dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class MainDTO {
	
	 @SerializedName("TbPublicWifiInfo")
    private WifiDTO tbPublicWifiInfo;


}
