package org.jt.farm.yard.dao;

import java.io.File;

import org.jt.farm.yard.controller.bean.Memo;

import com.mongodb.gridfs.GridFSDBFile;

public interface DbDao {
	 public void saveFile(String collectionName, File file, String fileid, String companyid, String filename);
			
	 public GridFSDBFile retrieveFileOne(String collectionName, String filename);
	 
	 public void retriveMemo() ;
	   public void save(Memo memo) ;
			

}
