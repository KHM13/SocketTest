package nurier;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
    	
    	ByteBuf byteBuf = (ByteBuf) msg;
    	String result = byteBuf.toString(io.netty.util.CharsetUtil.UTF_8);

    	System.out.println(result);
    	returnResult(result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
    
    public String returnResult(String a) {
    	return a;
    }
}