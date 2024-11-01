package backend;

public class TrainerDatabase extends Database {

    public TrainerDatabase(String fileName) {
        super(fileName);
    }

    @Override
    // extracting the data from passed line and return the new instance
    public Trainer createRecordFrom(String line) {

        // delimiting each line into 5 strings
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        // creating new trainer object
        Trainer newTrainer = new Trainer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
        return newTrainer;
    }

}
