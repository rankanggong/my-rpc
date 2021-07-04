package client.netty.handler;

import client.DefaultFuture;
import protocol.entity.RpcResponse;
import protocol.entity.RpcRequest;
import io.netty.channel.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler extends ChannelDuplexHandler{
    private final Map<String, DefaultFuture> futureMap = new ConcurrentHashMap<String, DefaultFuture>();


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if(msg instanceof RpcRequest){
            RpcRequest request = (RpcRequest) msg;
            if(futureMap.containsKey(request.getRequestId()))
                futureMap.put(request.getRequestId(),new DefaultFuture());
        }
        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof RpcResponse){
            RpcResponse response = (RpcResponse) msg;
            DefaultFuture defaultFuture = futureMap.get(response.getRequestId());
            defaultFuture.setResponse(response);
        }
        super.channelRead(ctx, msg);
    }

    public RpcResponse getRpcResponse(String requestId){

        try {
            DefaultFuture defaultFuture = futureMap.get(requestId);
            return defaultFuture.getResponse(10);
        }finally {
            futureMap.remove(requestId);
        }


    }
}
