package com.example.rpc.netty.handler;

import com.example.rpc.entity.RpcRequest;
import com.example.rpc.entity.RpcResponse;
import com.example.rpc.coder.RpcDecoder;
import com.example.rpc.coder.RpcEncoder;
import com.example.rpc.serialization.JsonSerialization;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerInitializer extends  ChannelInitializer<SocketChannel> {
    @Autowired
    private ServerHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4));
        pipeline.addLast(new RpcEncoder(RpcResponse.class, new JsonSerialization()));
        pipeline.addLast(new RpcDecoder(RpcRequest.class, new JsonSerialization()));
        pipeline.addLast(serverHandler);
    }
}
