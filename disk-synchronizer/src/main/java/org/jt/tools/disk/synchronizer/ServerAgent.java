package org.jt.tools.disk.synchronizer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerAgent {
	private static Log log = LogFactory.getLog(ServerAgent.class);
	private int counter;
	public static String initDir; // 保存服务器线程运行时所在的工作目录
    

	public ServerAgent(int port,String rootDir) {
		int i = 0;
		ServerSocket s =  null;
		try {
			s = new ServerSocket(port);
			for (;;) {
				// 接受客户端请求
				Socket incoming = s.accept();
//				BufferedReader in = new BufferedReader(new InputStreamReader(
//						incoming.getInputStream()));
				PrintWriter out = new PrintWriter(incoming.getOutputStream(),
						true);// 文本文本输出流
				out.println("220 准备为您服务" + ",你是当前第  " + counter + " 个登陆者!");// 命令正确的提示

				// 创建服务线程
				UploadHandler h = new UploadHandler(incoming, i,rootDir);
				h.start();
				
				counter++;
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( s!= null)  try {s.close();} catch(Exception e) {}
		}

	}

	
	public static void main(String[] args) {
		if (args.length != 0) {
			initDir = args[0];
		} else {
			initDir = "C://";
		}
		
		int port = 21000;
		if (args.length > 1) {
			port = Integer.parseInt(args[1]);
		} 
		
		
		log.info("the rootPath:" + initDir + ",listenning on port:" + port);
		
		new ServerAgent(port,initDir);

	}

}
