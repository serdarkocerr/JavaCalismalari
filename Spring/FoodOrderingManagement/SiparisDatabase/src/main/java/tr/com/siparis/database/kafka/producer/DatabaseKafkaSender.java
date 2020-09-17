package tr.com.siparis.database.kafka.producer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.siparis.database.manager.dao.AnayemekDaoImp;
import tr.com.siparis.database.manager.dao.AnayemekSiparisRelationDaoImp;
import tr.com.siparis.database.manager.dao.CorbaDaoImp;
import tr.com.siparis.database.manager.dao.CorbaSiparisRelationDaoImp;
import tr.com.siparis.database.manager.dao.KullaniciDaoImp;
import tr.com.siparis.database.manager.dao.MasaDaoImp;
import tr.com.siparis.database.manager.dao.SalataDaoImp;
import tr.com.siparis.database.manager.dao.SalataSiparisRelationDaoImp;
import tr.com.siparis.database.manager.dao.SiparisDaoImp;
import tr.com.siparis.database.manager.dao.TatliDaoImp;
import tr.com.siparis.database.manager.dao.TatliSiparisRelationDaoImp;
import tr.com.siparis.database.model.KullaniciAllContent;
import tr.com.siparis.database.model.SiparisAllContent;
import tr.com.siparis.database.model.anayemek;
import tr.com.siparis.database.model.anayemeksiparis;
import tr.com.siparis.database.model.corba;
import tr.com.siparis.database.model.corbasiparis;
import tr.com.siparis.database.model.masa;
import tr.com.siparis.database.model.salata;
import tr.com.siparis.database.model.salatasiparis;
import tr.com.siparis.database.model.siparis;
import tr.com.siparis.database.model.tatli;
import tr.com.siparis.database.model.tatlisiparis;
import tr.com.siparis.sistemi.kafka.model.Anayemek;
import tr.com.siparis.sistemi.kafka.model.AnayemekKafkaModel;
import tr.com.siparis.sistemi.kafka.model.Corba;
import tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.DKUserInfo;
import tr.com.siparis.sistemi.kafka.model.DKUserInfoTable;
import tr.com.siparis.sistemi.kafka.model.Masa;
import tr.com.siparis.sistemi.kafka.model.MasaKafkaModel;
import tr.com.siparis.sistemi.kafka.model.Salata;
import tr.com.siparis.sistemi.kafka.model.SalataKafkaModel;
import tr.com.siparis.sistemi.kafka.model.Siparis;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.kafka.model.Tatli;
import tr.com.siparis.sistemi.kafka.model.TatliKafkaModel;

@Component
public class DatabaseKafkaSender {
	@Autowired
	KafkaSender sender;
	
	  AtomicReference<SiparisKafkaModel> atomicSiparisKafkaModel = new AtomicReference<>();
	  AtomicReference<AnayemekKafkaModel> atomicAnayemekKafkaModel = new AtomicReference<>();
	  AtomicReference<CorbaKafkaModel> atomicCorbaKafkaModel = new AtomicReference<>();
	  AtomicReference<SalataKafkaModel> atomicSalataKafkaModel = new AtomicReference<>();
	  AtomicReference<TatliKafkaModel> atomicTatliKafkaModel = new AtomicReference<>();
	  AtomicReference<MasaKafkaModel> atomicMasaKafkaModel = new AtomicReference<>();

	  AtomicReference<DKUserInfoTable> atomicDKUserInfoTable = new AtomicReference<>();
	  
	  
	  
	  public static AnayemekDaoImp anayemekDao;
	  public static CorbaDaoImp corbaDao;
	  public static KullaniciDaoImp kullaniciDao;
	  public static MasaDaoImp masaDao;
	  public static SalataDaoImp salataDao;
	  public static SiparisDaoImp siparisDao;
	  public static TatliDaoImp tatliDao;
	  public static AnayemekSiparisRelationDaoImp anayemekSiparisDao;
	  public static CorbaSiparisRelationDaoImp corbaSiparisDao;
	  public static SalataSiparisRelationDaoImp salataSiparisDao;
	  public static TatliSiparisRelationDaoImp tatliSiparisDao;
	  
