package rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class MyServer {
	public static String SERVER_ADDRESS="localhost";
	public static int SERVER_PORT=12345;
	/** ����һ�� RPC server.
     * @param instance ʵ���еķ����ᱻ�ͻ��˵���
     * @param conf the configuration to use
     * @param bindAddress �󶨵������ַ���ڼ������ӵĵ���
     * @param port �󶨵�����˿����ڼ������ӵĵ���
     * @param numHandlers the number of method handler threads to run
     * @param verbose whether each call should be logged
     */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		final Server server = RPC.getServer(new MyBiz(), SERVER_ADDRESS, SERVER_PORT, new Configuration());
		server.start();
	}

}
