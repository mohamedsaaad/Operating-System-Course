package diskstructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class DiskStructure {

    public static Vector<Integer> QueueReq = new Vector();
    public static int InitialClinder;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileName = "RequestsQueue.txt";
        String line = "", line1 = "";
        FileReader fileReader = new FileReader(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                line1 += line;
            }
        }

        String[] words = line1.split("\\s+");
        for (String word : words) {
            QueueReq.add(Integer.parseInt(word));
        }
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter The Initial head start cylinder : ");
        InitialClinder = reader.nextInt();
        int test;
        while(true)
        {
            WaysToScheduling obj= new WaysToScheduling();
            int choice;
            System.out.print("choose the Disk Structure method number(0 fo EXIT):\n\t1-FCFS\n\t2-SSTF");
            System.out.println("\n\t3-SCAN\n\t4-CScan\n\t5-CLook\n\t6-Optimizedd.\n\t");
            System.out.println("choice:");
            reader = new Scanner(System.in);
            choice = reader.nextInt();
            if(choice>0&&choice<7)
            {
                test=obj.techSelection(QueueReq, InitialClinder, choice);
                System.out.println("The Total Head Movement: "+test);
                obj.VisualizingPath();
            }
            else if(choice==0)
                break;
            else
                System.out.println("Invalid Input!\n");
        }
   
    }

}
