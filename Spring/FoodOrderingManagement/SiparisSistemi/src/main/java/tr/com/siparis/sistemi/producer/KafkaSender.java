package tr.com.siparis.sistemi.producer;

import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;



@Component
public class KafkaSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);



 // @Value("${kafka.topic.avro}")
  private String avroTopicUIGarsonSiparis = "UIGarsonSiparis";


  
  @Autowired
  private KafkaTemplate<String, SiparisCRUD> kafkaTemplateSiparis;
 
  @PostConstruct
  public void init() {
    System.out.println("Sender.init()");
  }
  
  public void sendUIGarsonSiparis(SiparisCRUD siparisCRUD) {
    LOGGER.info("sending siparisCRUD='{}'", siparisCRUD.toString());
    kafkaTemplateSiparis.send(avroTopicUIGarsonSiparis, siparisCRUD);
  }
}
