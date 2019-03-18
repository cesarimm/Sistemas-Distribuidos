/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lamport;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Proceso implements Runnable{
    
    private  Thread hilo;
    private  int contador, constante;
    
    public Proceso(int c){
        this.constante = c;
        this.contador=0;
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
         Thread ct = Thread.currentThread();
           while (ct == hilo) {
           this.contador+=this.constante;
               System.out.println("Contador: "+this.contador);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
     
    
    public static void main(String args[]){
        Proceso p1= new Proceso(4);
    }
}
