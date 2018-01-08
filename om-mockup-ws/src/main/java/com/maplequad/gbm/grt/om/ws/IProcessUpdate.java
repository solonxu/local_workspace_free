package com.maplequad.gbm.grt.om.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maplequad.gbm.grt.om.ws.bean.request.ProcessUpdateRequestBean;
import com.maplequad.gbm.grt.om.ws.bean.response.ProcessUpdateResponseBean;

@WebService

public interface IProcessUpdate {
	
	@WebMethod
	public ProcessUpdateResponseBean updateProcessStatus(ProcessUpdateRequestBean reqBean);

}
