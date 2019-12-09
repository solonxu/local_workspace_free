package org.jt.tools.disk.synchronizer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Client {
	
	private static Log log = LogFactory.getLog(Client.class);
	
	private static String ROOT_DIR ="Users/solonxu/projects/learning/copy-util/FTPServer";
	
	public static void main(String args[]) {
		
		String remoteHost = args[0];
		int remotePort = Integer.parseInt(args[1]);
		ServerSocket serverSocket = null;
	    Socket dataSocket = null;
	    BufferedOutputStream fout = null;
	    BufferedInputStream dataInput  = null;
	    
	    System.out.println("Going to connect to " + remoteHost +" ,port:" + remotePort);
	    
	    try {
		    dataSocket = new Socket(remoteHost,remotePort,InetAddress.getLocalHost(),21001);
            fout = new BufferedOutputStream(dataSocket.getOutputStream());
            dataInput = new BufferedInputStream(dataSocket.getInputStream());
          
            BufferedReader br = new BufferedReader(new InputStreamReader(dataInput));
            PrintStream ps = new PrintStream(fout,true);
            int tempPort = 30012;
             serverSocket =new ServerSocket(tempPort);
            System.out.println(br.readLine());
         
            File file = new File("/Users/solonxu/projects/learning/copy-util/FTPServer/src");
            
            sendFile(br,ps,file,serverSocket);
          
		} catch (Exception e) {
	        e.printStackTrace();
		} finally {
          if (dataInput != null ) try {dataInput.close();} catch (Exception e) {}
          if (fout != null ) try {fout.close();} catch (Exception e) {}
          if (dataSocket != null ) try {dataSocket.close();} catch (Exception e) {}
          if (serverSocket != null ) try {serverSocket.close();} catch (Exception e) {}
          
          
		}
	}
	
	private static boolean sendFile(BufferedReader br,PrintStream ps ,File file,ServerSocket s)  {
		try {
		if (file.isDirectory()) {
			for (File subFile : file.listFiles()) {
				sendFile(br,ps,subFile,s);
			}
		} else {
			if (file.isFile()) {
			
			 long now = System.currentTimeMillis();
	            FileSender fileSender = new FileSender(file,s);
	            fileSender.start();
	           log.info("file sender start for :" + file);
	            
	            String serverName =InetAddress.getLocalHost().getHostAddress();
	             
	            
	            String cmd   =String.format("%s %s,%d,%s", "Upload " ,serverName,s.getLocalPort() ,file.getAbsolutePath().replace(ROOT_DIR,""));
	            
	           
	            
	            ps.println(cmd);
	            fileSender.join();
	            
	            System.out.println("already send the cmd to" + cmd);
	            System.out.println(br.readLine());
	            System.out.println("it take " + (System.currentTimeMillis() - now) + " ms to transfer file");
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}

class FileSender extends Thread {
	private static Log log = LogFactory.getLog(Client.class);
  
    File file = null;
    private static int BUFFER_SIZE= 1024 * 4;
    ServerSocket s =  null;
	
    public FileSender(File file,ServerSocket s) {
	
		this.file = file;
	    this.s = s;
		
	}
	
	public void run() {
	   
	    BufferedOutputStream fout = null;
        BufferedInputStream dataInput = null;
        Socket incoming  = null;
	    try {
		  	 incoming = s.accept();
		
			log.info("Got the connection");
		    fout = new BufferedOutputStream(incoming.getOutputStream());
	        dataInput = new BufferedInputStream(new FileInputStream(file));
	        byte[] buf = new byte[BUFFER_SIZE];
	       
	        
	        int l = 0;
	        while ((l = dataInput.read(buf,0,BUFFER_SIZE))!=-1) {
	              fout.write(buf,0,l);
	        }
	     } catch (Exception e) {
		     e.printStackTrace();
	     } finally {
		     if ( dataInput!= null)  try {dataInput.close();} catch(Exception e) {}
		     if ( fout!= null)  try {fout.close();} catch(Exception e) {}
		    if ( incoming!= null)  try {incoming.close();} catch(Exception e) {}
		 }
	}
}
