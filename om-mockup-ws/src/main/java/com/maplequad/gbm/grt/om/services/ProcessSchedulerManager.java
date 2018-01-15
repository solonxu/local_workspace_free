package com.maplequad.gbm.grt.om.services;

import java.text.ParseException;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

public class ProcessSchedulerManager {
	private Log log = LogFactory.getLog(this.getClass());
	private Scheduler scheduler;
	private ScheduleJobTriggerListener triggerListener;
	
	
	public void testJob() {
		deleteJob("trigger1","TriggerGroup1");
		scheduleJob("testJob","JobGroup1","trigger1","TriggerGroup1","com.maplequad.gbm.grt.om.job.HandleExecutionJob","45 0/1 * * * ?");
		
	}
	
	public void deleteJob(String triggerName,String triggerGroup) {
		try {
		Trigger trigger = this.scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
		if (trigger!= null) {
			this.scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroup));
			log.info("Delete trigger successful");
		} else {
			log.info("Can't find the trigger,can't delete either");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void scheduleJob(String jobName,String jobGroup,String triggerName,String triggerGroup,String jobClsName,String cronExpression) {
				
		try {
			Trigger trigger = this.scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
			
			
			
		    JobDetailFactoryBean jobDetailBeanFactory = new JobDetailFactoryBean();;
		    jobDetailBeanFactory.setName(jobName);
		    jobDetailBeanFactory.setGroup(jobGroup);
		  //  String jobClassName ="";
		    jobDetailBeanFactory.setJobClass(Class.forName(jobClsName));
		    //jobDetailBeanFactory.set
		    jobDetailBeanFactory.afterPropertiesSet();
		    JobDetail jobDetail = jobDetailBeanFactory.getObject();
		    
		    if (trigger != null) {
		    	log.info("the trigger already exist! " + triggerName );
		    } else {
		    //	trigger = new CronTriggerFa();
		    	CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
		    	triggerFactoryBean.setCronExpression(cronExpression);
		    	triggerFactoryBean.setTimeZone(TimeZone.getDefault());
		    	triggerFactoryBean.setJobDetail(jobDetail);
		    	triggerFactoryBean.setGroup(triggerGroup);
		    	triggerFactoryBean.setName(triggerName);
		    	//triggerFactoryBean
		    	triggerFactoryBean.afterPropertiesSet();
		    
		    	trigger = triggerFactoryBean.getObject();
		    	
		    	
		    	scheduler.scheduleJob(jobDetail,trigger);
		    	scheduler.getListenerManager().addTriggerListener(this.triggerListener,KeyMatcher.keyEquals(trigger.getKey()));
		    	
		    	log.info("JobName " + jobName + " scheduled!");
		    }
		    
		    
		    
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			log.error(e.getCause());
		} catch(SchedulerException se) {
			se.printStackTrace();
			
			log.error(se.getCause());
		} catch(ParseException pse) {
			pse.printStackTrace();
			
		}
	}


	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void setTriggerListener(ScheduleJobTriggerListener triggerListener) {
		this.triggerListener = triggerListener;
	}
	
	

	
}
