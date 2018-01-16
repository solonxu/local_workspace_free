package com.maplequad.gbm.grt.om.dao;

import java.util.Date;
import java.util.List;

import com.maplequad.gbm.grt.om.bean.DataLoadRequestBean;
import com.maplequad.gbm.grt.om.bean.FeedArrivalBean;

public interface FeedArrivalDao {
	
	public long generateSequence();
	public void insert(DataLoadRequestBean dlbBean);
	
	public int updateFeedArrival(Date businessDate,long instanceId,String status) ;
	
	public List<FeedArrivalBean> listFeedArrival();


}
