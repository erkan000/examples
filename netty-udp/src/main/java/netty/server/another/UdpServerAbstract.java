package netty.server.another;

import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

public abstract class UdpServerAbstract<M> extends ChannelInitializer<NioDatagramChannel> {

	private static final int EVENT_LOOP_THREAD_NUMBER = 1;
	private EventLoopGroup workerGroup;
	protected final Logger LOGGER = LogManager.getLogger(UdpServerAbstract.class);

	protected Channel channel;

	protected UdpServerAbstract() {
	}

	public void write(M msg) {
		if (channel != null && channel.isActive() && channel.isWritable()) {
			channel.writeAndFlush(msg);
		}
	}

	public void connect(int port) {
		try {
			workerGroup = new NioEventLoopGroup(EVENT_LOOP_THREAD_NUMBER,
					new DefaultThreadFactory(this.getClass().getSimpleName() + " EventLoopGroup"));
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioDatagramChannel.class);
			bootstrap.option(ChannelOption.SO_BROADCAST, true);
			bootstrap.handler(this);

			channel = bootstrap.bind(new InetSocketAddress(port)).sync().channel();
		} catch (InterruptedException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.error(cause.getLocalizedMessage(), cause);
		super.exceptionCaught(ctx, cause);
	}

	@Override
	protected void initChannel(NioDatagramChannel ch) throws Exception {
		addHandlersToPipeline(ch);
	}

	public void disconnect() {
		if (workerGroup != null) {
			try {
				workerGroup.shutdownGracefully().await();
			} catch (InterruptedException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
				Thread.currentThread().interrupt();
			}
		}
	}

	public boolean isConnected() {
		return channel.isActive();
	}

	protected abstract void addHandlersToPipeline(NioDatagramChannel ch);
}
