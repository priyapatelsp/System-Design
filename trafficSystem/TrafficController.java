package trafficSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficController {
    public static TrafficController instance;
    Map<String,Road> roadMap = new HashMap<>();

    public TrafficController(){
        roadMap = new HashMap<>();
    }
    public static synchronized TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void createRoad(Road road){
        roadMap.put(road.getRoadId(),road);
    }
    public void removeRoad(String roadId) {
        roadMap.remove(roadId);
    }

    public void startTraffic(){
        List<Road> allRoads = List.copyOf(roadMap.values()); // Create a list of roads

        new Thread(() -> {
            while (true) {
                for (Road currentRoad : allRoads) {
                    try {
                        // Make current road green, others red
                        for (Road road : allRoads) {
                            if (road == currentRoad) {
                                road.getSignal().changeSignal(Light.GREEN);
                                System.out.println("GREEN");
                            } else {
                                road.getSignal().changeSignal(Light.RED);
                                System.out.println("RED");
                            }
                        }
                        Thread.sleep(currentRoad.getSignal().getRedLightDuration());

                        // Make current road yellow, others red
                        for(Road road : allRoads){
                            if(road == currentRoad){
                                road.getSignal().changeSignal(Light.YELLOW);
                                System.out.println("YELLOW");
                            } else {
                                road.getSignal().changeSignal(Light.RED);
                                System.out.println("RED");
                            }
                        }
                        Thread.sleep(currentRoad.getSignal().getYellowLightDuration());
                        System.out.println("---------------------");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        
    }

    public void handleEmergency(String roadId) {
        Road road = roadMap.get(roadId);
        if (road != null) {
            Signal trafficLight = road.getSignal();
            trafficLight.changeSignal(Light.GREEN);
            // Perform emergency handling logic
            // ...
        }
    }

    
}
