import java.util.Comparator;
import java.util.PriorityQueue;

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
    static GlobalTimer globalTimer=new GlobalTimer(0);
    static void run_cpu(PriorityQueue<Process> p){
        Process process=p.poll();
        process.run_process();
    }
    public static void main(String[] args){
        ready.add(new Process(1,1,5,1,globalTimer));
        ready.add(new Process(2,2,7,2,globalTimer));
        ready.add(new Process(3,3,3,3,globalTimer));
        ready.add(new Process(4,3,2,5,globalTimer));
        ready.add(new Process(5,2,10,4,globalTimer));
        ready.add(new Process(6,1,11,4,globalTimer));


        while(!ready.isEmpty()){
            if(ready.element().getPriority()==1){
                executeq1.add(ready.poll());
            }
            else if(ready.element().getPriority()==2){
                executeq2.add(ready.poll());
            }
            else if(ready.element().getPriority()==3){
                executeq3.add(ready.poll());
            }
        }
        while(globalTimer.time<=50){
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