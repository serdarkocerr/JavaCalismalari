package amiralbatti;


import amiralbatti.Filo;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author serdar
 */
public class Generals {
    
    
    public Generals(){
         initializeOyunAlani();
        initializeMapSatirInteger();
    }
    
    public  Map<Filo, Integer> mapMatristekiGemiAdeti = Stream.of(new Object[][] { 
    { Filo.UZUNLUK_4_GEMI, 0 }, 
    { Filo.UZUNLUK_3_GEMI, 0 }, 
    { Filo.UZUNLUK_2_GEMI, 0 }, 
    { Filo.UZUNLUK_1_GEMI, 0 }
    }).collect(Collectors.toMap(data -> (Filo) data[0], data -> (Integer) data[1]));
   
   // public   Map<Filo, Integer> mapMatristekiGemiAdeti = new HashMap<>();
    final   static  public int oyunAlaniEnlemUzunluk = 10;
    final   static public int oyunAlaniBoylamUzunluk = 10;
    public  static String[][] oyunAlaniGemiDizilisi = new String[10][10];
    public  static String[][] oyunAlaniGosterilen = new String[10][10];

    public static String[] enlem  = {"A","B","C","D","E","F","G","H","I","J"};
    public static String[] boylam  = {"1","2","3","4","5","6","7","8","9","10"};  
    public static String[] boylamPrintOut  = {" ","1","2","3","4","5","6","7","8","9","10"};  

    final static char[] CHARSET_AZ = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static HashMap<String, Integer > mapSatirInteger = new HashMap<>();
    public final static int gemilerinToplamUzunlugu = (4*1) + (3*2) +(2*3) +(1*4);
    
    Map<Filo, Integer>  getMapMatristekiGemiAdeti(){ 
        return mapMatristekiGemiAdeti;
    }
    
        //oyun alaninin bos halini olusturur.
    public static void initializeOyunAlani(){
        for(int uzunluk = 0; uzunluk<Generals.oyunAlaniEnlemUzunluk ; uzunluk++){
            for(int genislik = 0; genislik<Generals.oyunAlaniBoylamUzunluk ; genislik++){
                Generals.oyunAlaniGemiDizilisi[uzunluk][genislik] = "X";
                Generals.oyunAlaniGosterilen[uzunluk][genislik] = "X";
            } 
        }
    }
    // enlem alfabetik degerlerin sasyisal karsiliklari
    public static void initializeMapSatirInteger(){ 
        
         for(int uzunluk = 0; uzunluk<Generals.oyunAlaniEnlemUzunluk ; uzunluk++){
           mapSatirInteger.put(enlem[uzunluk], Integer.valueOf(boylam[uzunluk]));

        }
    }
}
