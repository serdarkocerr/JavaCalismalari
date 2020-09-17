package tr.com.siparis.database.kafka.producer;

import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import tr.com.siparis.database.manager.dao.AnayemekDaoImp;
import tr.com.siparis.database.manager.dao.CorbaDaoImp;
import tr.com.siparis.database.manager.dao.KullaniciDaoImp;
import tr.com.siparis.database.manager.dao.MasaDaoImp;
import tr.com.siparis.database.manager.dao.SalataDaoImp;
import tr.com.siparis.database.manager.dao.SiparisDaoImp;
import tr.com.siparis.database.manager.dao.TatliDaoImp;
import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.MasaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;



@Component
public class KafkaSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);



 // @Value("${kafka.topic.avro}")
  private String avroTopicSiparis = "SiparisListesiDB";
  private String avroTopicAnayemek = "AnayemekListesiDB";
  private String avroTopicCorba = "CorbaListesiDB";
  private String avroTopicSalata = "SalataListesiDB";
  private String avroTopicTatli = "TatliListesiDB";
  private String avroTopicMasa = "MasaListesiDB";

  private String avroTopicUserInfoTable = "KullaniciListesiDB";



  @Autowired
  private KafkaTemplate<String, SiparisKafkaModel> kafkaTemplateSiparis;
  @Autowired
  private KafkaTemplate<String, AnayemekKafkaModel> kafkaTemplateAnayemek;
  @Autowired
  private KafkaTemplate<String, CorbaKafkaModel> kafkaTemplateCorba;
  @Autowired
  private KafkaTemplate<String, SalataKafkaModel> kafkaTemplateSalata;
  @Autowired
  private KafkaTemplate<String, TatliKafkaModel> kafkaTemplateTatli;
  @Autowired
  private KafkaTemplate<String, MasaKafkaModel> kafkaTemplateMasa;
  @Autowired
  private KafkaTemplate<String, DKUserInfoTable> kafkaTemplateUserInfoTable;
 
  @PostConstruct
  public void init() {
    System.out.println("Sender.init()");
  }
  
  public void sendSiparis(SiparisKafkaModel siparisKafkaModel) {
    LOGGER.info("sending siparisKafkaModel='{}'", siparisKafkaModel.toString());
    kafkaTemplateSiparis.send(avroTopicSiparis, siparisKafkaModel);
  }

  public void sendAnayemek(AnayemekKafkaModel anayemekKafkaModel) {
	    LOGGER.info("sending anayemekKafkaModel='{}'", anayemekKafkaModel.toString());
	    kafkaTemplateAnayemek.send(avroTopicAnayemek, anayemekKafkaModel);
 }
  public void sendCorba(CorbaKafkaModel corbaKafkaModel) {
	    LOGGER.info("sending corbaKafkaModel='{}'", corbaKafkaModel.toString());
	    kafkaTemplateCorba.send(avroTopicCorba, corbaKafkaModel);
 }
  public void sendSalata(SalataKafkaModel salataKafkaModel) {
	    LOGGER.info("sending SalataKafkaModel='{}'", salataKafkaModel.toString());
	    kafkaTemplateSalata.send(avroTopicSalata, salataKafkaModel);
 }
  public void sendTatli(TatliKafkaModel TatliKafkaModel) {
	    LOGGER.info("sending TatliKafkaModel='{}'", TatliKafkaModel.toString());
	    kafkaTemplateTatli.send(avroTopicTatli, TatliKafkaModel);
 }
  public void sendMasa(MasaKafkaModel masaKafkaModel) {
	    LOGGER.info("sending masaKafkaModel='{}'", masaKafkaModel.toString());
	    kafkaTemplateMasa.send(avroTopicMasa, masaKafkaModel);
}
  public void sendKullanicilar(DKUserInfoTable dKUserInfoTable) {
	    LOGGER.info("sending dKUserInfoTable='{}'", dKUserInfoTable.toString());
	    kafkaTemplateUserInfoTable.send(avroTopicUserInfoTable, dKUserInfoTable);
}
  
}
