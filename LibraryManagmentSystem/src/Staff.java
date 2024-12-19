class Staff extends User {
    public Staff(String name, String role) {
        super(name, role);
    }

    @Override
    public void showDetails() {
        System.out.println("Staff: " + name + ", Role: " + role);
    }
}