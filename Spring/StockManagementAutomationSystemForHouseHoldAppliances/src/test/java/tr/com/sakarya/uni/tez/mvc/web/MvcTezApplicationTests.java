package tr.com.sakarya.uni.tez.mvc.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import tr.com.sakarya.uni.tez.kafka.models.CRUDType;
import tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD;
import tr.com.sakarya.uni.tez.mvc.web.consumer.Receiver;
import tr.com.sakarya.uni.tez.mvc.web.producer.Sender;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MvcTezApplicationTests {

//  @Autowired
//  private Sender sender;
//
//  @Autowired
//  private Receiver receiver;

//  @Autowired
//  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//  @ClassRule
//  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "avro.t");

//  @Before
//  public void setUp() throws Exception {
//    // wait until the partitions are assigned
//    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//        .getListenerContainers()) {
//      ContainerTestUtils.waitForAssignment(messageListenerContainer,
//          embeddedKafka.getPartitionsPerTopic());
//    }
//  }

//  @Test
//  public void testReceiver() throws Exception {
//    UKProductCRUD crud = new UKProductCRUD();
//    crud.setCrudType(CRUDType.CREATE);
//    crud.setDepoAdi("depo1");
//    crud.setDepoId(1);
//    crud.setMarkaAdi("Arcelik");
//    crud.setMarkaId(1);
//    crud.setUrunAdi("MVCTest");
//    crud.setUrunId(1);
//    crud.setUrunTurAdi("Camasir_Makinasi");
//    crud.setUrunTurId(2);
//    
//    
//    sender.send(crud);
//
//    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//  }
}
