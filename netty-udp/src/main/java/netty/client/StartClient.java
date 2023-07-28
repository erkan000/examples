package netty.client;

import org.eclipse.jface.widgets.WidgetFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Log4J2LoggerFactory;

public class StartClient {

	public static void main(String[] args) {

		String host = "localhost";
		int port = 6671;
		EventLoopGroup workerGroup = null;
		// workerGroup asagidaki ikisiyle de olusturulabiliyor
		// java.util.concurrent.Executor
		// java.util.concurrent.ThreadFactory

		try {
			InternalLoggerFactory.setDefaultFactory(Log4J2LoggerFactory.INSTANCE);
			workerGroup = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioDatagramChannel.class);
			bootstrap.option(ChannelOption.SO_BROADCAST, true);
			bootstrap.handler(new ChannelInitializer<NioDatagramChannel>() {

				@Override
				public void initChannel(NioDatagramChannel ch) throws Exception {
					ch.pipeline().addLast(
							new ClientHandler());
				}
			});

			ChannelFuture f = bootstrap.connect(host, port).sync();

			ChannelFuture channelClosed = f.channel().closeFuture();
			channelClosed.addListener((s) -> System.out.println("Disconnected!"));

			Display display = new Display();
			Shell shell = new Shell(display);
			shell.setBounds(200, 200, 400, 400);
			shell.setText("Shell 1 Title");
			shell.setLayout(new GridLayout());

			WidgetFactory.button(SWT.PUSH).text("Button2").onSelect(e -> {
				f.channel().writeAndFlush(Unpooled.wrappedBuffer("aaaaaaaaaaa".getBytes()));
			}).create(shell);

			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workerGroup != null) {
				workerGroup.shutdownGracefully();
			}
		}


	}

}
