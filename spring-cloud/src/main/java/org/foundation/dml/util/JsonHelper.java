package org.foundation.dml.util;

import java.util.Date;

import org.foundation.dml.bean.FeedArrivalBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	
	
	public static String objectToString(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

	}
	
	public static void main(String arg[]) {
		ObjectMapper mapper = new ObjectMapper();

		
		///FeedArrivalBean feedArrival = createFeedArrivalBean();
		
		try {
		String jsonInString =objectToString(createFeedArrivalBean());
		System.out.println(jsonInString);

			FeedArrivalBean arrivalBean = mapper.readValue(jsonInString, FeedArrivalBean.class);
		    System.out.println(arrivalBean.getSourceName() +",DATE=" +arrivalBean.getBatchDate());;

		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static FeedArrivalBean createFeedArrivalBean() {
		FeedArrivalBean feedArrival = new FeedArrivalBean();
		feedArrival.setBatchDate(new Date());
		feedArrival.setDataType("ref_data");
		feedArrival.setSourceName("gs://dml-test-bucket/outgoing/ta.txt");
		feedArrival.setSite("LOH");
		
		return feedArrival;
		
	
	}

}
