package tr.com.siparis.database.kafka.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import tr.com.siparis.database.kafka.producer.DatabaseKafkaSender;
import tr.com.siparis.database.kafka.producer.KafkaSender;
import tr.com.siparis.database.model.siparis;
import tr.com.siparis.sistemi.kafka.model.CRUDType;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;

@Component
public class KafkaReceiver implements ConsumerSeekAware {

	  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);
	  private CountDownLatch latch = new CountDownLatch(1);
	  public static AtomicReference<SiparisCRUD> atomicSiparisCRUD = new AtomicReference<>();

	  @Autowired
	  public DatabaseKafkaSender databaseKafkaSender;
	  @Autowired
		KafkaSender sender;
	  private String avroTopicUIGarsonSiparis = "UIGarsonSiparis";

	  public CountDownLatch getLatch() {
		    return latch;
	  }

    @PostConstruct//butun inejctlerden sonra
    public void init() {
      System.out.println("Receiver.init()");
    }

	  @KafkaListener(topics = "UIGarsonSiparis",containerFactory = "kafkaListenerContainerFactorySiparisCRUD")
	  public void receive(SiparisCRUD siparisCRUD) {
	    LOGGER.info("received siparisCRUD='{}'", siparisCRUD.toString());
	    atomicSiparisCRUD.set(siparisCRUD);
	    
	    if(siparisCRUD.getCrudType() == CRUDType.CREATE) {
		    /* siparisKafkaModel to  Database write */
		    databaseKafkaSender.createNewSiparis(siparisCRUD);
		    // publish Siparis to Kafka wit newly records
		    databaseKafkaSender.publishSiparisler();
	    }else if(siparisCRUD.getCrudType() == CRUDType.DELETE) {
	    	/* siparisKafkaModel to  Database write */
		    databaseKafkaSender.deleteSiparis(siparisCRUD);
		    // publish Siparis to Kafka wit newly records
		    databaseKafkaSender.publishSiparisler();
	    }else if(siparisCRUD.getCrudType() == CRUDType.UPDATE) {
	    	/* siparisKafkaModel to  Database update */
	    	databaseKafkaSender.updateSiparis(siparisCRUD);
		    // publish Siparis to Kafka wit newly records
		    databaseKafkaSender.publishSiparisler();
	    }
	    latch.countDown();  
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
