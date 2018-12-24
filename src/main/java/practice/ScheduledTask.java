package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println("Current DateTime: "+dateString);
    }
}
