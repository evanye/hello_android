package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PostitUpdatePostItTable  {
  
  @SerializedName("api_key")
  private String apiKey = null;
  @SerializedName("path")
  private String path = null;
  @SerializedName("schema")
  private String schema = null;

  
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
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSchema() {
    return schema;
  }
  public void setSchema(String schema) {
    this.schema = schema;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostitUpdatePostItTable {\n");
    
    sb.append("  apiKey: ").append(apiKey).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  schema: ").append(schema).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
