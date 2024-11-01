package backend;

public class ClassDatabase extends Database {
    public ClassDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Class createRecordFrom(String line) {
        // delimiting each line into 5 strings
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        // returning the new class object
        Class newClass = new Class(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
        return newClass;

    }
}
