package tr.com.sakarya.uni.tez.mvc.web;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.sakarya.uni.tez.kafka.models.DKProductInfo;
import tr.com.sakarya.uni.tez.mvc.web.consumer.Receiver;

@Component
public class General {

	@Autowired 
	private Receiver receiver;
	
	public  List<DKProductInfo> getModelProductsInfo() {
		
		if(receiver.atomicProductionInfoTable !=null && 
				receiver.atomicProductionInfoTable.get() !=null &&
				receiver.atomicProductionInfoTable.get().getProductInfoTable() !=null) {
			return receiver.atomicProductionInfoTable.get().getProductInfoTable();
		}
		else {
			List<DKProductInfo> pro = getTestUrunler();
			return pro;
		}
	}
	public DKProductInfo getUrun(int urunId) {
		
		DKProductInfo urun;
		if(receiver.atomicProductionInfoTable !=null && 
				receiver.atomicProductionInfoTable.get() !=null &&
				receiver.atomicProductionInfoTable.get().getProductInfoTable() !=null) {
			
			urun = receiver.atomicProductionInfoTable.get().getProductInfoTable().stream().filter(p->p.getUrunId()==urunId).findFirst().get();
		}
		else {
			urun=null;
		}
		return urun;
	} 
	
	public List<String> getDepolar(){
		
		Set<String> depolar = new  HashSet<>();//.unique set işlemi.
		
		if(receiver.atomicProductionInfoTable !=null && 
				receiver.atomicProductionInfoTable.get() !=null &&
				receiver.atomicProductionInfoTable.get().getProductInfoTable() !=null) {
			 receiver.atomicProductionInfoTable.get().getProductInfoTable().stream().forEach(depo->{
				 depolar.add(depo.getDepoAdi().toString());
			 });
			 return depolar.stream().collect(Collectors.toList());
		}else {
			
			List<DKProductInfo> pro = getTestUrunler();
			pro.stream().forEach(p->{
				depolar.add(p.getDepoAdi().toString());
			});
			 return depolar.stream().collect(Collectors.toList());
		}
	}
	
	
	private List<DKProductInfo> getTestUrunler(){
		ArrayList<DKProductInfo> pro = new ArrayList<>();
		DKProductInfo a = new DKProductInfo();
		a.setDepoAdi("test");
		a.setDepoId(1);
		a.setMarkaAdi("aaa");
		a.setMarkaId(1);
		a.setUrunAdi("bbb");
		a.setUrunId(1);
		a.setUrunTurAdi("asdasd");
		a.setUrunTurId(1);
		pro.add(a);
		
		DKProductInfo b = new DKProductInfo();
		b.setDepoAdi("abc");
		b.setDepoId(1);
		b.setMarkaAdi("aaa");
		b.setMarkaId(1);
		b.setUrunAdi("bbb");
		b.setUrunId(2);
		b.setUrunTurAdi("asdasd");
		b.setUrunTurId(2);
		pro.add(b);
		
		DKProductInfo b1 = new DKProductInfo();
		b1.setDepoAdi("abc");
		b1.setDepoId(1);
		b1.setMarkaAdi("asdasdas");
		b1.setMarkaId(1);
		b1.setUrunAdi("bw2313123b");
		b1.setUrunId(3);
		b1.setUrunTurAdi("12314");
		b1.setUrunTurId(3);
		pro.add(b1);
		return pro;
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
