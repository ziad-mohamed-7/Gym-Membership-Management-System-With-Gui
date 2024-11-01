package backend;

import java.util.ArrayList;

public class AdminRole {
    private TrainerDatabase database;

    public AdminRole() {
        this.database = new TrainerDatabase("Trainers");
    }

    public void addTrainer(String trainerID, String name, String email, String speciality, String phoneNumber) {
        Trainer trainer = new Trainer(trainerID, name, email, speciality, phoneNumber);
        database.insertRecord(trainer);
    }

    public ArrayList<Data> getListOfTrainers(){
        return database.returnAllRecords();
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);
    }

    public void logout(){
        database.saveToFile();
    }
}
