package com.maplequad.gbm.grt.om.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.beans.factory.annotation.Autowired;

import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;

public class HandleExecutionJob implements StatefulJob{

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private FeedArrivalDao feedArrivalDao;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if (feedArrivalDao == null) {
			log.info("Can't find feedArrivalDao");
		} else {
			log.info("Got the feed arrival!!! ,try to get the instanceiD" + this.feedArrivalDao.generateSequence());
		}
		log.info("Execute  " + this.getClass().getName());
	}

	public void setFeedArrivalDao(FeedArrivalDao feedArrivalDao) {
		this.feedArrivalDao = feedArrivalDao;
	}
	
	
}
