package com.example.rpc;

import com.example.rpc.entity.RpcResponse;
import com.example.rpc.entity.RpcRequest;
import com.example.rpc.netty.NettyClient;

public class Transporter {
    public static RpcResponse send(RpcRequest request){

        NettyClient nettyClient = new NettyClient("127.0.0.1", 8080);

        nettyClient.connect(nettyClient.getInetSocketAddress());

        RpcResponse send = nettyClient.send(request);

        return send;

    }
}
