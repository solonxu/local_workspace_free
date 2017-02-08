package org.jt.learning.mongo.boot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jt.learning.mongo.bean.Movie;
import org.jt.learning.mongo.dao.DbDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.gridfs.GridFSDBFile;

public class MongoDbTest {
	
	public static void main(String argp[]) {
		
//		ApplicationContext ctx =
//	             new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mongo-db.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		DbDao dao = (DbDao)ctx.getBean("dbDao");
		
		
		try {
//			File sourceFile = new File("D:\\IMG_4434.JPG");
//			
//			dao.saveFile("images", sourceFile, sourceFile.getName(), "jt", sourceFile.getName());
			GridFSDBFile gridDbFile = dao.retrieveFileOne("images","IMG_4434.JPG");
		
			handleGridFile(gridDbFile);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

//		User user = new User("solon", "passw0rd");
//
//		// save
//		mongoOperation.save(user);
//
//		// now user object got the created id.
//		System.out.println("1. user : " + user);
//
//		// query to search user
//		Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));
//
//		// find the saved user again.
//		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
//		System.out.println("2. find - savedUser : " + savedUser);
//
//		// update password
//		mongoOperation.updateFirst(searchUserQuery,
//	                         Update.update("password", "new password"),User.class);
//
//		// find the updated user object
//		User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
//
//		System.out.println("3. updatedUser : " + updatedUser);
//
//		// delete
//		mongoOperation.remove(searchUserQuery, User.class);
//
//		// List, it should be empty now.
//		List<User> listUser = mongoOperation.findAll(User.class);
//		System.out.println("4. Number of user = " + listUser.size());

		
		List<Movie> movieCollection = mongoOperation.findAll(Movie.class);
	    
		for (Movie movie :movieCollection) {
			System.out.println("name:" + movie.getRemark() +",the url is:" + movie.getUrl());
			
			
		}
		
	}
	
	private static void handleGridFile(GridFSDBFile gridDbFile) {
	    System.out.println("the fileid is " + gridDbFile.getId() +",the filesize is " + gridDbFile.getLength());
	    
	    
	    File outputFile =new File("C:\\temp\\","1_" +gridDbFile.getFilename());
	    
        OutputStream  out = null;
        
        try {
        	out = new FileOutputStream(outputFile);
        	IOUtils.copy(gridDbFile.getInputStream(), out);
        } catch (Exception e) {
        	
        } finally {
        	IOUtils.closeQuietly(out);
        }
	}

}
