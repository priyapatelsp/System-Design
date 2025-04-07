package trafficSystem;

public class Signal {
    private String signalCode;
    private Integer redDuration;
    private Integer greenDuration;
    private Integer yellowDuration;
    private Light currentSignal;

    public Signal( String signalCode, Integer redDuration, Integer greenDuration,Integer yellowDuration){
        this.signalCode = signalCode ;
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }

    public String getSignalCode(){
        return this.signalCode;
    }
    public Integer getRedLightDuration(){
        return this.redDuration;
    }
    public Integer getGreenLightDuration(){
        return this.greenDuration;
    }
    public Integer getYellowLightDuration(){
        return this.yellowDuration;
    }

    public synchronized void changeSignal(Light newSignal) {
        currentSignal = newSignal;
    }

   
}
