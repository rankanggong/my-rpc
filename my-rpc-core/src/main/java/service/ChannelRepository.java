package service;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelRepository {
    private Map<String, Channel> channelMap = new ConcurrentHashMap<String, Channel>();

    public ChannelRepository put(String key, Channel channel) {
        channelMap.put(key, channel);
        return this;
    }

    public Channel get(String key) {
        return channelMap.get(key);
    }

    public void remove(String key) {
        this.channelMap.remove(key);
    }

    public int size(){
        return channelMap.size();
    }
}
