package com.example.rpc.api;

import com.example.rpc.annotation.RpcInterface;

@RpcInterface
public interface HelloService {
    String sayHello(String name);
}
