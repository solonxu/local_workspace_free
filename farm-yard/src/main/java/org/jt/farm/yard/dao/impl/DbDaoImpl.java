package org.jt.farm.yard.dao.impl;

import java.io.File;
import java.util.Date;

import org.jt.farm.yard.controller.bean.Memo;
import org.jt.farm.yard.dao.DbDao;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
	
public class DbDaoImpl implements DbDao {
	 private MongoTemplate mongoTemplate;
	   public void saveFile(String collectionName, File file, String fileid, String companyid, String filename) {
	        try {
	            DB db = mongoTemplate.getDb();
	            // 存储fs的根节点
	            GridFS gridFS = new GridFS(db, collectionName);
	            GridFSInputFile gfs = gridFS.createFile(file);
	            gfs.put("aliases", companyid);
	            gfs.put("filename", fileid);
	            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
	            gfs.save();
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("存储文件时发生错误！！！");
	        }
	    }
	   
	   
	   public void retriveMemo() {
		  try {
			  DB db = mongoTemplate.getDb();
			  DBCollection collection = db.getCollection("memo");
			  DBCursor cursor = collection.find();
			  			  
			  while (cursor.hasNext()) {
			      DBObject object = cursor.next();
			      String title = (String) object.get("title");
			      
			      System.out.println("the title is " + title);
			      
			      Date lastUpdate = (Date)object.get("lastUpdate");
			      System.out.println("the lastUpdate is " + lastUpdate);
				    
			      
			      
			  }
		  } catch (Exception e) {
			  System.out.println("Got error when try to fetch record from DB");
			  e.printStackTrace();
		  }
	   }
	   
	   
	   public void save(Memo memo) {
			  try {
				  DB db = mongoTemplate.getDb();
				  DBCollection collection = db.getCollection("memo");
				  DBObject dbObject = new BasicDBObject().append("title", memo.getTitle())
						  .append("content",memo.getContent()).append("lastUpdate",new Date());
				 collection.insert(dbObject);
				 
				 System.out.println("insert memo succesfully");
				  
			  } catch (Exception e) {
				  System.out.println("Got error when try to fetch record from DB");
				  e.printStackTrace();
			  }
		   }
	   
	   
	   public GridFSDBFile retrieveFileOne(String collectionName, String filename) {
	        try {
	            DB db = mongoTemplate.getDb();
	            // 获取fs的根节点
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
