package backend;

public class Class implements Data {
    private String classID;
    private String className;
    private String trainerID;
    private int duration;
    private int availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    @Override
    public String lineRepresentation() {
        return this.classID + ", " + this.className + ", " + this.trainerID + ", " + this.duration + ", " + this.availableSeats;
    }

    @Override
    public String getSearchKey() {
        return classID;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
