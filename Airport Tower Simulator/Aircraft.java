abstract class Aircraft {
    protected String id;
    protected TowerMediator mediator;
    protected int fuel;
    protected boolean emergency;

    public Aircraft(String id, TowerMediator mediator, int fuel) {
        this.id = id;
        this.mediator = mediator;
        this.fuel = fuel;
        this.emergency = false;
    }

    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    public boolean requestRunway() {
        return mediator.requestRunway(this);
    }

    public void declareEmergency() {
        emergency = true;
        send("MAYDAY");
    }

    public boolean isEmergency() {
        return emergency || fuel < 10;
    }

    public String getId() {
        return id;
    }

    public abstract void receive(String msg);
    public abstract String getType();
}


