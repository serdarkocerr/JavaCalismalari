package tr.com.siparis.sistemi.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import tr.com.siparis.sistemi.consumer.avroserializer.AvroDeserializer;
import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.MasaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;


@Configuration
@EnableKafka
public class ReceiverConfig {

	 //@Value("${kafka.bootstrap-servers}")
	  private String bootstrapServers = "192.168.190.136:9092";
	// @Value("${kafka.topic.avro}")
	  private String topicDKProductInfoTable = "UIGarsonSiparis";
	// @Value("${spring.kafka.consumer.group-id}")
	 private String groupId = "siparisDBConsumer";
	 
	  @Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "siparisUIConsumer");
	   // props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	    return props;
	  }
	 /*** SiparisKafkaModel **/ 
	  public ConsumerFactory<String, SiparisKafkaModel> consumerFactorySiparisKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(SiparisKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactorySiparisKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, SiparisKafkaModel> kafkaListenerContainerFactorySiparisKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, SiparisKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactorySiparisKafkaModel());

	    return factory;
	  }
	  
//	  @Bean
//	  public ConsumerFactory<String, Object> consumerFactory() {
//	    KafkaAvroDeserializer avroDeser = new KafkaAvroDeserializer();
//	    avroDeser.configure(consumerConfigs(), false);
//	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), 
//	                   new StringDeserializer(), 
//	                   avroDeser);
//	  }
	  
	/*** AnayemekKafkaModel **/   
	  
	  public ConsumerFactory<String, AnayemekKafkaModel> consumerFactoryAnayemekKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(AnayemekKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactoryAnayemekKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, AnayemekKafkaModel> kafkaListenerContainerFactoryAnayemekKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, AnayemekKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactoryAnayemekKafkaModel());

	    return factory;
	  }
	  
	/*** CorbaKafkaModel **/   
	  
	  public ConsumerFactory<String, CorbaKafkaModel> consumerFactoryCorbaKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(CorbaKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactoryCorbaKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, CorbaKafkaModel> kafkaListenerContainerFactoryCorbaKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, CorbaKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactoryCorbaKafkaModel());

	    return factory;
	  }	  
	/*** SalataKafkaModel **/   
	  
	  public ConsumerFactory<String, SalataKafkaModel> consumerFactorySalataKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(SalataKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactorySalataKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, SalataKafkaModel> kafkaListenerContainerFactorySalataKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, SalataKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactorySalataKafkaModel());

	    return factory;
	  }	  	  
	  
	/*** TatliKafkaModel **/   
	  
	  public ConsumerFactory<String, TatliKafkaModel> consumerFactoryTatliKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(TatliKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactoryTatliKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, TatliKafkaModel> kafkaListenerContainerFactoryTatliKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, TatliKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactoryTatliKafkaModel());

	    return factory;
	  }	
	  
	/*** MasaKafkaModel **/   
	  
	  public ConsumerFactory<String, MasaKafkaModel> consumerFactoryMasaKafkaModel() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(MasaKafkaModel.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactoryMasaKafkaModel")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, MasaKafkaModel> kafkaListenerContainerFactoryMasaKafkaModel() {
	    ConcurrentKafkaListenerContainerFactory<String, MasaKafkaModel> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactoryMasaKafkaModel());

	    return factory;
	  }	
	/*** DKUserInfoTable **/   
	  
	  public ConsumerFactory<String, DKUserInfoTable> consumerFactoryDKUserInfoTable() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(DKUserInfoTable.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactoryDKUserInfoTable")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, DKUserInfoTable> kafkaListenerContainerFactoryDKUserInfoTable() {
	    ConcurrentKafkaListenerContainerFactory<String, DKUserInfoTable> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactoryDKUserInfoTable());

	    return factory;
	  }	 
	  
	  
	  @Bean
	  public KafkaReceiver receiver() {
	    return new KafkaReceiver();
	  }
}
