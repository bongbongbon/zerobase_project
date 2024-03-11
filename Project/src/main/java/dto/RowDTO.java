package dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RowDTO {

	   @SerializedName("X_SWIFI_MGR_NO")
	    private String MGR_NO;
	    @SerializedName("X_SWIFI_WRDOFC")
	    private String WRDOFC;
	    @SerializedName("X_SWIFI_MAIN_NM")
	    private String MAIN_NM;


	    @SerializedName("X_SWIFI_ADRES1")
	    private String ADRES1;
	    @SerializedName("X_SWIFI_ADRES2")
	    private String ADRES2;
	    @SerializedName("X_SWIFI_INSTL_FLOOR")
	    private String FLOOR;


	    @SerializedName("X_SWIFI_INSTL_TY")
	    private String INSTL_TY;
	    @SerializedName("X_SWIFI_INSTL_MBY")
	    private String INSTL_MBY;
	    @SerializedName("X_SWIFI_SVC_SE")
	    private String SVC_SE;


	    @SerializedName("X_SWIFI_CMCWR")
	    private String CMCWR;
	    @SerializedName("X_SWIFI_CNSTC_YEAR")
	    private String CNSTC_YEAR;
	    @SerializedName("X_SWIFI_INOUT_DOOR")
	    private String INOUT_DOOR;
	    @SerializedName("X_SWIFI_REMARS3")
	    private String REMARS3;


	    @SerializedName("LAT")
	    private String LAT;
	    @SerializedName("LNT")
	    private String LNT;
	    @SerializedName("WORK_DTTM")
	    private String WORK_DTTM;
	
}
