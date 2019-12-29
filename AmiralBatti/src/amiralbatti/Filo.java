/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

/**
 *
 * @author serdar
 */
public  enum  Filo{
        UZUNLUK_4_GEMI(4,1),//4 uzunluklu gemiden 1 adet
        UZUNLUK_3_GEMI(3,2),//3 uzunluklu gemiden 2 adet
        UZUNLUK_2_GEMI(2,3),//2 uzunluklu gemiden 3 adet
        UZUNLUK_1_GEMI(1,4);//1 uzunluklu gemiden 4 adet

        private final int gemiUzunlugu;
        private final int gemiAdeti;
        Filo(int gemiUzunlugu, int gemiAdeti) {
            this.gemiUzunlugu = gemiUzunlugu;
            this.gemiAdeti = gemiAdeti;
        }
      public int gemiUzunlugu() {
            return gemiUzunlugu;
        }
       public int gemiAdeti() {
            return gemiAdeti;
        }
       
       public static Filo getEnumFromValue(int  gemiUzunluk){
            switch(gemiUzunluk){
                case 4 :
                    return Filo.UZUNLUK_4_GEMI;
               case  3 :
                    return Filo.UZUNLUK_3_GEMI;
               case  2 :
                    return Filo.UZUNLUK_2_GEMI;
               case  1 :
                    return Filo.UZUNLUK_1_GEMI;
               default:
                   return Filo.UZUNLUK_4_GEMI;
                        
            }
        }
   
        //Filo adet = Filo.UZUNLUK_4_GEMI;
        /* private final int adet;
        Filo(int adet) {
            this.adet = adet;
        }
        
        public int getAdet() {
            return this.adet;
        }    
        */
    }
