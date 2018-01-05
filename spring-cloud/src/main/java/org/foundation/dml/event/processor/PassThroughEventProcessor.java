package org.foundation.dml.event.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PassThroughEventProcessor implements EventProcessor {
	  private  final Log log = LogFactory.getLog(this.getClass());

	public void process(Object event) {
		String objectId = (String)event;
		
		log.info("got event for objeectId" + objectId);
	}
}
