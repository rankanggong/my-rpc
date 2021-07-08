package com.example.rpc.client;

import com.example.rpc.entity.RpcRequest;
import com.example.rpc.entity.RpcResponse;
import java.net.InetSocketAddress;

public interface Client {
    RpcResponse send(RpcRequest request);

    void connect(InetSocketAddress inetSocketAddress);

    InetSocketAddress getInetSocketAddress();

    void close();
}
