package tr.com.siparis.database.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import tr.com.siparis.database.avroserializer.AvroSerializer;
import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.Masa;
import tr.com.siparis.sistemi.kafka.model.MasaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
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
  /*********** Siparis Kafka Model *************/
  @Bean
  public ProducerFactory<String, SiparisKafkaModel> producerFactorySiparis() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, SiparisKafkaModel> kafkaTemplateSiparis() {
    return new KafkaTemplate<>(producerFactorySiparis());
  }
/************************/
  
  /*********** Anayemek Kafka Model *************/
  @Bean
  public ProducerFactory<String, AnayemekKafkaModel> producerFactoryAnayemek() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, AnayemekKafkaModel> kafkaTemplateAnayemek() {
    return new KafkaTemplate<>(producerFactoryAnayemek());
  }
  /************************/
  
  /*********** Corba Kafka Model *************/
  @Bean
  public ProducerFactory<String, CorbaKafkaModel> producerFactoryCorba() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, CorbaKafkaModel> kafkaTemplateCorba() {
    return new KafkaTemplate<>(producerFactoryCorba());
  }
  /************************/
  
  /*********** Salata Kafka Model *************/
  @Bean
  public ProducerFactory<String, SalataKafkaModel> producerFactorySalata() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, SalataKafkaModel> kafkaTemplateSalata() {
    return new KafkaTemplate<>(producerFactorySalata());
  }
  /************************/
  
  
  /*********** Tatli Kafka Model *************/
  @Bean
  public ProducerFactory<String, TatliKafkaModel> producerFactoryTatli() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, TatliKafkaModel> kafkaTemplateTatli() {
    return new KafkaTemplate<>(producerFactoryTatli());
  }
  /************************/
  
  /*********** Masa Kafka Model *************/
  @Bean
  public ProducerFactory<String, MasaKafkaModel> producerFactoryMasa() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, MasaKafkaModel> kafkaTemplateMasa() {
    return new KafkaTemplate<>(producerFactoryMasa());
  }
  /************************/
  
  /*********** Kullanici Kafka Model *************/
  @Bean
  public ProducerFactory<String, DKUserInfoTable> producerFactoryUserInfoTable() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, DKUserInfoTable> kafkaTemplateUserInfoTable() {
    return new KafkaTemplate<>(producerFactoryUserInfoTable());
  }
  /************************/
  @Bean
  public KafkaSender sender() {
    return new KafkaSender();
  }
}
