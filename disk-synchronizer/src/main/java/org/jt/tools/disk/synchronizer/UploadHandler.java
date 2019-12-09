package org.jt.tools.disk.synchronizer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class UploadHandler extends Thread{
	private static Log LOGGER = LogFactory.getLog(UploadHandler.class);
	Socket ctrlSocket;        
	Socket dataSocket;       
	int id;
	String cmd = "";        //存放指令(空格前)
	String param = "";        //放当前指令之后的参数(空格后)

	String rootdir = null;
	    int state = 0 ;                
	    String reply;                  
	    PrintWriter ctrlOutput; 
	   
	    String requestfile = "";
	    boolean isrest = false;
	    private static int BUFFER_SIZE =1024 * 4;
	   
	    //构造方法
	    public UploadHandler(Socket s,int i,String rootDir) {
	        ctrlSocket = s;
	        id = i;    
	        this.rootdir = rootDir;
	    }

	    //run 方法
	    public void run()
	    {
	        String str = "";
	        int parseResult;                            //与cmd 一一对应的号
	        
	        try
	        {
	            BufferedReader ctrlInput = new BufferedReader
	                                (new InputStreamReader(ctrlSocket.getInputStream()));
	            ctrlOutput = new PrintWriter(ctrlSocket.getOutputStream(),true);
	          // state  = FtpState.FS_WAIT_LOGIN;          //0
	            boolean finished = false;
	            while(!finished)    
	            {
	                str = ctrlInput.readLine();            ///
	                if(str == null) finished = true;    //跳出while
	                else
	                {
	                    parseResult = parseInput(str);  //指令转化为指令号
	                    LOGGER.info("指令:"+cmd+" 参数:"+param);
	                    System.out.print("this ->" + parseResult);
	                    switch(parseResult) {
	                    case 101 : {
	                    	     reply = handleUpload(param);
	                    	}
	                    
	                    }
	                } 
	                ctrlOutput.println(reply);
	                ctrlOutput.flush();////////////////////////////////////
	                
	            } 
	            ctrlSocket.close();
	        } 
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    
	    private String handleUpload(String param) {
	    	   LOGGER.info("Going to receive =>  " + param);
	    	   String splits[] = param.split(",");
	    	   param = StringUtils.trim(param);
	    	   
	    	   String remoteHost = StringUtils.trim(splits[0]);
	    	   int port = Integer.parseInt(splits[1]);
	    	   String relativeFileName = splits[2];
	    	   
	    	   
	    	    Socket transferDataSocket = null;
	    	    BufferedInputStream  fin = null;
	    	    PrintStream dataOutput = null;
	     
	    	    LOGGER.info("Going to connect to [" + remoteHost +"],port:" + port );
	    	    long start = System.currentTimeMillis();
	    	    String reply = "226 传输数据连接结束";
	    	    
	    	    try {
	    	      	transferDataSocket = new Socket(remoteHost,port);
	    	      	LOGGER.info("It take " + (System.currentTimeMillis() - start) + " ms to get the connection");
                 fin = new BufferedInputStream(transferDataSocket.getInputStream());
                 File localFile = formLocalPath(relativeFileName);
                 
                 LOGGER.info("receiving " + localFile);
                  dataOutput = new PrintStream(localFile);
                 
                 
                 
                  
                byte[] buf = new byte[BUFFER_SIZE];         //目标缓冲区
                int l = 0;
                while((l=fin.read(buf,0,BUFFER_SIZE))!=-1)    //缓冲区未读满
                {
                      dataOutput.write(buf,0,l);        //写入套接字
                }
                dataOutput.flush();
                //IOUtils.copy(input, output)
	    	    } catch(Exception e) {
	    	    	e.printStackTrace();
	    	    	LOGGER.info("got exception for receiving file:" + param);
	    	      	reply = "227 传输数据失败！";
	    	    } finally {
                 if (fin != null) try { fin.close();} catch(Exception e) {}
                 if (dataOutput != null) try { dataOutput.close();} catch(Exception e) {}
                 if (dataSocket != null) try { dataSocket.close();} catch(Exception e) {}
        	    }
	    	    return reply;
	    	    
	    	    
	    }
	    
	    private File formLocalPath(String relativeFileName) {
	    	    relativeFileName = relativeFileName.replace("/",File.separator);
	        	File file = new File(rootdir +File.separator +relativeFileName);
	        	
	        	if (!file.getParentFile().exists()) {
	        		file.getParentFile().mkdirs();
	        		LOGGER.info("create folder -> " + file.getParentFile().getAbsolutePath());
	        	}
	         return file;
	        	
	    }

	    //parseInput方法    
	    int parseInput(String s)
	    {
	        int p = 0;
	        int i = -1;
	        p = s.indexOf(" ");
	        if(p == -1)                  //如果是无参数命令(无空格)
	            cmd = s;
	        else 
	            cmd = s.substring(0,p);  //有参数命令,过滤参数
	        
	        if(p >= s.length() || p ==-1)//如果无空格,或空格在读入的s串最后或之外
	            param = "";
	        else
	            param = s.substring(p+1,s.length());
	        cmd = cmd.toUpperCase();     //转换该 String 为大写
	        
	       
	        if(cmd.equals("UPLOAD"))
                i = 101;
	     return i;
	    }
	    


}
