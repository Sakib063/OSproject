public class Process{
    int pid;
    int priority;
    int arrival_time;
    int burst_time;
    GlobalTimer timer;

    public Process(int pid, int priority, int arrival_time, int burst_time, GlobalTimer timer){
        this.pid = pid;
        this.priority = priority;
        this.arrival_time = arrival_time;
        this.burst_time = burst_time;
        this.timer = timer;
    }
    public void run_process(){
        for(int i=0;i<burst_time;i++){
            System.out.println("Process: "+pid+" is running. Time: "+timer);
            timer.time++;
        }
        System.out.println("Process: "+pid+" has finished running. Time: "+timer);
    }
    public int getPid() {
        return pid;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public int getBurst_time() {
        return burst_time;
    }

    public GlobalTimer getTimer() {
        return timer;
    }
}
