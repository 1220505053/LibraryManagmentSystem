abstract class UserFactory {
    public abstract User createUser(String name, String role);
}

class StudentFactory extends UserFactory {
    @Override
    public User createUser(String name, String role) {
        return new Student(name, role);
    }
}

class StaffFactory extends UserFactory {
    @Override
    public User createUser(String name, String role) {
        return new Staff(name, role);
    }
}