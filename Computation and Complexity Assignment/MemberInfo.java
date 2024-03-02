public class MemberInfo {
    private String firstName;
    private String lastName;
    private String phone;
    private boolean livesInNewYork;

    public MemberInfo(String firstName, String lastName, String phone, boolean livesInNewYork) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.livesInNewYork = livesInNewYork;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isLivesInNewYork() {
        return livesInNewYork;
    }

    @Override
    public String toString() {
        return getFirstName() + "|" + getLastName() + "|" + getPhone() + "|" + isLivesInNewYork()+"\n";
    }

}

    

