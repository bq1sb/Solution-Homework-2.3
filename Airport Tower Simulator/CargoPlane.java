class CargoPlane extends Aircraft {
    public CargoPlane(String id, TowerMediator mediator, int fuel) {
        super(id, mediator, fuel);
    }

    public void receive(String msg) {
        System.out.println("[CargoPlane " + id + "] " + msg);
    }

    public String getType() {
        return "Cargo";
    }
}

