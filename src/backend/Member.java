package backend;

public class Member implements Data{
    private String memberID;
    private String name;
    private String membershipType;
    private String email;
    private String phoneNumber;
    private String status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    @Override
    public String lineRepresentation() {
        return this.memberID + ", " + this.name + ", " + this.membershipType + ", " + this.email + ", " + this.phoneNumber + ", " + this.status;
    }

    @Override
    public String getSearchKey() {
        return memberID;
    }
}