package backend;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public abstract class Database {
    private ArrayList<Data> records;
    private String fileName;

    public Database(String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
        readFromFile();
    }

    // reads the data from the file & stores it in the ArrayList records
    public void readFromFile() {
        String fileContentString;
        try {
            // store the file content as 1 string in fileContentString
            fileContentString = Files.readString(Paths.get(fileName + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (fileContentString.isBlank()) {
//            System.out.println("File is empty");
            return;
        } else {
            // separating each line and storing it in a String array
            String[] lines = fileContentString.split("\n");
            for (String line : lines) {
                records.add(createRecordFrom(line));
            }
        }

    }

    public abstract Data createRecordFrom(String line);

    public ArrayList<Data> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        // checks if the ArrayList records is empty
        if (records == null) return false;

        // return true if the key is found
        for (Data element : records) {
            if (element.getSearchKey().equals(key))
                return true;
        }
        return false;
    }

    public Data getRecord(String key) {

        // checks if the ArrayList records is empty
        if (records == null) return null;

        // return the object if found
        for (Data element : records) {
            if (element.getSearchKey().equals(key))
                return element;
        }
        return null;
    }

    public void insertRecord(Data record) {

        // checks if the record is already exist
        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("Record already exists");
        }
    }

    public void deleteRecord(String key) {

        // checks if the key exists
        if (contains(key))
            records.remove(getRecord(key));
        else
            System.out.println("Record doesn't exists");
    }

    public void saveToFile() {
        try {
            // creating new Write instance
            Writer writer = new FileWriter(fileName + ".txt");
            if (!records.isEmpty()) {
                // saving the data to the file
                writer.write(records.get(0).lineRepresentation());
                for (int i = 1; i < records.size(); i++) {
                    writer.append("\n" + records.get(i).lineRepresentation());
                }
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
