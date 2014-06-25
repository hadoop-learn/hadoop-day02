package rpc;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.VersionedProtocol;

public class MyClient {
	public static void main(String[] args) throws Exception{
		/** 构造一个客户端的代理对象。 Construct a client-side proxy object that implements the named protocol,
		   * talking to a server at the named address. */

	final MyBizable proxy = (MyBizable)RPC.waitForProxy(MyBizable.class,
			      MyBizable.VERSION,
			      new InetSocketAddress(MyServer.SERVER_ADDRESS,MyServer.SERVER_PORT),
			      new Configuration());
	final String result = proxy.hello("world");
	System.out.println("客户端调用结果："+result);
	RPC.stopProxy(proxy);
	}
}
