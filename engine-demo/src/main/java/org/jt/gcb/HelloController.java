package  org.jt.gcb;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/index")
    public String index() {
    	//invoke Datastore Demo.read data
    	try {
    	    System.out.println("Going to read the data store!");
    	    
    	    File file = new File ("gs://sx-183314-bucket");
    	    
    	    if (file.exists()) {
    	    	System.out.println("File exist !!!");
    	    	System.out.println("the size of the file:" + file.getTotalSpace());
    	    } else {
    	    	System.out.println("File does not exist");
    	    }
    		//DataStoreDemo.read();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return "Hi,Greetings from solon's Spring Boot!";
    }
    
}
