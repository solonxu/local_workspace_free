package com.maplequad.gbm.grt.om.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@Configuration
@EnableAutoConfiguration
@ImportResource(value={"classpath:application-bean.xml"})

public class WsApplication  {
	private Log log = LogFactory.getLog(WsApplication.class);
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String arg[]) {
		Object[] sources = new Object[]{WsApplication.class};
		SpringApplication.run(sources, arg);
	}
	
	@Bean
	
	public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
		return new ServletRegistrationBean(new CXFServlet(),"/om/service/*");
	}
	

	@Bean
	public EndpointImpl helloService() {
		Bus bus = (Bus)applicationContext.getBean(Bus.DEFAULT_BUS_ID);
		//Object implementor = new HelloServiceImpl();
		Object implementor = applicationContext.getBean("processUpdate");
		
		EndpointImpl endpoint = new EndpointImpl(bus,implementor);
		
		endpoint.publish("/processUpdate");
		endpoint.getServer().getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
		endpoint.getServer().getEndpoint().getOutInterceptors().add(new LoggingOutInterceptor());
		
		return endpoint;
	}

	
	

}
