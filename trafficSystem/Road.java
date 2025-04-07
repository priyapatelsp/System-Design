package trafficSystem;

public class Road {
    private String roadId;
    private String roadName;
    private Signal signal;

    public Road( String roadId,String roadName, Signal signal){
        this.signal = signal;
        this.roadId = roadId;
        this.roadName = roadName;

    }
    public Signal getSignal(){
        return this.signal;
    }
    public String getRoadId(){
        return this.roadId;
    }
}
