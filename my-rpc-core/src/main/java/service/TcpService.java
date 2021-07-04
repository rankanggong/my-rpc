package service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

@Data
@Component
public class TcpService {
    private final ServerBootstrap serverBootstrap;

    private final InetSocketAddress tcpPort;

    public TcpService(ServerBootstrap serverBootstrap, InetSocketAddress inetSocketAddress){
        this.serverBootstrap = serverBootstrap;
        this.tcpPort = inetSocketAddress;
    }

    private Channel channel;

    public void start() throws InterruptedException{
        channel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().channel();
    }

    @PreDestroy
    public void stop(){
        if(channel != null){
            channel.close();
            channel.parent().close();
        }
    }
}
