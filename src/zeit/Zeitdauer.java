package zeit;

import wesen.Vielflachbasiswesen;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;

public class Zeitdauer {

    public static void bleiben() {
	try {
	    System.out.println("Ich bleibe");
	    TimeUnit.SECONDS.sleep(10);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public static void anfangen(Vielflachbasiswesen vbw) {
	final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	executorService.scheduleAtFixedRate(vbw, 0, 10, TimeUnit.MILLISECONDS);
    }
}
