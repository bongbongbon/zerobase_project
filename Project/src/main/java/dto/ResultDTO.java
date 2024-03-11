package dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ResultDTO {

    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;
}
