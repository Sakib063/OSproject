import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    static PriorityQueue<Process>ready=new PriorityQueue<Process>(10,
            new Comparator<Process>(){
                @Override
                public int compare(Process o1, Process o2) {
                    return (int)(o1.getArrival_time()-o2.getArrival_time());
                }
            });
    static PriorityQueue<Process>executeq1=new PriorityQueue<Process>(10,
            new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2){
                    return (int)(o1.getArrival_time()-o2.getArrival_time());
                }
            });
    static PriorityQueue<Process>executeq2=new PriorityQueue<Process>(10,
            new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2){
                    return (int)(o1.getArrival_time()-o2.getArrival_time());
                }
            });
    static PriorityQueue<Process>executeq3=new PriorityQueue<Process>(10,
            new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2){
                    return (int)(o1.getArrival_time()-o2.getArrival_time());
                }
            });
    static PriorityQueue<Process>executeq4=new PriorityQueue<Process>(10,
            new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2){
                    return (int)(o1.getArrival_time()-o2.getArrival_time());
                }
            });
    static GlobalTimer globalTimer=new GlobalTimer(0);
    static void run_cpu(PriorityQueue<Process> p){
        Process process=p.poll();
        process.run_process();
    }
    public static void main(String[] args){
        int time=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("Process ID:"+i);
            System.out.println("Priority must be between 1 to 4");
            System.out.println("Priority:");
            int pri= sc.nextInt();
            System.out.println("Process ID:"+i);
            System.out.println("Arrival Time:");
            int at= sc.nextInt();
            System.out.println("Process ID:"+i);
            System.out.println("Burst Time:");
            int bt= sc.nextInt();
            ready.add(new Process(i,pri,at,bt,globalTimer));
        }

        while(!ready.isEmpty()){
            time=time+ready.element().burst_time;
            if(ready.element().getPriority()==1){
                executeq1.add(ready.poll());
            }
            else if(ready.element().getPriority()==2){
                executeq2.add(ready.poll());
            }
            else if(ready.element().getPriority()==3){
                executeq3.add(ready.poll());
            }
            else if(ready.element().getPriority()==4){
                executeq4.add(ready.poll());
            }
        }
        while(globalTimer.time<=time){
            if(!executeq3.isEmpty()){
                run_cpu(executeq3);
                globalTimer.time++;
            }
            if(executeq3.isEmpty()&&!executeq2.isEmpty()){
                run_cpu(executeq2);
                globalTimer.time++;
            }
            if(executeq3.isEmpty()&&executeq2.isEmpty()&&!executeq1.isEmpty()){
                run_cpu(executeq1);
                globalTimer.time++;
            }
        }
    }
}