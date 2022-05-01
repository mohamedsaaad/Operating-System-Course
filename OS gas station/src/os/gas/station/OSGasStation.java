/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.gas.station;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Chaos
 */
public class OSGasStation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        String wait="";
        Vector<Integer> cars = new Vector();
        mainframe gasstation = new mainframe();
        gasstation.show();
        while (gasstation.numofcars==0 || gasstation.numofpumps==0){
            Thread.sleep(100);
        }
        int numOfPumbs = gasstation.numofpumps;
        station test = new station(numOfPumbs);
        int numOfCars = gasstation.numofcars;
        test.pumbs_vec = new Vector();
        for (Integer i = 1; i <= numOfPumbs; i++) {
            String name = "pumb" + i.toString();
            Thread pumb = new Thread(new station(name));
            test.pumbs_vec.add(pumb);
        }
        
        for (int i = 0; i < numOfCars; i++) {

            int m = i + 1;
            int arrive;
            do {
                Random arr_time = new Random();
                arrive = arr_time.nextInt(2000);
            } while (arrive < 0);
            Thread.sleep(arrive);
            if (test.pumbs.availablePermits() == 0) {
                cars.add(m);
                wait="";
                for (int j=0;j<cars.size();j++){
                    wait+="C "+cars.get(j);
                }
                for (int j=0;j<test.places.size();j++){
                    test.places.get(j).waitL.setText(wait);
                }
            } else {
                for (int j = 0; j < test.pumbs_vec.size(); j++) {
                    if (cars.size() == 0) {
                        if (test.pumbs_vec.elementAt(j).isAlive() == false) {
                            test.pumbs_vec.elementAt(j).start();
                            test.pumbs_vec.remove(j);
                            Thread.sleep(20);
                            test.counter++;
                            break;
                        }
                    } else {
                        cars.add(m);
                        wait="";
                        for (int l=0;l<cars.size();l++){
                            wait+="C "+cars.get(l);
                        }
                        for (int l=0;l<test.places.size();l++){
                            test.places.get(l).waitL.setText(wait);
                        }
                        if (test.pumbs_vec.elementAt(j).isAlive() == false) {
                            test.counter = cars.elementAt(0);
                            test.pumbs_vec.elementAt(j).start();
                            test.pumbs_vec.remove(j);
                            Thread.sleep(20);
                            cars.remove(0);
                            wait="";
                            for (int l=0;l<cars.size();l++){
                                wait+="C "+cars.get(l);
                            }
                            for (int l=0;l<test.places.size();l++){
                                test.places.get(l).waitL.setText(wait);
                            }
                            test.counter = cars.elementAt(cars.size() - 1);
                            break;

                        }

                    }

                }
            }
            while (cars.size() != 0) {
                test.counter = cars.elementAt(0);
                for (int j = 0; j < test.pumbs_vec.size(); j++) {
                    if (test.pumbs_vec.elementAt(j).isAlive() == false) {
                        test.pumbs_vec.elementAt(j).start();
                        test.pumbs_vec.remove(j);
                        Thread.sleep(20);
                        test.counter++;
                        cars.remove(0);
                        wait="";
                        for (int l=0;l<cars.size();l++){
                            wait+="C "+cars.get(l);
                        }
                        for (int l=0;l<test.places.size();l++){
                            test.places.get(l).waitL.setText(wait);
                        }
                        break;
                    }
                }
            }
        }
        while (true){
            if (test.pumbs_vec.size()==numOfPumbs){
                JOptionPane.showMessageDialog(null, "End of Day.", "Day Ended", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }
}
