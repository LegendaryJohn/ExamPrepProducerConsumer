
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers S1 Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template S1 the editor.
 */

/**
 *
 * @author kann
 */
public class ProdCon{
    
    
    public static void main(String[] args) throws InterruptedException {
        
    BlockingQueue S1 = new ArrayBlockingQueue(11);
    BlockingQueue S2 = new ArrayBlockingQueue(11);
    
        Scanner scan = new Scanner(System.in);
        System.out.println("Type amount of threads to use: ");
        int threadsNo = scan.nextInt();
        
        ArrayList<Thread> threads = new ArrayList<>();
        
        S1.put(4);
        S1.put(5);
        S1.put(8);
        S1.put(12);
        S1.put(21);
        S1.put(22);
        S1.put(34);
        S1.put(35);
        S1.put(36);
        S1.put(37);
        S1.put(42);

        for (int i = 0; i < threadsNo; i++) {
            
             Thread t = new Thread(new Producer(S1,S2));
             threads.add(t);    
             threads.get(i).start();
             threads.get(i).join();
             
        }
        
        
        Thread t = new Thread(new Consumer(S2));
        t.start();
        t.join();
        
  
    }


    
}
