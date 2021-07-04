package protocol.coder;

import protocol.serialization.serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class RpcDecoder extends ByteToMessageDecoder{
    private Class<?> clz;
    private serialization serial;

    public RpcDecoder(Class<?> clz, serialization serial){
        this.clz = clz;
        this.serial = serial;
    }

    @Override
    protected void decode(ChannelHandlerContext context, ByteBuf in, List<Object> out) throws Exception{
        if(in.readableBytes() < 4){
            return;
        }

        in.markReaderIndex();
        int dataLength = in.readInt();
        if(in.readableBytes() < dataLength){
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);

        Object obj = serial.deserialize(data, clz);
        out.add(obj);
    }
}
