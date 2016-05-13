package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import io.swagger.client.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("PostitCreatePostItTable".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitCreatePostItTable>>(){}.getType();
    }
    
    if ("PostitCreatePostItTableResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitCreatePostItTableResponse>>(){}.getType();
    }
    
    if ("PostitDeleteApiKey".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitDeleteApiKey>>(){}.getType();
    }
    
    if ("PostitDeleteApiKeyResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitDeleteApiKeyResponse>>(){}.getType();
    }
    
    if ("PostitPostIt".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitPostIt>>(){}.getType();
    }
    
    if ("PostitPostItResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitPostItResponse>>(){}.getType();
    }
    
    if ("PostitRegenerateApiKey".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitRegenerateApiKey>>(){}.getType();
    }
    
    if ("PostitRegenerateApiKeyResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitRegenerateApiKeyResponse>>(){}.getType();
    }
    
    if ("PostitUpdatePostItTable".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitUpdatePostItTable>>(){}.getType();
    }
    
    if ("PostitUpdatePostItTableResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<PostitUpdatePostItTableResponse>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("PostitCreatePostItTable".equalsIgnoreCase(className)) {
      return new TypeToken<PostitCreatePostItTable>(){}.getType();
    }
    
    if ("PostitCreatePostItTableResponse".equalsIgnoreCase(className)) {
      return new TypeToken<PostitCreatePostItTableResponse>(){}.getType();
    }
    
    if ("PostitDeleteApiKey".equalsIgnoreCase(className)) {
      return new TypeToken<PostitDeleteApiKey>(){}.getType();
    }
    
    if ("PostitDeleteApiKeyResponse".equalsIgnoreCase(className)) {
      return new TypeToken<PostitDeleteApiKeyResponse>(){}.getType();
    }
    
    if ("PostitPostIt".equalsIgnoreCase(className)) {
      return new TypeToken<PostitPostIt>(){}.getType();
    }
    
    if ("PostitPostItResponse".equalsIgnoreCase(className)) {
      return new TypeToken<PostitPostItResponse>(){}.getType();
    }
    
    if ("PostitRegenerateApiKey".equalsIgnoreCase(className)) {
      return new TypeToken<PostitRegenerateApiKey>(){}.getType();
    }
    
    if ("PostitRegenerateApiKeyResponse".equalsIgnoreCase(className)) {
      return new TypeToken<PostitRegenerateApiKeyResponse>(){}.getType();
    }
    
    if ("PostitUpdatePostItTable".equalsIgnoreCase(className)) {
      return new TypeToken<PostitUpdatePostItTable>(){}.getType();
    }
    
    if ("PostitUpdatePostItTableResponse".equalsIgnoreCase(className)) {
      return new TypeToken<PostitUpdatePostItTableResponse>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
