package backend;

import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database{
    public MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Data createRecordFrom(String line) {

        // delimiting each line into 5 strings
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        // creating new backend.MemberClassRegistration object
        MemberClassRegistration newMemberClassRegistration = new MemberClassRegistration(tokens[0], tokens[1], LocalDate.parse(tokens[2]), tokens[3]);
        return newMemberClassRegistration;
    }
}
