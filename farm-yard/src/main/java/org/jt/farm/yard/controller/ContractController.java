package org.jt.farm.yard.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jt.farm.yard.controller.bean.BbsForm;
import org.jt.farm.yard.controller.bean.Contact;
import org.jt.farm.yard.controller.bean.Memo;
import org.jt.farm.yard.dao.DbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping(value="/")
public class ContractController {
	@Autowired
	private DbDao dbDao;
	
	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String  listMemo(Map<String,Object> model) {
		List<Contact> contacts = prepareContact();
		
	    
		System.out.println("show me the money");
	    System.out.println("Goint to list");
	    
	    String str ="{'data' : [ {'title':','this is the firs ttime see the world','20170604']] }";

     
	    return "list";
	} 
	
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String  home(Map<String,Object> model) {
		List<Contact> contacts = prepareContact();
		
	    model.put("contacts", contacts);
	    
	    System.out.println("I am here");
	    return "home";
	} 
	
	
	private static void print(Map<String,Object> map) {
		System.out.println("Going to print the map");
		for (String key : map.keySet()) {
			System.out.println("the key :" + key +",the value:"  + map.get(key));
		}
	}
	
	private String defaultLogoFileName = "beau.jpg";
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String submit(Map<String,Object> model,BbsForm formBean) {
	    System.out.println("Helo,i am here");
	    print(model);
	        
	        
	    System.out.println("the  title is :" + formBean.getNewTitle());
	    System.out.println("the new Content is " + formBean.getNewContent());
      
	 //   this.dbDao.retriveMemo();
	    Memo memo = new Memo();
	    memo.setContent(formBean.getNewContent());
	    memo.setTitle(formBean.getNewTitle());
	    model.put("fromBean", formBean );
	   
	    this.dbDao.save(memo);
	    System.out.println("I aageageagem herexds");
	  // show(resp);
    	return "home";
    }
	
	
	 
		
	 @RequestMapping(value = "/image/show")  
	public  void show(HttpServletRequest req, HttpServletResponse resp) {
		 
		System.out.println("I am hernjjnjnjn");
		try {  
		           OutputStream out = resp.getOutputStream();  
		            resp.setContentType("image/jpeg");  
		         //   FileInputStream in = new FileInputStream(new File("C:\\temp\\beau.JPG"));
		           GridFSDBFile gridFile = dbDao.retrieveFileOne("images", defaultLogoFileName);
		            IOUtils.copy(gridFile.getInputStream(), out);
		            out.flush();  
		           out.close();  
			        } catch (Exception e) {  	
			            e.printStackTrace();  
			     }  

	}

	
	
	
    private List<Contact> prepareContact() {
    	Contact contact = new Contact();
    	contact.setFirstName("solon");
    	contact.setId(201993L);
    	contact.setLastName("xu");
    	contact.setPhoneNumber("13009930093");
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    	contactList.add(contact);
    	
    	return contactList;
    }

	public void setDbDao(DbDao  dbDao) {
		this.dbDao = dbDao;
	}
    
    
}
