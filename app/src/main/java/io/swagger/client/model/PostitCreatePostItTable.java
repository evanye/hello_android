package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PostitCreatePostItTable  {
  
  @SerializedName("path")
  private String path = null;
  @SerializedName("schema")
  private String schema = null;
  @SerializedName("shard_name")
  private String shardName = null;

  
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

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getShardName() {
    return shardName;
  }
  public void setShardName(String shardName) {
    this.shardName = shardName;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostitCreatePostItTable {\n");
    
    sb.append("  path: ").append(path).append("\n");
    sb.append("  schema: ").append(schema).append("\n");
    sb.append("  shardName: ").append(shardName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
