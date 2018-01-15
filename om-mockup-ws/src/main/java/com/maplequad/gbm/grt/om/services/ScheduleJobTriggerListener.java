package com.maplequad.gbm.grt.om.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;



public class ScheduleJobTriggerListener implements TriggerListener,ApplicationContextAware {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	
	private transient AutowireCapableBeanFactory beanFactory;
	          
    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
    	this.beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }
    
    
    public String getName() {
    	log.debug(this.getClass().getSimpleName());
    	return this.getClass().getSimpleName();
    }
    
    
    public void triggerComplete(Trigger trigger,JobExecutionContext jobExecutionContext,Trigger.CompletedExecutionInstruction triggerInstructionCode) {
    	
    }
    
    public void triggerFired(Trigger trigger,JobExecutionContext jobExecutionContext) {
	    Job job = jobExecutionContext.getJobInstance();
	    this.beanFactory.autowireBeanProperties(job, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);
	    log.info("Apply autowire for job" + jobExecutionContext.getJobDetail().getJobClass().getName());
    	
    }
    
    public void triggerMisfired(Trigger trigger) {
    	
    }
    
    public boolean vetoJobExecution(Trigger trigger,JobExecutionContext jobExecutionBean) {
    	return false;
    }
	

}
