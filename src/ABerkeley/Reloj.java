/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABerkeley;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Reloj implements Runnable{
    
  private int hr,  min, segundo;
  String servidor;
  Thread h1;
  
   public Reloj(){
       Calendar calendario = new GregorianCalendar();
       Date fechaHoraActual = new Date();
       hr = Integer.parseInt(calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY));
       min = Integer.parseInt(calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE));
       segundo = Integer.parseInt(calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND));
       h1 = new Thread(this);
       h1.start();
   }
   
  
   
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            this.servidor=this.sumar(1);
           // System.out.println(this.servidor);
           // System.out.println("El otro: "+Reloj.sumar(hr, min, segundo, 60));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
   
    
   public  String sumar(int seg){
       String fecha ="";
       String ph="", pm="", ps="";
         
       if(0>seg){
         //Restar segundo a una hora;
          int auxSeg;
               auxSeg=-segundo;
       while(seg!=0){     
          if(seg<auxSeg){
               //Donde esta fallando
               seg+=segundo;
               segundo=60;
               min--;
               auxSeg=-segundo;
               System.out.println("");
         }else{   
           segundo+=seg;
           seg=0;
       } 
       }
         if(segundo>=60){
             segundo=0;
             min--;
         }
         if(min>=60){
             min-=60;
             hr--;
         }
       } else{
       int auxSeg;
       auxSeg=60-segundo;
       
       while(seg!=0){
          if(seg>auxSeg){
         seg-=auxSeg;
         segundo=0;
         min++;
         auxSeg=60-segundo;     
         }else{
           segundo+=seg;
           seg=0;
       } 
       }
       
         if(segundo>=60){
             segundo=0;
             min++;
         }
         if(min>=60){
             min-=60;
             hr++;
         }
         
       }
       
       if(hr<10){
             ph="0"+hr;
         }else{
             ph=Integer.toString(hr);
         } 
       
       if(min<10){
             pm="0"+min;
         }else{
             pm=Integer.toString(min);
         }
         
         if(segundo<10){
             ps="0"+segundo;
         }else{
             ps=Integer.toString(segundo);
         }
         
         fecha=ph+":"+pm+":"+ps;
       
       return fecha;
   }
   
   
   public static String sumar(int hr, int min, int segundo, int seg){
       String fecha ="";
       String ph="", pm="", ps="";
         
       if(0>seg){
         //Restar segundo a una hora;
          int auxSeg;
               auxSeg=-segundo;
       while(seg!=0){     
          if(seg<auxSeg){
               //Donde esta fallando
               seg+=segundo;
               segundo=60;
               min--;
               auxSeg=-segundo;
               System.out.println("");
         }else{   
           segundo+=seg;
           seg=0;
       } 
       }
         if(segundo>=60){
             segundo=0;
             min--;
         }
         if(min>=60){
             min-=60;
             hr--;
         }
       } else{
       int auxSeg;
       auxSeg=60-segundo;
       
       while(seg!=0){
          if(seg>auxSeg){
         seg-=auxSeg;
         segundo=0;
         min++;
         auxSeg=60-segundo;     
         }else{
           segundo+=seg;
           seg=0;
       } 
       }
       
         if(segundo>=60){
             segundo=0;
             min++;
         }
         if(min>=60){
             min-=60;
             hr++;
         }
         
       }
       
       if(hr<10){
             ph="0"+hr;
         }else{
             ph=Integer.toString(hr);
         } 
       
       if(min<10){
             pm="0"+min;
         }else{
             pm=Integer.toString(min);
         }
         
         if(segundo<10){
             ps="0"+segundo;
         }else{
             ps=Integer.toString(segundo);
         }
         
         fecha=ph+":"+pm+":"+ps;
       
       return fecha;
   }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getSegundo() {
        return segundo;
    }

    public String getServidor() {
        return servidor;
    }
   
    
   public static void main(String args[]){
       //Reloj r = new Reloj();
       System.out.println(Reloj.sumar(11, 19, 41, -15));
   }
    
}
