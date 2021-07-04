package client.client;

import protocol.entity.RpcRequest;
import protocol.entity.RpcResponse;
import java.net.InetSocketAddress;

public interface Client {
    RpcResponse send(RpcRequest request);

    void connect(InetSocketAddress inetSocketAddress);

    InetSocketAddress getInetSocketAddress();

    void close();
}
