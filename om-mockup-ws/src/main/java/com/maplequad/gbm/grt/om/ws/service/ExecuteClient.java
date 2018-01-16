package com.maplequad.gbm.grt.om.ws.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.maplequad.gbm.grt.om.ExecuteRequest;
import com.maplequad.gbm.grt.om.ExecuteResponse;
import com.maplequad.gbm.grt.om.IExecute;

public class ExecuteClient {
	private static Log log = LogFactory.getLog(ExecuteClient.class);
	private String url = null;
	
	public  void pushExecution(ExecuteRequest request) {
		IExecute service = createService(url);
		
		ExecuteResponse response = service.executeWrapperRequest(request);
		
		log.info("Got the execute response" + response.getResponseCode());
	}
	

	
	private  IExecute createService(String url) {
		  JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
			proxyFactoryBean.setAddress(url);
			proxyFactoryBean.setServiceClass(IExecute.class);
			IExecute service = (IExecute)proxyFactoryBean.create();
		
			return service;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
