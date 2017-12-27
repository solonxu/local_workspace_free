package org.foundation.dml.dao;

import java.util.List;

import org.foundation.dml.bean.Registry;

public interface DbDao {
	
	public List<Registry> listRegistry(String sourceSystem,String siteCode);
	
	
}
