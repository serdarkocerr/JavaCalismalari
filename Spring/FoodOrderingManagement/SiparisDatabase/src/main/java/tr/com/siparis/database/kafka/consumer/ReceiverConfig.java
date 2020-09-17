package tr.com.siparis.database.kafka.consumer;

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

import tr.com.siparis.database.avroserializer.AvroDeserializer;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;


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
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "siparisDBConsumer");
	   // props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	    return props;
	  }
//	  public ConsumerFactory<String, DKProductInfoTable> consumerFactoryDKProductInfoTable() {
//	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
//	        new AvroDeserializer<>(DKProductInfoTable.class));
//	  }
//	  @Bean(name = "kafkaListenerContainerFactoryDKProductInfoTable")//name kafkaListenerContainerFactory ile başlamalı.
//	  public ConcurrentKafkaListenerContainerFactory<String, DKProductInfoTable> kafkaListenerContainerFactoryDKProductInfoTable() {
//	    ConcurrentKafkaListenerContainerFactory<String, DKProductInfoTable> factory =
//	        new ConcurrentKafkaListenerContainerFactory<>();
//	    factory.setConsumerFactory(consumerFactoryDKProductInfoTable());
//
//	    return factory;
//	  }
//	  
	  
	  public ConsumerFactory<String, SiparisCRUD> consumerFactorySiparisCRUD() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new AvroDeserializer<>(SiparisCRUD.class));
	  }
	  @Bean(name = "kafkaListenerContainerFactorySiparisCRUD")//name kafkaListenerContainerFactory ile başlamalı.
	  public ConcurrentKafkaListenerContainerFactory<String, SiparisCRUD> kafkaListenerContainerFactorySiparisCRUD() {
	    ConcurrentKafkaListenerContainerFactory<String, SiparisCRUD> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactorySiparisCRUD());

	    return factory;
	  }
		  
	  @Bean
	  public KafkaReceiver receiver() {
	    return new KafkaReceiver();
	  }
}
