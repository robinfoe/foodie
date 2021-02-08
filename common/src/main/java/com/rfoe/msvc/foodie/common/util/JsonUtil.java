package com.rfoe.msvc.foodie.common.util;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonUtil {

    private static Optional<JsonUtil> instance = Optional.empty();


    private ObjectMapper objectMapper;

    private JsonUtil(){
        /** ENSURE SINGLETON**/
        objectMapper = JsonMapper.builder().build(); 
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
  
    public static JsonUtil getInstance(){
        if(JsonUtil.instance.isEmpty()){
            JsonUtil.instance = Optional.of(new JsonUtil());
        }
        return JsonUtil.instance.get();
    }

    public ObjectMapper getMapper(){
        return this.objectMapper;
    }
    
}
