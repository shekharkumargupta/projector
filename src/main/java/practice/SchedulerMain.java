package practice;

import java.util.Timer;

public class SchedulerMain {

    public static void main(String args[]){
        System.out.println("Hello Timer!");
        Timer timer = new Timer();
        ScheduledTask scheduledTask = new ScheduledTask();
        timer.schedule(scheduledTask, 0,1000);

    }
}
