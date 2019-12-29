/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author serdar kocer
 * @date 31 October 2019
 * 
 */
/*   1 2 3 4 5 6 7 8 9 10
*A   X X X 1 X X 2 2 X X
*B   X X X X X X X X X X
*C   4 4 4 4 X X X X X 3
*D   X X X X X X X 1 X 3
*E   3 3 3 X X X X X X 3
*F   X X X X X X X X X X
*G   2 2 X X X 1 X X X X
*H   X X X X X X X X X 2
*I   X X X X 1 X X X X 2
*J   X X X X X X X X X X
*/
public class AmiralBatti {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Generals generals = new Generals();
        int vurulanGemiUzunlugu = 0;
        int atisSayac = 0;
        boolean isButunGemilerVuruldu = false;
        
        String[][] gemiKoordinatlari = dondurRandomGemiKoordinatlari( generals);

        while(!isButunGemilerVuruldu){
            System.out.println("<====================OYUN ALANI GEMI DIZILIMI ====================>");
            for(int i = 0; i< 11; i++){
                  System.out.print( " "+Generals.boylamPrintOut[i] +" " );
            }
            System.out.println();
            for(int i =0; i<10; i++){
                 System.out.print( " "+ Generals.enlem[i] +" " );
                for(int k = 0; k<10 ; k++){
                    System.out.print(" "+Generals.oyunAlaniGemiDizilisi[i][k] + " ");
                }
                System.out.println();
            }
            System.out.println("<====================OYUN ALANI ====================>");
            for(int i = 0; i< 11; i++){
                  System.out.print( " "+Generals.boylamPrintOut[i] +" " );
            }
            System.out.println();
            
            for(int i =0; i<10; i++){
                  System.out.print( " "+ Generals.enlem[i] +" " );
                for(int k = 0; k<10 ; k++){
                    System.out.print( " "+Generals.oyunAlaniGosterilen[i][k] + " ");
                }
                System.out.println();
            }
            System.out.println("Satir Giriniz (A-J) : ");
            Scanner insat = new Scanner(System.in);
            String satirStr = insat.nextLine().toUpperCase();
            System.out.println("Sutun Giriniz (1-10) : ");
            Scanner insut = new Scanner(System.in);
            String sutunStr = insut.nextLine().toUpperCase();
            if(!isValidSatirSutun(satirStr,sutunStr)){
                 System.out.println(" Gecersiz giris yaptiniz. Tekrar giris yapiniz." ); 
                 continue;
            }
            
            int satir = (Generals.mapSatirInteger.get(satirStr) -1);//dizi icin -1
            int sutun = (Integer.valueOf(sutunStr) -1);
            atisSayac++;
            if(Generals.oyunAlaniGosterilen[satir][sutun].equalsIgnoreCase("A")){//A Atis yapildi manasindadir.
                System.out.println("Bu konuma daha once atis yapildi!!! ");
                continue;
            }
            
            if(!Generals.oyunAlaniGemiDizilisi[satir][sutun].equalsIgnoreCase("X")){//Gemi var manasindadir.
                String strLiLu = "";
                if(Generals.oyunAlaniGemiDizilisi[satir][sutun].equalsIgnoreCase("1") || 
                        Generals.oyunAlaniGemiDizilisi[satir][sutun].equalsIgnoreCase("2"))
                    strLiLu = "'li";
                else
                    strLiLu = "'lu";
                 System.out.println("Bir " + Generals.oyunAlaniGemiDizilisi[satir][sutun] + strLiLu + " yara aldi."  );
                 vurulanGemiUzunlugu++;
                 
                 if(vurulanGemiUzunlugu == Generals.gemilerinToplamUzunlugu){
                     isButunGemilerVuruldu = true;
                 }
            
                Generals.oyunAlaniGosterilen[satir][sutun] = Generals.oyunAlaniGemiDizilisi[satir][sutun];
            }else{
                Generals.oyunAlaniGosterilen[satir][sutun] = "A";//Atis yapilan alan isaretlenir. ve kulanicaya gosterilir.
            }
         }
         System.out.println("Bravo " + atisSayac + ". atista butun gemileri vurdunuz. " );
        
    }
    
   public static  boolean  isValidSatirSutun(String satirStr, String sutunStr){
        boolean satir  = false;
        boolean sutun = false;
        
        for(int i = 0; i<Generals.oyunAlaniEnlemUzunluk; i++){
            if(Generals.enlem[i].equalsIgnoreCase( satirStr)){
                satir=true;
            }
            if(Generals.boylam[i].equalsIgnoreCase( sutunStr)){
                sutun=true;
            }
        }
       return (satir &&  sutun);
    }
    
        
    //gemi koordinatlarini dondurur. 1. A-5 A-9 vs.
    // boylam koordinati random olarak belirlenir 
    //.
    public static String[][] dondurRandomGemiKoordinatlari(Generals generals){
        String[][] retVal = new String[4][4];//4-3-2-1
        boolean isSag = false;
        boolean isYukari = false;
        
        Integer gemiboyu = Filo.UZUNLUK_4_GEMI.gemiUzunlugu();
        while(gemiboyu>0) {
           try {
              //baslangic noktasi bulunur.
              int enlemKoordBas = ((int)((Math.random()*1000) % 10))+1;//A(1)-J(10) arasi
              int boylamKoordBas = ((int)((Math.random()*1000) % 10))+1;//1-10 arasi
              boolean isEnlem = (((int)(Math.random() * 1000) % 2) == 0) ? false:true;//enlem de mi uzanacak boylamda mi?
              System.out.println("isEnlem =>" + isEnlem);
              System.out.println("gemiboyu =>" + gemiboyu);
              System.out.println("Mevcut gemiAdeti =>" + generals.getMapMatristekiGemiAdeti().get(Filo.getEnumFromValue(gemiboyu)));
              System.out.println("enlemKoordBas =>" + enlemKoordBas);
              System.out.println("boylamKoordBas =>" + boylamKoordBas); 
              // hangi yone dogru olacagini belirleriz.
             if(isEnlem){
                 if(boylamKoordBas >(Generals.oyunAlaniBoylamUzunluk - gemiboyu + 1)){//sagda 3 kaldi mecburen sola 
                         if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,"sol"))
                           continue;
                          gemiyiSolaKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                          isSag = false;
                 }else if(boylamKoordBas<(gemiboyu)){//solda 3 kaldi mecburen saga
                          if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,"sag"))
                           continue;
                          gemiyiSagaKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                          isSag = true;
                 }else{ // enlemKoordinat her iki yon(sag-sol) icin alan var.
                       isSag = ((Math.random() * 1000 % 2) == 0) ? false:true;//saga mi sola mi
                       if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,(isSag)?"sag":"sol"))
                            continue;
                       if(isSag){//sag
                           gemiyiSagaKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                       }else{//sol
                           gemiyiSolaKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                    }
                  }                           
               }else{//Boylam
                   if(enlemKoordBas >(Generals.oyunAlaniEnlemUzunluk - gemiboyu + 1)){//asagida 3 kaldi mecburen yukari 
                       if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,"yukari"))
                           continue;
                          gemiyiYukariKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                          isYukari = true;
                  }else if(enlemKoordBas<(gemiboyu)){//yukari 3 kaldi mecburen asagi
                      if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,"asagi"))
                           continue;
                          gemiyiAsagiKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                          isYukari = false;
                  }else{ // enlemKoordinat her iki yon(sag-sol) icin alan var.
                         isYukari = ((Math.random() * 1000 % 2) == 0) ? false:true;//yukari mi asagi mi
                           if(isKoordinatDolu(enlemKoordBas-1,boylamKoordBas-1,gemiboyu,(isYukari)?"yukari":"asagi"))
                               continue;
                          if(isYukari){//yukari
                              gemiyiYukariKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());
                          }else{//asagi
                              gemiyiAsagiKoy((enlemKoordBas-1),(boylamKoordBas-1),gemiboyu.toString());    
                          }
                  }             
              }
             /*oyun saha matrisindeki gemi adetini suanda var olani olmasi gereken  ile  karsilastiriyoruz
             Ornegin 3 boyutlu gemiden 2 tane koyulduysa gemboyunu = 2 yapiyoruz ki 2 boyutlu gemiyi koysun*/
             System.out.println("TEST SERDAR ---------------------------->");
             Filo gemiEnum = Filo.getEnumFromValue(gemiboyu);
             int currentGemiAdeti = generals.getMapMatristekiGemiAdeti().get(gemiEnum);
             currentGemiAdeti++;
             generals.getMapMatristekiGemiAdeti().put(gemiEnum, (currentGemiAdeti));
             if(generals.getMapMatristekiGemiAdeti().get(gemiEnum).equals(gemiEnum.gemiAdeti()) ){
               gemiboyu--;   
             }
              
           } catch (Exception e) {
               e.printStackTrace();
           }
               
        }  
         
       return retVal;
}

    
    public static void gemiyiSagaKoy(int enlemKoordinatBaslangic, int byolamKoordinatBaslangic, String gemiBoyu){
        System.out.println("gemiyiSagaKoy : enlemKoordinatBaslangic= " +(enlemKoordinatBaslangic + 1) + " byolamKoordinatBaslangic =" +(byolamKoordinatBaslangic + 1));
        int gemiBoyuVal = Integer.valueOf(gemiBoyu);
        for(int i= 0; i<gemiBoyuVal; i++){
            Generals.oyunAlaniGemiDizilisi[enlemKoordinatBaslangic][byolamKoordinatBaslangic + i] = gemiBoyu;
        }      
    }
     public static void gemiyiSolaKoy(int enlemKoordinatBaslangic, int byolamKoordinatBaslangic, String gemiBoyu){
        System.out.println("gemiyiSagaKoy : enlemKoordinatBaslangic= " +(enlemKoordinatBaslangic + 1) + " byolamKoordinatBaslangic =" +(byolamKoordinatBaslangic + 1));
        int gemiBoyuVal = Integer.valueOf(gemiBoyu);
        for(int i= 0; i<gemiBoyuVal; i++){
             Generals.oyunAlaniGemiDizilisi[enlemKoordinatBaslangic][byolamKoordinatBaslangic - i] = gemiBoyu;
        }
   }
     
    public static void gemiyiYukariKoy(int enlemKoordinatBaslangic, int byolamKoordinatBaslangic, String gemiBoyu){
        System.out.println("gemiyiYukariKoy : enlemKoordinatBaslangic= " +(enlemKoordinatBaslangic + 1) + " byolamKoordinatBaslangic =" +(byolamKoordinatBaslangic + 1));
        int gemiBoyuVal = Integer.valueOf(gemiBoyu);
        for(int i= 0; i<gemiBoyuVal; i++){
             Generals.oyunAlaniGemiDizilisi[enlemKoordinatBaslangic - i][byolamKoordinatBaslangic ] = gemiBoyu;
        }        
    }
    public static void gemiyiAsagiKoy(int enlemKoordinatBaslangic, int byolamKoordinatBaslangic, String gemiBoyu){
        System.out.println("gemiyiAsagiKoy : enlemKoordinatBaslangic= " +(enlemKoordinatBaslangic + 1) + " byolamKoordinatBaslangic =" +(byolamKoordinatBaslangic + 1));
        int gemiBoyuVal = Integer.valueOf(gemiBoyu);
        for(int i= 0; i<gemiBoyuVal; i++){
             Generals.oyunAlaniGemiDizilisi[enlemKoordinatBaslangic + i][byolamKoordinatBaslangic ] = gemiBoyu;
        }
    }
    public  static boolean isKoordinatDolu(int enlemKoordBas,int boylamKoordBasm,int gemiBoyu,String yon) {
       boolean retVal =true;
       int tempEnlemKoor = enlemKoordBas;
       int tempBoylamKoor = boylamKoordBasm;
       System.out.println("isKoordinatDolu gelen k = enlemKoordBas :" + enlemKoordBas + " boylamKoordBasm :" +boylamKoordBasm);

        try {
            String gBoyu = String.valueOf(gemiBoyu);
             List<String> yonBilgileri = kontrolYonBilgileriDondur( enlemKoordBas, boylamKoordBasm, gemiBoyu, yon);
             System.out.print("yon bilgisi =>" );
             yonBilgileri.stream().forEach(p->{System.out.print(" , " + p);});
              System.out.println(" " );
             for(int i=0; i<gemiBoyu; i++){
                
                 
                 System.out.println("isKoordinatDolu  = tempEnlemKoor :" + tempEnlemKoor + " tempBoylamKoor :" +tempBoylamKoor);
                 
                 for (String y : yonBilgileri) {
                    switch(y){
                      case "sag":
                            System.out.println("sag => calisti");
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor][tempBoylamKoor + 1].equalsIgnoreCase("X"))
                                 return true;                  
                          retVal =false;
                          continue;
                      case "sol":
                              System.out.println("sol => calisti");
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor][tempBoylamKoor - 1].equalsIgnoreCase("X"))
                                 return true;
                          retVal =false;
                          continue;
                      case "yukari":
                              System.out.println("yukari => calisti");                          
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor - 1][tempBoylamKoor ].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                      case "asagi":
                              System.out.println("asagi => calisti");                                                    
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor + 1][tempBoylamKoor ].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                      case "yukarisol":
                              System.out.println("yukarisol => calisti");                                                                              
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor - 1][tempBoylamKoor -1].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                      case "yukarisag":
                              System.out.println("yukarisag => calisti");                                                                                                        
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor - 1][tempBoylamKoor +1].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                      case "asagisol":
                              System.out.println("asagisol => calisti");                                                                                                                                 
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor + 1][tempBoylamKoor -1].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                      case "asagisag":
                              System.out.println("asagisag => calisti");                                                                                                                                                           
                             if(!Generals.oyunAlaniGemiDizilisi[tempEnlemKoor + 1][tempBoylamKoor +1].equalsIgnoreCase("X"))
                                return true;
                          retVal =false;
                          continue;
                       default:
                          break;
                    }
                }

                 if(yon.equalsIgnoreCase("sol"))  {                   
                      if((tempBoylamKoor == 1) ||  (tempBoylamKoor == 8))
                          continue;
                    tempBoylamKoor--;
                 }else if(yon.equalsIgnoreCase("sag")){
                       if((tempBoylamKoor == 1) ||  (tempBoylamKoor == 8))
                          continue;
                     tempBoylamKoor++;
                 }else if(yon.equalsIgnoreCase("yukari")){
                    if((tempEnlemKoor == 1) ||  (tempEnlemKoor == 8))
                          continue;
                    tempEnlemKoor--;
                 }else if(yon.equalsIgnoreCase("asagi")){
                    if((tempEnlemKoor == 1) ||  (tempEnlemKoor == 8))
                          continue;
                    tempEnlemKoor++;
                 }else
                     return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
             
     return retVal;        
   }
    
   public static ArrayList<String> kontrolYonBilgileriDondur(int enlemKoordBas,int boylamKoordBasm,int gemiBoyu,String yon){
    //    String[] yonBilgileri = {"sag","sol","yukari","asagi","yukarisol","yukarisag","asagisol","asagisag"};
         ArrayList<String> yonBilgileri = new ArrayList<String>();
       try {
              
            if(enlemKoordBas == 0 && boylamKoordBasm == 0){
                String[] array = {"sag","asagi","asagisag"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas == 0 && boylamKoordBasm == 9){
                 String[] array = {"sol","asagi","asagisol"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas == 9 && boylamKoordBasm == 0){
                 String[] array = {"sag","yukari","yukarisag"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas == 9 && boylamKoordBasm == 9){
                 String[] array = {"sol","yukari","yukarisol"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas == 0 && boylamKoordBasm != 0 ){
                  String[] array = {"sag","sol","asagi","asagisol","asagisag"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas == 9 && boylamKoordBasm != 0 ){
                  String[] array = {"sag","sol","yukari","yukarisol","yukarisag"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas != 0 && boylamKoordBasm == 0 ){
                  String[] array = {"sag","yukari","asagi","yukarisag","asagisag"};
                Collections.addAll(yonBilgileri, array);
            }else if(enlemKoordBas != 0 && boylamKoordBasm == 9 ){
                  String[] array = {"sol","yukari","asagi","yukarisol","asagisol"};
                Collections.addAll(yonBilgileri, array);
            }else{
                String[] array = {"sag","sol","yukari","asagi","yukarisol","yukarisag","asagisol","asagisag"};
                Collections.addAll(yonBilgileri, array);
            }
        } catch (Exception e) {
               e.printStackTrace();
        }
       
       return yonBilgileri;
    }

}



