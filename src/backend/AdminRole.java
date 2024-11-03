package backend;

import constants.FileNames;

import java.util.ArrayList;

public class AdminRole implements FileNames {
    private TrainerDatabase database;

    public AdminRole() {
        this.database = new TrainerDatabase(TRAINER_FILENAME);
    }

    public boolean addTrainer(String trainerID, String name, String email, String speciality, String phoneNumber) {
        Trainer trainer = new Trainer(trainerID, name, email, speciality, phoneNumber);
        return database.insertRecord(trainer);
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
