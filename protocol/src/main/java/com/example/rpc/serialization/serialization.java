package com.example.rpc.serialization;

//@SPI("fastjoson")
public interface serialization {
    <T> byte[] serialize(T obj) throws Exception;
    <T> T deserialize(byte[] data, Class<T> cls) throws Exception;
}