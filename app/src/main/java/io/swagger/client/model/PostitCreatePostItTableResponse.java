package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PostitCreatePostItTableResponse  {
  
  @SerializedName("api_key")
  private String apiKey = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getApiKey() {
    return apiKey;
  }
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostitCreatePostItTableResponse {\n");
    
    sb.append("  apiKey: ").append(apiKey).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
