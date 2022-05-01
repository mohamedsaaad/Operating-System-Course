package diskstructure;

import java.util.Vector;
import java.util.Collections;

public class WaysToScheduling {

    public int NumOfClinder = 0;
    public static Vector<Integer> path = new Vector();

    void BubbleSort(Vector<Integer> Requests) {
        int i, j;
        for (i = 0; i < Requests.size() - 1; i++) {
            for (j = 0; j < Requests.size() - i - 1; j++) {
                if (Requests.elementAt(j) > Requests.elementAt(j + 1)) {
                    int temp = Requests.elementAt(j);
                    Collections.swap(Requests, j, j + 1);
                }

            }
        }
    }
    public int techSelection(Vector<Integer> Requests, int StartClinder,int choose)
    {
        switch (choose) {
            case 1:
                return FCFS(Requests, StartClinder);
            case 2:
                return SSTF(Requests, StartClinder);
            case 3:
                return Scan(Requests, StartClinder);
            case 4:
                return CScan(Requests, StartClinder);
            case 5:
                return Clook(Requests, StartClinder);
            default:
                return Optimized(Requests);
        }
    }
    public int FCFS(Vector<Integer> Requests, int StartClinder) {
        Requests.insertElementAt(StartClinder, 0);
        for (int i = 1; i < Requests.size(); i++) {
            NumOfClinder += Math.abs(Requests.elementAt(i - 1) - Requests.elementAt(i));
        }
        path = Requests;
        return NumOfClinder;
    }

    public int SSTF(Vector<Integer> Requests, int StartClinder) {
        path.add(StartClinder);
        while (Requests.size() > 0) {
            //System.out.println("the size : "+Requests.size());
            int NearestClinder = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < Requests.size(); i++) {
                int initial = Math.abs(StartClinder - Requests.elementAt(i));
                if (NearestClinder > initial) {
                    NearestClinder = initial;
                    index = i;
                }
            }
            NumOfClinder += Math.abs(StartClinder - Requests.elementAt(index));
            StartClinder = Requests.elementAt(index);
            path.add(Requests.elementAt(index));
            Requests.removeElementAt(index);
        }
        return NumOfClinder;
    }

    public int Scan(Vector<Integer> Requests, int StartClinder) {
        Requests.insertElementAt(0, 0);
        BubbleSort(Requests);
        if (StartClinder < Requests.elementAt(Requests.size() - 1)) {
            Vector<Integer> LowStartClinder = new Vector();
            for (int i = Requests.size() - 1; i >= 0; i--) {
                if (Requests.elementAt(i) < StartClinder) {
                    LowStartClinder.add(Requests.elementAt(i));
                    Requests.removeElementAt(i);
                }
            }
            path = LowStartClinder;
            path.insertElementAt(StartClinder, 0);
            NumOfClinder += Math.abs(StartClinder - LowStartClinder.elementAt(0));
            for (int j = 1; j < LowStartClinder.size(); j++) {
                NumOfClinder += Math.abs(LowStartClinder.elementAt(j - 1) - LowStartClinder.elementAt(j));
            }
            NumOfClinder += Math.abs(LowStartClinder.elementAt(LowStartClinder.size() - 1) - Requests.elementAt(0));
            path.add(Requests.elementAt(0));
            for (int j = 1; j < Requests.size(); j++) {
                NumOfClinder += Math.abs(Requests.elementAt(j - 1) - Requests.elementAt(j));
                path.add(Requests.elementAt(j));
            }
        }
        if (StartClinder > Requests.elementAt(Requests.size() - 1)) {
            Requests.add(StartClinder);
            for (int i = Requests.size() - 1; i > 0; i--) {
                NumOfClinder += Math.abs(Requests.elementAt(i) - Requests.elementAt(i - 1));
                path.add(Requests.elementAt(i));
            }
        }
        return NumOfClinder;
    }

    public int CScan(Vector<Integer> Requests, int StartClinder) {
        Requests.add(200);
        Requests.insertElementAt(0, 0);
        BubbleSort(Requests);
        path.add(StartClinder);
        int index = -1;
        for (int i = 0; i < Requests.size(); i++) {
            if (Requests.elementAt(i) > StartClinder) {
                index = i - 1;
                break;
            }
        }
        if (index != -1) {
            NumOfClinder += Math.abs(StartClinder - Requests.elementAt(index));
            for (int i = index; i > 0; i--) {
                NumOfClinder += Math.abs(Requests.elementAt(i) - Requests.elementAt(i - 1));
                path.add(Requests.elementAt(i));
            }
            path.add(Requests.elementAt(0));
            //System.out.println("3dd0 :"+NumOfClinder);
            NumOfClinder += Math.abs(Requests.elementAt(0) - Requests.elementAt(Requests.size() - 1));
            //System.out.println("3dd1 :"+NumOfClinder);

            for (int i = Requests.size() - 1; i > index + 1; i--) {
                NumOfClinder += Math.abs(Requests.elementAt(i) - Requests.elementAt(i - 1));
                path.add(Requests.elementAt(i));
            }
            path.add(Requests.elementAt(index + 1));
        }
        return NumOfClinder;
    }

    public int Clook(Vector<Integer> Requests, int StartClinder) {
        //Requests.add(200);
        // Requests.insertElementAt(0, 0);
        BubbleSort(Requests);
        path.add(StartClinder);
        int index = -1;
        for (int i = 0; i < Requests.size(); i++) {
            if (Requests.elementAt(i) > StartClinder) {
                index = i - 1;
                break;
            }
        }
        if (index != -1) {
            NumOfClinder += Math.abs(StartClinder - Requests.elementAt(index));
            for (int i = index; i > 0; i--) {
                NumOfClinder += Math.abs(Requests.elementAt(i) - Requests.elementAt(i - 1));
                path.add(Requests.elementAt(i));
            }
            path.add(Requests.elementAt(0));
            //System.out.println("3dd0 :"+NumOfClinder);
            NumOfClinder += Math.abs(Requests.elementAt(0) - Requests.elementAt(Requests.size() - 1));
            //System.out.println("3dd1 :"+NumOfClinder);

            for (int i = Requests.size() - 1; i > index + 1; i--) {
                NumOfClinder += Math.abs(Requests.elementAt(i) - Requests.elementAt(i - 1));
                path.add(Requests.elementAt(i));
            }
            path.add(Requests.elementAt(index + 1));
        }
        return NumOfClinder;
    }
    
    public int Optimized(Vector<Integer> Requests) {
        Requests.add(0);
        BubbleSort(Requests);
        path = Requests;
        NumOfClinder = Requests.elementAt(Requests.size() - 1);
        return NumOfClinder;
    }

    public void VisualizingPath() {
        System.out.print("The Sequence Of Head Movement To Access The Requested Cylinders: [");
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                System.out.print(path.elementAt(i));
            } else {
                System.out.print(path.elementAt(i) + ",");
            }
        }
        System.out.println("]");
    }

}
