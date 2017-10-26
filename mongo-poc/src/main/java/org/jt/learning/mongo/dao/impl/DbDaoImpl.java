package org.jt.learning.mongo.dao.impl;

import java.io.File;

import org.jt.learning.mongo.dao.DbDao;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class DbDaoImpl implements DbDao {
	 private MongoTemplate mongoTemplate;
	   public void saveFile(String collectionName, File file, String fileid, String companyid, String filename) {
	        try {
	            DB db = mongoTemplate.getDb();
	            // �洢fs�ĸ��ڵ�
	            GridFS gridFS = new GridFS(db, collectionName);
	            GridFSInputFile gfs = gridFS.createFile(file);
	            gfs.put("aliases", companyid);
	            gfs.put("filename", fileid);
	            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
	            gfs.save();
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("�洢�ļ�ʱ�������󣡣���");
	        }
	    }
	   
	   
	   public GridFSDBFile retrieveFileOne(String collectionName, String filename) {
	        try {
	            DB db = mongoTemplate.getDb();
	            // ��ȡfs�ĸ��ڵ�
	            GridFS gridFS = new GridFS(db, collectionName);
	            GridFSDBFile dbfile = gridFS.findOne(filename);
	            if (dbfile != null) {
	                return dbfile;
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	            // TODO: handle exception
	        }
	        return null;
	    }
	   
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
		
		

}
