package com.example.rpc.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSerialization implements serialization{
    private ObjectMapper objectMapper;

    public JsonSerialization(){
        this.objectMapper = new ObjectMapper();
    }

    public <T> byte[] serialize(T object){
        try{
            return objectMapper.writeValueAsBytes(object);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    public <T> T deserialize(byte[] data, Class<T> clz) {
        try {
            return objectMapper.readValue(data,clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
