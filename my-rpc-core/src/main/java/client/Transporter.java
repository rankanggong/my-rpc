package client;

import protocol.entity.RpcResponse;
import protocol.entity.RpcRequest;
import client.netty.NettyClient;

public class Transporter {
    public static RpcResponse send(RpcRequest request){

        NettyClient nettyClient = new NettyClient("127.0.0.1", 8080);

        nettyClient.connect(nettyClient.getInetSocketAddress());

        RpcResponse send = nettyClient.send(request);

        return send;

    }
}