	  @PostConstruct
	  public void init() {
		  System.out.println("DatabaseKafkaSender.init()");
		  try {
			/*Read from Database*/
			    if(anayemekDao==null)
			    	anayemekDao = new AnayemekDaoImp();
			    if(corbaDao == null)
			    	corbaDao = new CorbaDaoImp();
			    if(kullaniciDao == null)
			    	kullaniciDao = new KullaniciDaoImp();
			    if(masaDao == null)
			    	masaDao = new MasaDaoImp();
			    if(salataDao == null)
			    	salataDao = new SalataDaoImp();
			    if(siparisDao == null)
			    	siparisDao = new SiparisDaoImp();
			    if(tatliDao == null)
			    	tatliDao = new TatliDaoImp();
			    if(anayemekSiparisDao == null)
			    	anayemekSiparisDao = new AnayemekSiparisRelationDaoImp();
			    if(corbaSiparisDao == null)
			    	corbaSiparisDao = new CorbaSiparisRelationDaoImp();
			    if(salataSiparisDao == null)
			    	salataSiparisDao = new SalataSiparisRelationDaoImp();
			    if(tatliSiparisDao == null)
			    	tatliSiparisDao = new TatliSiparisRelationDaoImp();
			    
			    atomicSiparisKafkaModel.set(getSiparisKafkaModel());
			    atomicAnayemekKafkaModel.set(getAnayemekKafkaModel());
			    atomicCorbaKafkaModel.set(getCorbaKafkaModel());
			    atomicSalataKafkaModel.set(getSalataKafkaModel());
			    atomicTatliKafkaModel.set(getTatliKafkaModel());
			    atomicMasaKafkaModel.set(getMasaKafkaModel());
			    atomicDKUserInfoTable.set(getDKUserInfoTable());

			    
			    /*Send to Kafka*/
			    sender.sendSiparis(atomicSiparisKafkaModel.get());
			    sender.sendAnayemek(atomicAnayemekKafkaModel.get());
			    sender.sendCorba(atomicCorbaKafkaModel.get());
			    sender.sendSalata(atomicSalataKafkaModel.get());
			    sender.sendTatli(atomicTatliKafkaModel.get());
			    sender.sendMasa(atomicMasaKafkaModel.get());
			    sender.sendKullanicilar(atomicDKUserInfoTable.get());
			    
			    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  }
	  
	  
	  public DKUserInfoTable getDKUserInfoTable() {
		  DKUserInfoTable dkUserInfoTable = new DKUserInfoTable();
		  List<DKUserInfo> dkUserInfo = new ArrayList<>();
		  Collection<KullaniciAllContent> kullaniciAllCont= kullaniciDao.getAllContent();
		  
		  kullaniciAllCont.stream().forEach(uac->{
			  DKUserInfo userinfo = new DKUserInfo();
			  userinfo.setKullaniciAdi(uac.getKullaniciAdi());
			  userinfo.setKullaniciID(uac.getKullaniciId());
			  userinfo.setKullaniciSifre(uac.getKullaniciSifre());
			  userinfo.setKullaniciSoyadi(uac.getKullaniciSoyadi());
			  userinfo.setKullaniciTurAdi(uac.getKullaniciTurAdi());
			  userinfo.setKullaniciTurId(uac.getKullaniciTurId());
			  dkUserInfo.add(userinfo);
		  });
		  dkUserInfoTable.setUserInfoTable(dkUserInfo);
		  return dkUserInfoTable;
		  
	  }
	  
	  public MasaKafkaModel getMasaKafkaModel() {
		  MasaKafkaModel masaKafkaModel = new MasaKafkaModel();
		  List<Masa> masaListesi = new ArrayList<>();
		  Collection<masa> masalar = masaDao.getAll();
		  
		  masalar.stream().forEach(dbmasa->{
			  Masa m = new Masa();
			  m.setMasaAdi(dbmasa.getMasaadi());
			  m.setMasaId(dbmasa.getMasaid());
			  masaListesi.add(m);
		  });
		  
		  masaKafkaModel.setMasaListesi(masaListesi);
		  return masaKafkaModel;
		  
	  }
	  
	  
	  public TatliKafkaModel getTatliKafkaModel() {
		  TatliKafkaModel tatliKafkaModell = new TatliKafkaModel();
		  List<Tatli> tatliListesi = new ArrayList<>();
		  Collection<tatli> tatlilar = tatliDao.getAll();
		  
		  tatlilar.stream().forEach(dbtatli->{
			  Tatli t = new Tatli();
			  t.setTatliAdi(dbtatli.getTatliadi());
			  t.setTatliId(dbtatli.getTatliid());
			  tatliListesi.add(t);
		  });
		  
		  tatliKafkaModell.setTatliListesi(tatliListesi);
		  return tatliKafkaModell;
		  
	  }

		  
	  
	  public SalataKafkaModel getSalataKafkaModel() {
		  SalataKafkaModel salataKafkaModel = new SalataKafkaModel();
		  List<Salata> salataListesi = new ArrayList<>();
		  Collection<salata> salatalar = salataDao.getAll();
		  
		  salatalar.stream().forEach(dbsalata->{
			  Salata s = new Salata();
			  s.setSalataAdi(dbsalata.getSalataadi());
			  s.setSalataId(dbsalata.getSalataid());
			  salataListesi.add(s);
		  });
		  
		  salataKafkaModel.setSalataListesi(salataListesi);
		  return salataKafkaModel;
	  }
	  
	  
	  public CorbaKafkaModel getCorbaKafkaModel() {
		  CorbaKafkaModel corbaKafkaModel = new CorbaKafkaModel();
		  List<Corba> corbaListesi = new ArrayList<>();
		  Collection<corba> corbalar = corbaDao.getAll();
		  
		  corbalar.stream().forEach(dbcorba->{
			  Corba c = new Corba();
			  c.setCorbaAdi(dbcorba.getCorbaadi());
			  c.setCorbaId(dbcorba.getCorbaid());
			  corbaListesi.add(c);
		  });
		  corbaKafkaModel.setCorbaListesi(corbaListesi);
		  return corbaKafkaModel;
	  }
	  
	  public AnayemekKafkaModel getAnayemekKafkaModel() {
		  AnayemekKafkaModel  anayemekKafkaModel = new AnayemekKafkaModel();
		  List<Anayemek> anayemekListesi = new ArrayList<>();
		  Collection<anayemek> anayemekler =  anayemekDao.getAll();
		  
		  anayemekler.stream().forEach(dbanayemek->{
			  Anayemek a = new Anayemek();
			  a.setAnayemekId(dbanayemek.getAnayemekid());
			  a.setAnayemek(dbanayemek.getAnayemekadi());
			  anayemekListesi.add(a);
		  });
		  anayemekKafkaModel.setAnayemekListesi(anayemekListesi);
		  
		  return anayemekKafkaModel;
	  }
	  
	  public SiparisKafkaModel getSiparisKafkaModel() {
		  SiparisKafkaModel  siparisKafkaModel = new SiparisKafkaModel();
		  List<Siparis> siparisListesi = new ArrayList<>();
		  Collection<SiparisAllContent> siparisler =  siparisDao.getAllContent();
		  
		  siparisler.stream().forEach(dbsiparis->{
			  Siparis s = new Siparis();
			  s.setAnayemekAdi(dbsiparis.getAnayemekAdi());
			  s.setAnayemekId(dbsiparis.getAnayemekId());
			  s.setCorbaAdi(dbsiparis.getCorbaAdi());
			  s.setCorbaId(dbsiparis.getCorbaId());
			  s.setKullaniciAdi(dbsiparis.getKullaniciAdi());
			  s.setKullaniciId(dbsiparis.getKullaniciId());
			  s.setKullaniciSoyadi(dbsiparis.getKullaniciSoyadi());
			  s.setKullaniciTurAdi(dbsiparis.getKullaniciTurAdi());
			  s.setMasaAdi(dbsiparis.getMasaAdi());
			  s.setMasaId(dbsiparis.getMasaId());
			  s.setSalataAdi(dbsiparis.getSalataAdi());
			  s.setSalataId(dbsiparis.getSalataId());
			  s.setSiparisDurumu(dbsiparis.getSiparisDurumu());
			  s.setSiparisId(dbsiparis.getSiparisId());
			  s.setTatliAdi(dbsiparis.getTatliAdi());
			  s.setTatliId(dbsiparis.getTatliId());
			  siparisListesi.add(s);
		  });
		  siparisKafkaModel.setSiparisListesi(siparisListesi);
		  
		  return siparisKafkaModel;
	  }
	  public boolean createNewSiparis(SiparisCRUD siparisCRUD) {
		    //TODO
		  /*Siparis tablsu Create*/
		    siparis s = new siparis();
		    s.setKullaniciid(siparisCRUD.getKullaniciId());
		    s.setMasaid(siparisCRUD.getMasaId());
		    s.setSiparisDurumu(siparisCRUD.getSiparisDurumu().toString());
		    s.setSiparisid(siparisCRUD.getSiparisId());
		    
		    Optional<Integer> retValSiparisDao =  siparisDao.save(s);
		    
		    /*Anayemek Siparis Tablosu*/
		    if(siparisCRUD.getAnayemekAdi()!=null || siparisCRUD.getAnayemekId()!=0) {
		    	anayemeksiparis as = new anayemeksiparis();
		    	as.setAnayemekid(siparisCRUD.getAnayemekId());
		    	as.setSiparisid(retValSiparisDao.get());
		    	Optional<Integer> retValYemekSiparisDao = anayemekSiparisDao.save(as);
		    }
		   
		    /*Corba Siparis Tablosu*/
		    if(siparisCRUD.getCorbaAdi()!=null || siparisCRUD.getCorbaId()!=0) {
		    	corbasiparis cs = new corbasiparis();
		    	cs.setCorbaid(siparisCRUD.getCorbaId());
		    	cs.setSiparisid(retValSiparisDao.get());
		    	Optional<Integer> retValCorbaSiparisDao = corbaSiparisDao.save(cs);
		    }
		    
		    /*Salata Siparis Tablosu*/
		    if(siparisCRUD.getSalataAdi()!=null || siparisCRUD.getSalataId()!=0) {
		    	salatasiparis ss = new salatasiparis();
		    	ss.setSalataid(siparisCRUD.getSalataId());
		    	ss.setSiparisid(retValSiparisDao.get());
		    	Optional<Integer> retValSalataSiparisDao = salataSiparisDao.save(ss);
		    }
		    
		    /*Tatli Siparis Tablosu*/
		    if(siparisCRUD.getTatliAdi()!=null || siparisCRUD.getTatliId()!=0) {
		    	tatlisiparis ts = new tatlisiparis();
		    	ts.setTatliid(siparisCRUD.getTatliId());
		    	ts.setSiparisid(retValSiparisDao.get());
		    	Optional<Integer> retValTatliSiparisDao = tatliSiparisDao.save(ts);
		    }
		    
		    
		    return true;
	  }
	  
	  public boolean deleteSiparis(SiparisCRUD siparisCRUD) {
		  
		  int siparisId = siparisCRUD.getSiparisId();
		  Siparis siparis = atomicSiparisKafkaModel.get().getSiparisListesi().stream()
				  .filter(p->p.getSiparisId() == siparisId).collect(Collectors.toList()).get(0);
		  
		  int anayemekId = siparis.getAnayemekId();
		  int corbaId = siparis.getCorbaId();
		  int salataid = siparis.getSalataId();
		  int tatliid = siparis.getTatliId();
		  int kullaniciId = siparis.getKullaniciId();
		  int masaid = siparis.getMasaId();
		  String siparisDurumu = siparis.getSiparisDurumu().toString();
		  
		    /*Anayemek Siparis Tablosu*/
		    if(anayemekId!=0) {
		    	anayemeksiparis as = new anayemeksiparis();
		    	as.setAnayemekid(anayemekId);
		    	as.setSiparisid(siparisId);
		    	boolean retValYemekSiparisDao = anayemekSiparisDao.delete(as);
		    }
		    /*Corba Siparis Tablosu*/
		    if(corbaId!=0) {
		    	corbasiparis cs = new corbasiparis();
		    	cs.setCorbaid(corbaId);
		    	cs.setSiparisid(siparisId);
		    	boolean retValCorbaSiparisDao = corbaSiparisDao.delete(cs);
		    }
		    /*Salata Siparis Tablosu*/
		    if(salataid!=0) {
		    	salatasiparis ss = new salatasiparis();
		    	ss.setSalataid(salataid);
		    	ss.setSiparisid(siparisId);
		    	boolean retValSalataSiparisDao = salataSiparisDao.delete(ss);
		    }
		    /*Tatli Siparis Tablosu*/
		    if(tatliid!=0) {
		    	tatlisiparis ts = new tatlisiparis();
		    	ts.setTatliid(tatliid);
		    	ts.setSiparisid(siparisId);
		    	boolean retValTatliSiparisDao = tatliSiparisDao.delete(ts);
		    }
		    
		  /*Siparis tablsu Delete*/
		    siparis s = new siparis();
		    s.setKullaniciid(kullaniciId);
		    s.setMasaid(masaid);
		    s.setSiparisDurumu(siparisDurumu);
		    s.setSiparisid(siparisId);
		    
		    boolean retValSiparisDao =  siparisDao.delete(s);
		    
		    return retValSiparisDao;
		    
	  }
	  
	  
	  public boolean updateSiparis(SiparisCRUD siparisCRUD) {
		  int siparisId = siparisCRUD.getSiparisId();
		  Siparis eskisiparis = atomicSiparisKafkaModel.get().getSiparisListesi().stream()
				  .filter(p->p.getSiparisId() == siparisId).collect(Collectors.toList()).get(0);

		  if(!siparisCRUD.getAnayemekAdi().toString().equalsIgnoreCase(eskisiparis.getAnayemekAdi().toString())) {
			  /*anayemeksiparis table update*/
			    if(siparisId!=0 && siparisCRUD.getAnayemekId()!=0) {
			    	anayemeksiparis as = new anayemeksiparis();
			    	as.setAnayemekid(siparisCRUD.getAnayemekId());
			    	as.setSiparisid(siparisId);
			    	boolean retValYemekSiparisDao = anayemekSiparisDao.update(as);
			    }
		  }
		  if(!siparisCRUD.getCorbaAdi().toString().equalsIgnoreCase(eskisiparis.getCorbaAdi().toString())) {
			  /*corbasiparis table update*/
			    if(siparisId!=0 && siparisCRUD.getCorbaId()!=0) {
			    	corbasiparis cs = new corbasiparis();
			    	cs.setCorbaid(siparisCRUD.getCorbaId());
			    	cs.setSiparisid(siparisId);
			    	boolean retValCorbaSiparisDao = corbaSiparisDao.update(cs);
			    }
		  }
		  if(!siparisCRUD.getSalataAdi().toString().equalsIgnoreCase(eskisiparis.getSalataAdi().toString())) {
			  /*salatasiparis table update*/
			    if(siparisId!=0 && siparisCRUD.getSalataId()!=0) {
			    	salatasiparis ss = new salatasiparis();
			    	ss.setSalataid(siparisCRUD.getSalataId());
			    	ss.setSiparisid(siparisId);
			    	boolean retValSalataSiparisDao = salataSiparisDao.update(ss);
			    }
		  }
		  if(!siparisCRUD.getTatliAdi().toString().equalsIgnoreCase(eskisiparis.getTatliAdi().toString())) {
			  /*tatlisiparis table update*/
			    if(siparisId!=0 && siparisCRUD.getTatliId()!=0) {
			    	tatlisiparis ts = new tatlisiparis();
			    	ts.setTatliid(siparisCRUD.getTatliId());
			    	ts.setSiparisid(siparisId);
			    	boolean retValTatliSiparisDao = tatliSiparisDao.update(ts);
			    }
		  }
		  
		  /*update siparis table*/
		    siparis s = new siparis();
		    s.setKullaniciid(siparisCRUD.getKullaniciId());
		    s.setMasaid(siparisCRUD.getMasaId());
		    s.setSiparisDurumu(siparisCRUD.getSiparisDurumu().toString());
		    s.setSiparisid(siparisId);
		    
		    boolean retValSiparisDao =  siparisDao.update(s);
		    
		    return retValSiparisDao;
	  }
	  public boolean publishSiparisler() {
		  /*Get records from database*/
		    try {
				atomicSiparisKafkaModel.set(getSiparisKafkaModel());
				/*Send to Kafka*/
				sender.sendSiparis(atomicSiparisKafkaModel.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		    return true;
	  } 
}
