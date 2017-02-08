package org.jt.learning.mongo.dao;

import java.io.File;

import com.mongodb.gridfs.GridFSDBFile;

public interface DbDao {
	 public void saveFile(String collectionName, File file, String fileid, String companyid, String filename);
			
	 public GridFSDBFile retrieveFileOne(String collectionName, String filename);

}
