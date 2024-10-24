package nurier;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(new ClientHandler())
        			.addLast(new LineBasedFrameDecoder(65536))
        			.addLast(new StringDecoder())
        			.addLast(new StringEncoder());
        
    }
}