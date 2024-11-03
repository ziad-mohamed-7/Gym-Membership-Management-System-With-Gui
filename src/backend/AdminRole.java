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

    public ArrayList<Trainer> getListOfTrainers(){
        ArrayList<Trainer> trainers = new ArrayList<>();
        for (Data d : database.returnAllRecords()) {
            trainers.add((Trainer) d);
        }
        return trainers;
    }

    public boolean removeTrainer(String key) {
        return database.deleteRecord(key);
    }

    public void logout(){
        database.saveToFile();
    }
}
