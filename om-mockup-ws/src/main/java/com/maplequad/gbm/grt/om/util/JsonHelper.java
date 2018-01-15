package com.maplequad.gbm.grt.om.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maplequad.gbm.grt.om.bean.FeedArrivalBean;

public class JsonHelper {
		
	public static  FeedArrivalBean jsonToFeedArrival(String jsonInString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonInString, FeedArrivalBean.class);
		  
	}
	
	
}
