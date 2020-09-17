package tr.com.sakarya.uni.tez.mvc.web.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import tr.com.sakarya.uni.tez.kafka.models.DKProductInfoTable;
import tr.com.sakarya.uni.tez.kafka.models.DKUserInfoTable;
import tr.com.sakarya.uni.tez.mvc.web.securelogin.AppSecurityConfig;
@Component
public class Receiver implements ConsumerSeekAware {

	  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	  private CountDownLatch latch = new CountDownLatch(1);
	  public static AtomicReference<DKProductInfoTable> atomicProductionInfoTable = new AtomicReference<>();
	  public static AtomicReference<DKUserInfoTable> atomicUserInfoTable = new AtomicReference<>();


	  public CountDownLatch getLatch() {
		    return latch;
	  }

    @PostConstruct//butun inejctlerden sonra
    public void init() {
      System.out.println("Receiver.init()");
    }

	//  @KafkaListener(topics = "${kafka.topic.avro}")
	  @KafkaListener(topics = "DKProductInfoTable", containerFactory = "kafkaListenerContainerFactoryDKProductInfoTable")
	  public void receive(DKProductInfoTable productInfoTable) {
	    LOGGER.info("received productInfoTable='{}'", productInfoTable.toString());
	    atomicProductionInfoTable.set(productInfoTable);
	    latch.countDown();
	  } 
	  
	  @KafkaListener(topics = "DKUserInfoTable",containerFactory = "kafkaListenerContainerFactoryDKUserInfoTable")
	  public void receive(DKUserInfoTable userInfoTable) {
	    LOGGER.info("received userInfoTable='{}'", userInfoTable.toString());
	    atomicUserInfoTable.set(userInfoTable);
	    latch.countDown();  

	    
        //inMemoryUserDetailsManager.createUser(new User("nil", "nil", new ArrayList<GrantedAuthority>()));

	  }
	  
	@Override
	public void registerSeekCallback(ConsumerSeekCallback callback) {
		// TODO Auto-generated method stub
		System.out.println("Receiver.registerSeekCallback()");
	}

	@Override
	public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
		// TODO Auto-generated method stub
		System.out.println("Receiver.onPartitionsAssigned()");
	}

	@Override
	public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
		// TODO Auto-generated method stub
		System.out.println("Receiver.onIdleContainer()");
	}



	  /**
	   * This provides you with three methods
	   *  that can be used to seek to a specific offset. 
	   *  There is one method that will be invoked as soon as the partitions are assigned.
	   *   So it could look like this.
	   **/ 
	  
//	@Override
//	public void registerSeekCallback(ConsumerSeekCallback callback) {
//		// TODO Auto-generated method stub
//		System.out.println("Receiver.registerSeekCallback()");
//	}
//
//	@Override
//	public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
////	    assignments.keySet().stream()
////        .filter(partition -> "MYTOPIC".equals(partition.topic()))
////        .forEach(partition -> callback.seekToBeginning("MYTOPIC", partition.partition()));
//	    System.out.println("Receiver.onPartitionsAssigned()");
//    
//	     String topic="DKProductInfoTable";
//	        assignments.keySet().stream().filter(partition->topic.equals(partition.topic()))
//	                .forEach(partition -> callback.seek(topic, partition.partition(),10));
//
//	        
//	}
//
//	@Override
//	public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
//		// TODO Auto-generated method stub
//		System.out.println("Receiver.onIdleContainer()");
//		
//	} 
	  
}
