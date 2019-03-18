/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berkeley;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Reloj implements Runnable{

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    JFrameBerkeley jfb;
    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();
    
    
    public Reloj() {
        h1 = new Thread(this);
        h1.start();
        //jfb = new JFrameBerkeley();
        //jfb.setVisible(true);
    }

       public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
      
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
       

    @Override
    public void run () {
        while (running){
            synchronized (pauseLock) {
                if (!running) { // may have changed while waiting to
                                // synchronize on pauseLock
                    break;
                }
                if (paused) {
                    try {
                        pauseLock.wait(); // will cause this Thread to block until 
                                          // another thread calls pauseLock.notifyAll()
                                          // Note that calling wait() will 
                                          // relinquish the synchronized lock that this 
                                          // thread holds on pauseLock so another thread
                                          // can acquire the lock to call notifyAll()
                                          // (link with explanation below this code)
                    } catch (InterruptedException ex) {
                        break;
                    }
                    if (!running) { // running might have changed since we paused
                        break;
                    }
                }
            }
            // Your code here
                   Thread ct = Thread.currentThread();
            while (ct == h1) {
                calcula();
                System.out.println(hora + ":" + minutos + ":" + segundos + " " + ampm);
              //  this.jfb.setAux(hora + ":" + minutos + ":" + segundos);
                System.out.println("Reloj 2 "+(Integer.parseInt(segundos)+5));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    
    public void stop() {
        running = false;
        // you might also want to interrupt() the Thread that is 
        // running this Runnable, too, or perhaps call:
        resume();
        // to unblock
    }

    public void pause() {
        // you may want to throw an IllegalStateException if !running
        paused = true;
    }

    public void resume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll(); // Unblocks thread
        }
    }

    @Override
    public String toString() {
        return hora + ":" + minutos + ":" + segundos;
    }

        
    
    public static void main(String args[]) throws InterruptedException{
        Reloj r =new Reloj();
        System.out.println("HOLA");
        Thread.sleep(5000);
        r.h1.start();
       // r.pause();
       // Thread.sleep(5000);
       // r.resume();
        //Thread.sleep(5000);
      //  r.pause();
      //  Thread.sleep(5000);
      //  r.resume();
    }
    
    
}
