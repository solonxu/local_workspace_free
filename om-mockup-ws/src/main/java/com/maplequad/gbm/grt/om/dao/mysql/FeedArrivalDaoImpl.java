package com.maplequad.gbm.grt.om.dao.mysql;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.maplequad.gbm.grt.om.Feed;
import com.maplequad.gbm.grt.om.bean.DataLoadRequestBean;
import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;

public class FeedArrivalDaoImpl  extends JdbcDaoSupport implements FeedArrivalDao {
	
	
	private static final String HIBERNATE_SEQUENCE = "SELECT NextVal('HIBERNATE_SEQUENCE') AS id";
	public long generateSequence() {
		Long id = this.getJdbcTemplate().queryForObject(HIBERNATE_SEQUENCE, Long.class);
		
		return id;
		
	}
	
	
	 public void insert(DataLoadRequestBean dlbBean) {
		 
	 }
	 
	 public void insert(Feed feedArrival) {
		 
	 }
	
}
