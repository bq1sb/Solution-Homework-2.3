class Helicopter extends Aircraft {
    public Helicopter(String id, TowerMediator mediator, int fuel) {
        super(id, mediator, fuel);
    }

    public void receive(String msg) {
        System.out.println("[Helicopter " + id + "] " + msg);
    }

    public String getType() {
        return "Helicopter";
    }
}

