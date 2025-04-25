import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayOccupied = false;
    private List<Aircraft> allAircraft = new ArrayList<>();

    public void registerAircraft(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            for (Aircraft a : allAircraft) {
                if (!a.equals(sender)) {
                    a.receive("ожидайте, на полосе ЧП");
                }
            }
            landingQueue.add(sender);
        } else {
            for (Aircraft a : allAircraft) {
                if (!a.equals(sender)) {
                    a.receive("сообщение от " + sender.getId() + ": " + msg);
                }
            }
        }
    }

    public boolean requestRunway(Aircraft a) {
        if (a.isEmergency()) {
            landingQueue.add(a);
            return tryGrantRunway();
        }
        if (a.getType().equals("Passenger") || a.getType().equals("Cargo")) {
            landingQueue.add(a);
        } else {
            takeoffQueue.add(a);
        }
        return tryGrantRunway();
    }

    private boolean tryGrantRunway() {
        if (!runwayOccupied) {
            Aircraft next = null;
            for (Aircraft a : landingQueue) {
                if (a.isEmergency()) {
                    next = a;
                    break;
                }
            }
            if (next != null) {
                landingQueue.remove(next);
            } else if (!landingQueue.isEmpty()) {
                next = landingQueue.poll();
            } else if (!takeoffQueue.isEmpty()) {
                next = takeoffQueue.poll();
            }
            if (next != null) {
                runwayOccupied = true;
                next.receive("полоса предоставлена");
                ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
                executor.schedule(() -> {
                    runwayOccupied = false;
                    System.out.println(" полоса снова свободна.");
                }, 3, TimeUnit.SECONDS);
                executor.shutdown();
                return true;
            }
        }
        return false;
    }
}


