package zeit;

import wesen.vielflach.Vielflachbasiswesen;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;

public class Zeitdauer {
    public static void anfangen(Vielflachbasiswesen vbw) {
	final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	executorService.scheduleAtFixedRate(vbw, 0, 4, TimeUnit.MILLISECONDS);
    }
}
