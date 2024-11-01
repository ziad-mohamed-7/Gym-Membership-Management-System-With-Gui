package backend;

import java.time.LocalDate;

public class MemberClassRegistration implements Data{
    private String memberID;
    private String classID;
    private LocalDate registrationDate;
    private String status;

    public MemberClassRegistration(String memberId, String classId, LocalDate registrationDate, String status) {
        this.memberID = memberId;
        this.classID = classId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getMemberId() {
        return memberID;
    }

    public String getClassId() {
        return classID;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationStatus(String status) {
        this.status = status;
    }

    @Override
    public String lineRepresentation() {
        return this.memberID + ", " + this.classID  + ", " + this.registrationDate + ", " + this.status;
    }

    @Override
    public String getSearchKey() {
        return memberID + classID;
    }
}
