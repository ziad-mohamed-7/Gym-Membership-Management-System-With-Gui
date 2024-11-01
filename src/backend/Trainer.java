package backend;

public class Trainer implements Data {
    String trainerID;
    String name;
    String email;
    String specialty;
    String phoneNumber;

    public Trainer(String trainerID, String name, String email, String specialty, String phoneNumber) {
        this.trainerID = trainerID;
        this.name = name;
        this.email = email;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return this.trainerID + ", " + this.name + ", " + this.email + ", " + this.specialty + ", " + this.phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return trainerID;
    }
}