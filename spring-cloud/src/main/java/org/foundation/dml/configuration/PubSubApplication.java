package org.foundation.dml.configuration;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.foundation.dml.event.processor.EventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubOperations;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.cloud.gcp.pubsub.support.GcpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import com.google.cloud.pubsub.v1.AckReplyConsumer;

@ImportResource(value={"classpath:db-configuration.xml"})
@SpringBootApplication
public class PubSubApplication {
//     @Value("${spring.cloud.gcp.landing.bucket}")
//     private String landingBucketName;
//     
//     @Value("${spring.cloud.gcp.outgoing.bucket}")
//     private String outgoingBucketName;
//     
     
     @Value("${spring.cloud.gcp.topic.name}")
     private String topicName;
     
     @Value("${spring.cloud.gcp.subscriber.name}")
     private String subName;
     
     
//     @Value("${spring.cloud.gcp.scratch.path}")
//     private String scrathchPath;
//     
//     
     @Autowired
     private EventProcessor eventProcessor;
     	

  private static final Log LOGGER = LogFactory.getLog(PubSubApplication.class);

  public static void main(String[] args) throws IOException {
    SpringApplication.run(PubSubApplication.class, args);
  }
  
 

  // Inbound channel adapter.

  // tag::pubsubInputChannel[]
  @Bean
  public MessageChannel pubsubInputChannel() {
    return new DirectChannel();
  }
  // end::pubsubInputChannel[]

  // tag::messageChannelAdapter[]
  @Bean
  public PubSubInboundChannelAdapter messageChannelAdapter(
      @Qualifier("pubsubInputChannel") MessageChannel inputChannel,
      PubSubOperations pubSubTemplate) {
	  LOGGER.info("Will publish to topic " + this.subName);
		 
      PubSubInboundChannelAdapter adapter =
        new PubSubInboundChannelAdapter(pubSubTemplate, subName);
    adapter.setOutputChannel(inputChannel);
    adapter.setAckMode(AckMode.MANUAL);

    return adapter;
  }
  // end::messageChannelAdapter[]

  // tag::messageReceiver[]
  @Bean
  @ServiceActivator(inputChannel = "pubsubInputChannel")
  public MessageHandler messageReceiver() {
    return message -> {
    //  LOGGER.info("Message arrived! Payload: " + message.getPayload());
      LOGGER.info("Message arrived! Payload: " + message.getHeaders().get("objectId"));
      
      this.eventProcessor.process(message.getHeaders().get("objectId"));
      
      
      AckReplyConsumer consumer =
          (AckReplyConsumer) message.getHeaders().get(GcpHeaders.ACKNOWLEDGEMENT);
      consumer.ack();
    };
  }
  // end::messageReceiver[]

  // Outbound channel adapter

  // tag::messageSender[]
  @Bean
  @ServiceActivator(inputChannel = "pubsubOutputChannel")
  public MessageHandler messageSender(PubSubOperations pubsubTemplate) {
	  LOGGER.info("Will publish to topic " + this.topicName);
	  PubSubMessageHandler a = new PubSubMessageHandler(pubsubTemplate, topicName);
	  a.setPublishTimeout(2 * 60 *1000);
	  return a;
  }
  // end::messageSender[]

  // tag::messageGateway[]
  @MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
  public interface PubsubOutboundGateway {

    void sendToPubsub(String text);
  }
  // end::messageGateway[]

   public void setEventProcessor(EventProcessor eventProcessor) {
	    this.eventProcessor = eventProcessor;
   }

  
  
  
}
