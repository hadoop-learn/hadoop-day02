package rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class MyServer {
	public static String SERVER_ADDRESS="localhost";
	public static int SERVER_PORT=12345;
	/** 构造一个 RPC server.
     * @param instance 实例中的方法会被客户端调用
     * @param conf the configuration to use
     * @param bindAddress 绑定的这个地址用于监听连接的到来
     * @param port 绑定的这个端口用于监听连接的到来
     * @param numHandlers the number of method handler threads to run
     * @param verbose whether each call should be logged
     */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		final Server server = RPC.getServer(new MyBiz(), SERVER_ADDRESS, SERVER_PORT, new Configuration());
		server.start();
	}

}
