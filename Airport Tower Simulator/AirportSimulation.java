import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AirportSimulation {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Random rand = new Random();
        List<Aircraft> aircraftList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int fuel = rand.nextInt(50);
            Aircraft a;
            switch (rand.nextInt(3)) {
                case 0: a = new PassengerPlane("P" + i, tower, fuel); break;
                case 1: a = new CargoPlane("C" + i, tower, fuel); break;
                default: a = new Helicopter("H" + i, tower, fuel); break;
            }
            tower.registerAircraft(a);
            aircraftList.add(a);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            Aircraft a = aircraftList.get(rand.nextInt(aircraftList.size()));
            if (a.isEmergency()) {
                a.declareEmergency();
            } else {
                a.requestRunway();
            }
        }, 0, 2, TimeUnit.SECONDS);

        Executors.newSingleThreadScheduledExecutor().schedule(() -> executor.shutdown(), 30, TimeUnit.SECONDS);
    }
}

