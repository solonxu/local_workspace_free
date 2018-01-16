package com.maplequad.gbm.grt.om.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.maplequad.gbm.grt.om.Feed;
import com.maplequad.gbm.grt.om.bean.DataLoadRequestBean;
import com.maplequad.gbm.grt.om.bean.FeedArrivalBean;
import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;

public class FeedArrivalDaoImpl  extends JdbcDaoSupport implements FeedArrivalDao {
	
	
	private static final String HIBERNATE_SEQUENCE = "SELECT NextVal('HIBERNATE_SEQUENCE') AS id";
	public long generateSequence() {
		Long id = this.getJdbcTemplate().queryForObject(HIBERNATE_SEQUENCE, Long.class);
		
		return id;
		
	}
	
	
	private static final String UPDATE_FEED_ARRIVAL_SQL = "update om_feed_arrival set business_date = ? ,data_loaded = ? ,last_update_time =now() where instance_id = ?";
	public int updateFeedArrival(Date businessDate,long instanceId,String status) {
		Object[] params = new Object[] {businessDate,status,instanceId};
		
		return this.getJdbcTemplate().update(UPDATE_FEED_ARRIVAL_SQL,params);
	}
	
	
	private static final String QUERY_PENDING_FEED_ARRIVAL_LIST = "select instance_id ,category,batch_date,business_date,source_system,site,data_type,data_sub_type," + 
			  "source_name,other ,incremental,part,max_part,calc_key from om_feed_arrival where data_loaded ='D'";
	
	public List<FeedArrivalBean> listFeedArrival() {
		 return this.getJdbcTemplate().query(QUERY_PENDING_FEED_ARRIVAL_LIST, new RowMapper<FeedArrivalBean>() {
			 public FeedArrivalBean mapRow(ResultSet rs,int index) throws SQLException {
				 FeedArrivalBean feedArrival = new FeedArrivalBean();
				 feedArrival.setInstanceId(rs.getLong("instance_id"));
				 feedArrival.setSourceSystem(rs.getString("source_system"));
				 feedArrival.setSite(rs.getString("site"));
				 feedArrival.setDataType(rs.getString("data_type"));
				 feedArrival.setDataSubtype(rs.getString("data_sub_type"));
				 //feedArrival.setBatchDate(rs.getDate("business_date"));
				 feedArrival.setBusinessDate(rs.getDate("business_date"));
				 feedArrival.setCalcKey(String.valueOf(rs.getLong("calc_key")));
				 feedArrival.setSourceName(rs.getString("source_name"));
				 feedArrival.setOther(rs.getString("other"));
				 
				 return feedArrival;
				 
			 }
		 });
	}
	
	
		
	 private static final String INSERT_FEED_ARRIVAL_SQL = " INSERT INTO om_feed_arrival  (instance_id ,process_id,category,batch_date,"
	 		+ "business_date,source_system,site,data_type,data_sub_type ,"  
	 		+ "source_name,other ,incremental ,"
	 		 + "part,max_part,calc_key,last_update_time) values (?,?,?,?,"
	 		 + "?,?,?,?,?,"
	 		 + "?,?,?,"
	 		 + "?,?,?,now())";
	 		 
	 public void insert(final DataLoadRequestBean dlbBean) {
		 final Feed feed = dlbBean.getFeeds().get(0);
		 
		 	this.getJdbcTemplate().update(INSERT_FEED_ARRIVAL_SQL,new PreparedStatementSetter() {
			 public void setValues(PreparedStatement ps) throws SQLException {
				 int i=1;
				 ps.setLong(i++, dlbBean.getInstanceId());
				 ps.setString(i++,dlbBean.getProcessId() );
				 ps.setString(i++,feed.getCategory());
				 ps.setDate(i++,new java.sql.Date(new java.util.Date().getTime()));
				 
				 if (feed.getFeedBusinessDate() == null) {
					 ps.setDate(i++,null);
				 } else {
					 try {
					 java.util.Date businessDate = (new SimpleDateFormat("yyyyMMdd")).parse(feed.getFeedBusinessDate());
					 ps.setDate(i++, new java.sql.Date(businessDate.getTime()));
					 } catch (ParseException pse) {
						 throw new SQLException("Failed to transform feedBusinessDate:" + feed.getFeedBusinessDate());
					 }
				 }
				 
				 ps.setString(i++,feed.getSourceSystem());
				 ps.setString(i++,feed.getSite());
				 ps.setString(i++,feed.getDataType());
				 ps.setString(i++,feed.getDataSubType());
					
				 
				 ps.setString(i++,feed.getSourceName());
				 ps.setString(i++,feed.getOther());
				 ps.setString(i++,"Y");
				 
				 ps.setInt(i++, feed.getPart());
				 ps.setInt(i++, feed.getMaxPart());
				 ps.setLong(i++,Long.valueOf(feed.getCalcKey()));	
				 
				 
			 }
			 
		 } );
		
		 
	 }
	 
	
	 
	 public void insert(Feed feedArrival) {
		 
	 }
	
}
