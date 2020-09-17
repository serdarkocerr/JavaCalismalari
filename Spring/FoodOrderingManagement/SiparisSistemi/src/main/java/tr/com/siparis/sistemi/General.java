package tr.com.siparis.sistemi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.siparis.sistemi.consumer.KafkaReceiver;
import tr.com.siparis.sistemi.kafka.model.Anayemek;
import tr.com.siparis.sistemi.kafka.model.Corba;
import tr.com.siparis.sistemi.kafka.model.Masa;
import tr.com.siparis.sistemi.kafka.model.Salata;
import tr.com.siparis.sistemi.kafka.model.Siparis;
import tr.com.siparis.sistemi.kafka.model.Tatli;


@Component
public class General {

	@Autowired 
	private KafkaReceiver receiver;
	
	
	public Siparis getSiparis(int siparisId) {
		
		if(receiver.atomicSiparisKafkaModel !=null && 
				receiver.atomicSiparisKafkaModel.get() !=null &&
				receiver.atomicSiparisKafkaModel.get().getSiparisListesi() !=null) {
				Siparis sp = receiver.atomicSiparisKafkaModel.get().getSiparisListesi().stream().filter(p->p.getSiparisId() == siparisId)
												.collect(Collectors.toList()).get(0);
				
					return sp;
				}
		else
			return null;
	}
	public List<Siparis> getSiparisler(){
		if(receiver.atomicSiparisKafkaModel !=null && 
		receiver.atomicSiparisKafkaModel.get() !=null &&
		receiver.atomicSiparisKafkaModel.get().getSiparisListesi() !=null) {
			return receiver.atomicSiparisKafkaModel.get().getSiparisListesi();
		}
		else {
			List<Siparis> sip = getTestSiparisler();
			return sip;
		}
	}
	private List<Siparis> getTestSiparisler(){
		ArrayList<Siparis> pro = new ArrayList<>();
		Siparis a = new Siparis();
		a.setAnayemekAdi("anayemektest");
		a.setAnayemekId(1);
		a.setCorbaAdi("testcorba");
		a.setCorbaId(1);
		a.setKullaniciAdi("testuser");
		a.setKullaniciId(1);
		a.setKullaniciSoyadi("testsoyadi");
		a.setKullaniciTurAdi("garson");
		a.setKullaniciTurId(1);
		a.setMasaAdi("A1");
		a.setMasaId(10);
		a.setSalataAdi("testsalata");
		a.setSalataId(1);
		a.setSiparisDurumu("hazirlaniyortest");
		a.setSiparisId(1);
		a.setTatliAdi("testtatli");
		a.setTatliId(1);
		pro.add(a);
		
		Siparis b = new Siparis();
		b.setAnayemekAdi("anayemektest2");
		b.setAnayemekId(1);
		b.setCorbaAdi("testcorba2");
		b.setCorbaId(1);
		b.setKullaniciAdi("testuse2r");
		b.setKullaniciId(1);
		b.setKullaniciSoyadi("testsoyadi2");
		b.setKullaniciTurAdi("garson2");
		b.setKullaniciTurId(1);
		b.setMasaAdi("B1");
		b.setMasaId(10);
		b.setSalataAdi("testsalata2");
		b.setSalataId(1);
		b.setSiparisDurumu("hazirlaniyortest2");
		b.setSiparisId(1);
		b.setTatliAdi("testtatli2");
		b.setTatliId(1);
		pro.add(b);
		
		return pro;
	}
	public List<String> getMasalar(){
		
		Set<String> masalar = new  HashSet<>();//.unique set işlemi.
		TreeSet<String> masalarOrdered = new TreeSet();
		
		if(receiver.atomicMasaKafkaModel !=null && 
				receiver.atomicMasaKafkaModel.get() !=null &&
				receiver.atomicMasaKafkaModel.get().getMasaListesi() !=null) {
			 receiver.atomicMasaKafkaModel.get().getMasaListesi().stream().forEach(masa->{
				 masalar.add(masa.getMasaAdi().toString());
			 });
			
			
		}else {
			
			List<Masa> msa = getTestMasalar();
			msa.stream().forEach(p->{
				masalar.add(p.getMasaAdi().toString());
			});
		//	 return masalar.stream().collect(Collectors.toList());
		}
		 masalarOrdered.addAll(masalar);
		 return  masalarOrdered.stream().collect(Collectors.toList());
	}
	private List<Masa> getTestMasalar(){
		List<Masa> ms = new ArrayList<>();
		Masa a = new Masa();
		a.setMasaAdi("A1");
		a.setMasaId(1);
		ms.add(a);
	
		Masa b = new Masa();
		b.setMasaAdi("B1");
		b.setMasaId(10);
		ms.add(b);
	
		Masa c = new Masa();
		c.setMasaAdi("C1");
		c.setMasaId(20);
		ms.add(c);
		
		return ms;
	}
	public List<String> getCorbalar(){
		Set<String> corbalar = new  HashSet<>();//.unique set işlemi.
		TreeSet<String> corbalarOrdered = new TreeSet();

		if(receiver.atomicCorbaKafkaModel !=null && 
				receiver.atomicCorbaKafkaModel.get() !=null &&
				receiver.atomicCorbaKafkaModel.get().getCorbaListesi() !=null) {
			 receiver.atomicCorbaKafkaModel.get().getCorbaListesi().stream().forEach(corba->{
				 corbalar.add(corba.getCorbaAdi().toString());
			 });
			 //return corbalar.stream().collect(Collectors.toList());
		}else {
			
			List<Corba> cb = getTestCorbalar();
			cb.stream().forEach(p->{
				corbalar.add(p.getCorbaAdi().toString());
			});
			// return corbalar.stream().collect(Collectors.toList());
		}
		corbalarOrdered.addAll(corbalar);
		return corbalarOrdered.stream().collect(Collectors.toList());
	}
	private List<Corba> getTestCorbalar(){
		List<Corba> cb = new ArrayList<>();
		Corba a = new Corba();
		a.setCorbaAdi("Mercimek");
		a.setCorbaId(1);
		cb.add(a);
		
		Corba v = new Corba();
		v.setCorbaAdi("Ezogelin");
		v.setCorbaId(1);
		cb.add(v);
		
		return cb;
	}
	
	
	public List<String> getAnaYemekler(){
		Set<String> anayemekler = new  HashSet<>();//.unique set işlemi.
		TreeSet<String> anayemeklerOrdered = new TreeSet();

		if(receiver.atomicAnayemekKafkaModel !=null && 
				receiver.atomicAnayemekKafkaModel.get() !=null &&
				receiver.atomicAnayemekKafkaModel.get().getAnayemekListesi() !=null) {
			 receiver.atomicAnayemekKafkaModel.get().getAnayemekListesi().stream().forEach(ayemek->{
				 anayemekler.add(ayemek.getAnayemek().toString());
			 });
			// return anayemekler.stream().collect(Collectors.toList());
		}else {
			
			List<Anayemek> cb = getTestAnayemekler();
			cb.stream().forEach(p->{
				anayemekler.add(p.getAnayemek().toString());
			});
			// return anayemekler.stream().collect(Collectors.toList());
		}
		anayemeklerOrdered.addAll(anayemekler);
		return anayemeklerOrdered.stream().collect(Collectors.toList());
	}
	private List<Anayemek> getTestAnayemekler(){
		List<Anayemek> cb = new ArrayList<>();
		Anayemek a = new Anayemek();
		a.setAnayemek("KuruFasulye");
		a.setAnayemekId(1);
		cb.add(a);
		
		Anayemek v = new Anayemek();
		v.setAnayemek("Pilav");
		v.setAnayemekId(1);
		cb.add(v);
		
		return cb;
	}
	
	
	public List<String> getSalatalar(){
		Set<String> salatalar = new  HashSet<>();//.unique set işlemi.
		TreeSet<String> salatalarOrdered = new TreeSet();

		if(receiver.atomicSalataKafkaModel !=null && 
				receiver.atomicSalataKafkaModel.get() !=null &&
				receiver.atomicSalataKafkaModel.get().getSalataListesi() !=null) {
			 receiver.atomicSalataKafkaModel.get().getSalataListesi().stream().forEach(salata->{
				 salatalar.add(salata.getSalataAdi().toString());
			 });
			// return salatalar.stream().collect(Collectors.toList());
		}else {
			
			List<Salata> cb = getTestSalatalar();
			cb.stream().forEach(p->{
				salatalar.add(p.getSalataAdi().toString());
			});
			// return salatalar.stream().collect(Collectors.toList());
		}
		salatalarOrdered.addAll(salatalar);
		return salatalarOrdered.stream().collect(Collectors.toList());
	}
	private List<Salata> getTestSalatalar(){
		List<Salata> cb = new ArrayList<>();
		Salata a = new Salata();
		a.setSalataAdi("Coban");
		a.setSalataId(1);
		cb.add(a);
		
		Salata v = new Salata();
		v.setSalataAdi("Kis");
		v.setSalataId(2);
		cb.add(v);
		
		return cb;
	}
	public List<String> getTatlilar(){
		Set<String> tatlilar = new  HashSet<>();//.unique set işlemi.
		TreeSet<String> tatlilarOrdered = new TreeSet();

		if(receiver.atomicTatliKafkaModel !=null && 
				receiver.atomicTatliKafkaModel.get() !=null &&
				receiver.atomicTatliKafkaModel.get().getTatliListesi() !=null) {
			 receiver.atomicTatliKafkaModel.get().getTatliListesi().stream().forEach(tatli->{
				 tatlilar.add(tatli.getTatliAdi().toString());
			 });
			// return tatlilar.stream().collect(Collectors.toList());
		}else {
			
			List<Tatli> cb = getTestTatlilar();
			cb.stream().forEach(p->{
				tatlilar.add(p.getTatliAdi().toString());
			});
			// return tatlilar.stream().collect(Collectors.toList());
		}
		tatlilarOrdered.addAll(tatlilar);
		return tatlilarOrdered.stream().collect(Collectors.toList());

	}
	private List<Tatli> getTestTatlilar(){
		List<Tatli> cb = new ArrayList<>();
		Tatli a = new Tatli();
		a.setTatliAdi("Revani");
		a.setTatliId(1);
		cb.add(a);
		
		Tatli v= new Tatli();
		v.setTatliAdi("Baklava");
		v.setTatliId(1);
		cb.add(v);
		
		return cb;
	}
	public Object convertPostReceivedToObject(String clz, String recVal){
		Object obj =null;
		try {
			
			String[] recValParts = recVal.trim().split("&");
			String [] recValFields = new String[recValParts.length];
			String [] recValVals = new String[recValParts.length];

			for (int i=0;i<recValParts.length;i++) {
				recValFields[i] = recValParts[i].trim().split("=")[0];
				recValVals[i] = recValParts[i].trim().split("=")[1];

			}

			obj = Class.forName(clz).getConstructor().newInstance();
			 Field[] fields = Class.forName(clz).getFields();
			 for(int i=0;i<fields.length;i++) {
				 for(int k=0; k<recValFields.length;k++) {
					 if(fields[i].toString().contains(recValFields[k])) {
						 
						Class fieldType =  fields[i].getType();
						obj.getClass().getField(recValFields[k]).set(obj, recValVals[k]);
					 }
				 }
			 }
				 
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}
}
