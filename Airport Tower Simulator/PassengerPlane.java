class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, TowerMediator mediator, int fuel) {
        super(id, mediator, fuel);
    }

    public void receive(String msg) {
        System.out.println("[PassengerPlane " + id + "] " + msg);
    }

    public String getType() {
        return "Passenger";
    }
}
