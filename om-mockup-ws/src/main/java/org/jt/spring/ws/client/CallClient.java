package org.jt.spring.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.maplequad.gbm.grt.om.client.Feed;
import com.maplequad.gbm.grt.om.ws.IProcessUpdate;
import com.maplequad.gbm.grt.om.ws.bean.request.ProcessUpdateRequestBean;
import com.maplequad.gbm.grt.om.ws.bean.response.ProcessUpdateResponseBean;

public class CallClient {
	
	public static void main(String arg[]) {
		JaxWsDynamicClientFactory factory =  JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://35.205.135.62:8090/om/service/processUpdate?wsdl");
		
		try {
			// HelloService service = (HelloService)client;
			 
		    // String  object = service.sayHi("the world");
		 //  Object[] str  =  client.invoke(operationName, params)
			
			//client.invo
			IProcessUpdate processUpdate = (IProcessUpdate)client;
			
			ProcessUpdateRequestBean request = new ProcessUpdateRequestBean();
			request.setBusinessDate("201720111");
			Feed feed = new Feed();
			feed.setCategory("DML");
			feed.setDataLoadInstanceID("2211");
			
			List<Feed> outputFeeds = new ArrayList<Feed>();
			outputFeeds.add(feed);
			
			request.setOutputFeeds(outputFeeds);;
			
			
			
			ProcessUpdateResponseBean response = processUpdate.updateProcessStatus(request);
			System.out.println("Client:"+ response.getReasonCode() +",the reaonse text:" + response.getReasonText());
			
		
		   
			
//		   for (Object object : str) {
//		   
//		    System.out.println(object.getClass());
//		    System.out.println(object.toString());
//		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
