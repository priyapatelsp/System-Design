package trafficSystem;

public class TrafficSignalSystemDemo {
    public static void run() {
        TrafficController trafficController = TrafficController.getInstance();

        // Create traffic lights
        Signal trafficLight1 = new Signal("TL1", 6000, 3000, 9000);
        Signal trafficLight2 = new Signal("TL2", 6000, 3000, 9000);
        Signal trafficLight3 = new Signal("TL3", 6000, 3000, 9000);
        Signal trafficLight4 = new Signal("TL4", 6000, 3000, 9000);
        Road road1 = new Road("R1", "Main Street",trafficLight1);
        Road road2 = new Road("R2", "Broadway",trafficLight2);
        Road road3 = new Road("R3", "Park Avenue",trafficLight3);
        Road road4 = new Road("R4", "Elm Street",trafficLight4);

        trafficController.createRoad(road1);
        trafficController.createRoad(road2);
        trafficController.createRoad(road3);
        trafficController.createRoad(road4);

        // Start traffic control
        trafficController.startTraffic();

        // Simulate an emergency on a specific road
        trafficController.handleEmergency("R2");
    }

    public static void main(String[] args){
        run();
    }
    
}
