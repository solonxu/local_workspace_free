package org.foundation.dml.application;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class BucketMonitorService {

    private Logger log = Logger.getLogger(BucketMonitorService.class);

    @JmsListener(destination = "dml-test")
    public void handleMsg(String requestJSON) throws JMSException {
        log.info("Received ");
        try {
           
        	System.out.println(requestJSON);
        } catch (Exception ex) {
            log.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }

}
