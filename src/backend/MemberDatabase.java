package backend;

public class MemberDatabase extends Database {

    public MemberDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Member createRecordFrom(String line) {

        // delimiting each line into 5 strings
        String[] tokens = line.split(",");
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokens[i].trim();

        // creating new backend.Member object
        Member newMember = new Member(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
        return newMember;
    }
}
