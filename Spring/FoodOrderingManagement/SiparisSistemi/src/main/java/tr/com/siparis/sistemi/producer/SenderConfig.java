package tr.com.siparis.sistemi.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import tr.com.siparis.sistemi.consumer.avroserializer.AvroSerializer;
import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;



@Configuration
public class SenderConfig {


	 //@Value("${kafka.bootstrap-servers}")
  private String bootstrapServers = "192.168.190.136:9092";

 
  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);

    return props;
  }
  /*********** Siparis CRUD Model *************/
  @Bean
  public ProducerFactory<String, SiparisCRUD> producerFactorySiparisCRUD() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, SiparisCRUD> kafkaTemplateSiparis() {
    return new KafkaTemplate<>(producerFactorySiparisCRUD());
  }

  @Bean
  public KafkaSender sender() {
    return new KafkaSender();
  }
}
