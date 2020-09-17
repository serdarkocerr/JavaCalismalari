package tr.com.sakarya.uni.tez.mvc.web.producer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD;

@Component
public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

 // @Value("${kafka.topic.avro}")
  private String avroTopic = "UKProductCRUD";

  @Autowired
  private KafkaTemplate<String, UKProductCRUD> kafkaTemplate;

  @PostConstruct
  public void init() {
    System.out.println("Sender.init()");
  }
  
  public void send(UKProductCRUD ukProductCRUD) {
    LOGGER.info("sending ukProductCRUD='{}'", ukProductCRUD.toString());
    kafkaTemplate.send(avroTopic, ukProductCRUD);
  }
}
