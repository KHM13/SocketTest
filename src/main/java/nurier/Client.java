package nurier;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

public class Client {
    private static final int SERVER_PORT = 8000;
    private final String host;
    private final int port;

    private Channel serverChannel;
    private EventLoopGroup eventLoopGroup;
    
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws InterruptedException {
        eventLoopGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("client"));

        Bootstrap bootstrap = new Bootstrap().group(eventLoopGroup);

        bootstrap.remoteAddress(new InetSocketAddress(host, port));
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ClientInitializer());
        
        serverChannel = bootstrap.connect().sync().channel();
    }

    private void start() throws Exception {
        ChannelFuture future;

        // 사용자 입력
        String message = "{" +
                "\"EBNK_MED_DSC\":\"091\"," +
                "\"RMS_SVC_C\":\"SVC_03\"," +
                "\"Amount\":1500000," +
                "\"LS_TRDT\":\"2023-11-30\"," +
                "\"sm_mobileAPSsid\":\"SKT\"," +
                "\"cus_birth\":1948," +
                "\"eventType\":3," +
                "\"country\":\"CN\"," +
                "\"key\":\"구형모\"," +
                "\"securityMediaType\":1" +
                "}";
        // Server로 전송
        future = serverChannel.writeAndFlush(message);
        serverChannel.closeFuture().sync();
        if(future != null){
            future.sync();
        }
    }

    public void close() {
        eventLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client("192.168.0.121", SERVER_PORT);
        
        long start = System.nanoTime();
		int test_num = 1000;
        
		for (int i = 0; i < test_num; i++) {

	        try {
	            client.connect();
	            client.start(); 
	        } finally {
	            client.close();
	        }
		}
		
        
        long end = System.nanoTime();
		
		long duration = TimeUnit.NANOSECONDS.toSeconds(end - start);
        int tps = (int) (test_num / duration);

        System.out.println("TPS: " + tps);
    }

}
