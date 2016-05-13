package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PostitPostIt  {
  
  @SerializedName("api_key")
  private String apiKey = null;
  @SerializedName("event_time")
  private Long eventTime = null;
  @SerializedName("payload")
  private String payload = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getApiKey() {
    return apiKey;
  }
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Long getEventTime() {
    return eventTime;
  }
  public void setEventTime(Long eventTime) {
    this.eventTime = eventTime;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getPayload() {
    return payload;
  }
  public void setPayload(String payload) {
    this.payload = payload;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostitPostIt {\n");
    
    sb.append("  apiKey: ").append(apiKey).append("\n");
    sb.append("  eventTime: ").append(eventTime).append("\n");
    sb.append("  payload: ").append(payload).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
