
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kann
 */
public class Consumer implements Runnable{
    
    BlockingQueue S2;
    private long sum;
    
    public Consumer(BlockingQueue S2){
        this.S2 = S2;
    }
    
    public long getSum(){
        return sum;
    }
    
    @Override
    public void run(){
        long temp;
        
        while(!S2.isEmpty()){
            try{
                temp = (long) S2.take();
                sum += temp;
                System.out.println("Number..  " + temp);
            } catch (Exception ex) {
                System.out.println(ex);
            } 
            
        }
         System.out.println("Sum..  " + sum);
    }
    
    
}
