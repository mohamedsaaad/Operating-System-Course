/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.gas.station;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Chaos
 */
public class station implements Runnable {
    public static Semaphore pumbs;
    public static int counter = 1;
    public static Vector <Thread> pumbs_vec;
    public static Vector <Pumb> places = new Vector();
    String name="";
    int time;
    Random r = new Random ();
    Pumb x= new Pumb();
    public station (int n){
        pumbs = new Semaphore (n);
    }
    public station (String num){
        name=num;
        time= r.nextInt(3000);
        x.setTitle(name);
        places.add(x);
        x.setVisible(true);
    }
    public void run (){
          
        try {
            pumbs.acquire();
            x.carpic.setEnabled(true);
            x.arriveL.setEnabled(true);
            int n=counter;
            x.carname.setText("C"+n);
            Thread.sleep(time);
            
            x.redlight.setEnabled(true);
            x.greenlight.setEnabled(false);
            x.servingL.setEnabled(true);
            x.arriveL.setEnabled(false);
            r = new Random ();
            time=r.nextInt(5000);
            Thread.sleep(time);
            
            x.servingL.setEnabled(false);
            x.paypic.setEnabled(true);
            x.PayingL.setEnabled(true);
            r = new Random ();
            time=r.nextInt(5000);
            Thread.sleep(time);
            x.redlight.setEnabled(false);
            x.greenlight.setEnabled(true);
            x.carpic.setEnabled(false);
            x.leavepic.setEnabled(true);
            x.leaveL.setEnabled(true);
            x.paypic.setEnabled(false);
            x.PayingL.setEnabled(false);
            x.carname.setText("");
            r = new Random ();
            time=r.nextInt(5000);
            Thread.sleep(time);
            x.leavepic.setEnabled(false);
            x.leaveL.setEnabled(false);
            pumbs.release();
            Thread avail=new Thread (this);
            pumbs_vec.add(avail);
        }
        catch (Exception e){}
    }
}
