package tr.com.siparis.sistemi.consumer;

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
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.MasaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;

@Component
public class KafkaReceiver implements ConsumerSeekAware {

	  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);
	  private CountDownLatch latch = new CountDownLatch(7);//1
	  public static AtomicReference<SiparisKafkaModel> atomicSiparisKafkaModel = new AtomicReference<>();
	  public static AtomicReference<AnayemekKafkaModel> atomicAnayemekKafkaModel = new AtomicReference<>();
	  public static  AtomicReference<CorbaKafkaModel> atomicCorbaKafkaModel = new AtomicReference<>();
	  public static AtomicReference<SalataKafkaModel> atomicSalataKafkaModel = new AtomicReference<>();
	  public static  AtomicReference<TatliKafkaModel> atomicTatliKafkaModel = new AtomicReference<>();
	  public static AtomicReference<MasaKafkaModel> atomicMasaKafkaModel = new AtomicReference<>();
	  public static  AtomicReference<DKUserInfoTable> atomicDKUserInfoTable = new AtomicReference<>();
	  
	  private String avroTopicSiparis = "SiparisListesiDB";
	  private String avroTopicAnayemek = "AnayemekListesiDB";
	  private String avroTopicCorba = "CorbaListesiDB";
	  private String avroTopicSalata = "SalataListesiDB";
	  private String avroTopicTatli = "TatliListesiDB";
	  private String avroTopicMasa = "MasaListesiDB";
	  private String avroTopicUserInfoTable = "KullaniciListesiDB";
	  
	  public CountDownLatch getLatch() {
		    return latch;
	  }

    @PostConstruct//butun inejctlerden sonra
    public void init() {
      System.out.println("Receiver.init()");
    }

	  @KafkaListener(topics = "SiparisListesiDB",containerFactory = "kafkaListenerContainerFactorySiparisKafkaModel")
	  public void receive(SiparisKafkaModel siparisKafkaModel) {
	    LOGGER.info("received SiparisListesiDB='{}'", siparisKafkaModel.toString());
	    atomicSiparisKafkaModel.set(siparisKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	
	  @KafkaListener(topics = "AnayemekListesiDB",containerFactory = "kafkaListenerContainerFactoryAnayemekKafkaModel")
	  public void receive(AnayemekKafkaModel anayemekKafkaModel) {
	    LOGGER.info("received AnayemekKafkaModel='{}'", anayemekKafkaModel.toString());
	    atomicAnayemekKafkaModel.set(anayemekKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	  
	  @KafkaListener(topics = "CorbaListesiDB",containerFactory = "kafkaListenerContainerFactoryCorbaKafkaModel")
	  public void receive(CorbaKafkaModel corbaKafkaModel) {
	    LOGGER.info("received CorbaKafkaModel='{}'", corbaKafkaModel.toString());
	    atomicCorbaKafkaModel.set(corbaKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	  @KafkaListener(topics = "SalataListesiDB",containerFactory = "kafkaListenerContainerFactorySalataKafkaModel")
	  public void receive(SalataKafkaModel salataKafkaModel) {
	    LOGGER.info("received CorbaKafkaModel='{}'", salataKafkaModel.toString());
	    atomicSalataKafkaModel.set(salataKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	  
	  @KafkaListener(topics = "TatliListesiDB",containerFactory = "kafkaListenerContainerFactoryTatliKafkaModel")
	  public void receive(TatliKafkaModel tatliKafkaModel) {
	    LOGGER.info("received TatliKafkaModel='{}'", tatliKafkaModel.toString());
	    atomicTatliKafkaModel.set(tatliKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	  
	  @KafkaListener(topics = "MasaListesiDB",containerFactory = "kafkaListenerContainerFactoryMasaKafkaModel")
	  public void receive(MasaKafkaModel masaKafkaModel) {
	    LOGGER.info("received masaKafkaModel='{}'", masaKafkaModel.toString());
	    atomicMasaKafkaModel.set(masaKafkaModel);
	    
	    /*UI send*/

	    latch.countDown();  
	  }
	  
	  @KafkaListener(topics = "KullaniciListesiDB",containerFactory = "kafkaListenerContainerFactoryDKUserInfoTable")
	  public void receive(DKUserInfoTable dkUserInfoTable) {
	    LOGGER.info("received DKUserInfoTable='{}'", dkUserInfoTable.toString());
	    atomicDKUserInfoTable.set(dkUserInfoTable);
	    
	    /*UI send*/

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
