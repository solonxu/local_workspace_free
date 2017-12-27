package org.foundation.dml.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.foundation.dml.bean.Registry;
import org.foundation.dml.dao.DbDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDbDao extends JdbcDaoSupport implements DbDao {
	
	private static final String QUERY_FEED_REGISTRY_SQL ="select * from feed_registry where source_system = ? and site = ?";
	public List<Registry> listRegistry(String sourceSystem,String siteCode) {
		List<String> params = new ArrayList<String>();
		params.add(sourceSystem);
		params.add(siteCode);
		
		return this.getJdbcTemplate().query(QUERY_FEED_REGISTRY_SQL, params.toArray(),new RowMapper<Registry>() {
			public Registry mapRow(ResultSet rs,int index) throws SQLException {
				Registry registry = new Registry();
				registry.setDataSubType(rs.getString("data_sub_type"));
				registry.setDataType(rs.getString("data_type"));
				registry.setSiteCode(rs.getString("site"));
				registry.setSourceSystem(rs.getString("source_system"));
				registry.setFilename(rs.getString("filename"));
				
				//rgistry.
				return registry;
				
			}
		});
		
	}

}
