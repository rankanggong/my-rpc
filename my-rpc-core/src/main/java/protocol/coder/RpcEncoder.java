package protocol.coder;

import io.netty.channel.ChannelHandlerContext;
import protocol.serialization.serialization;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.buffer.ByteBuf;

public class RpcEncoder extends MessageToByteEncoder{
    private Class<?> cls;
    private serialization Serialization;

    public RpcEncoder(Class<?> cls, serialization Serialization){
        this.cls = cls;
        this.Serialization = Serialization;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception{
        if(cls != null) {
            byte[] bytes = Serialization.serialize(msg);
            out.writeInt(bytes.length);
            out.writeBytes(bytes);
        }
    }

}
