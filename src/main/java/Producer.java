
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kann
 */
public class Producer implements Runnable {
    
    BlockingQueue S1;
    BlockingQueue S2;
    
    public Producer(BlockingQueue S1, BlockingQueue S2)
    {
        this.S1 = S1;
        this.S2 = S2;
    }
    
    
    @Override
    public void run(){
        while(!S1.isEmpty())
        {
            
            try{
                int no = (int)S1.poll();
                long temp = fib( (long)no );
                S2.put(temp);
             
            } 
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
    
    private long fib(long n){
        if ((n == 0) || (n == 1)) {
          return n;
        } else {
          return fib(n - 1) + fib(n - 2);
        }
      }
    
    
}
