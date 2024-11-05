package backend;

import constants.FileNames;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole implements FileNames {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;


    public TrainerRole() {
        this.memberDatabase = new MemberDatabase(MEMBER_FILENAME);
        this.classDatabase = new ClassDatabase(CLASS_FILENAME);
        this.registrationDatabase = new MemberClassRegistrationDatabase(REGISTRATION_FILENAME);
    }

    public boolean addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member m1 = new Member(memberID, name, membershipType, email, phoneNumber, status);
        return memberDatabase.insertRecord(m1);
    }

    public ArrayList<Member> getListOfMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for (Data d : memberDatabase.returnAllRecords()) {
            members.add((Member) d);
        }
        return members;
    }

    public boolean addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class c1 = new Class(classID, className, trainerID, duration, maxParticipants);
        return classDatabase.insertRecord(c1);
    }

    public ArrayList<Class> getListOfClasses() {
        ArrayList<Class> classes = new ArrayList<>();
        for (Data d : classDatabase.returnAllRecords()) {
            classes.add((Class) d);
        }
        return classes;
    }

    public int registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (!classDatabase.contains(classID)) return 0;
        if (!memberDatabase.contains(memberID)) return 4;
        Class c1 = (Class) classDatabase.getRecord(classID);
        if (c1.getAvailableSeats() == 0) return 1;
        MemberClassRegistration r1 = new MemberClassRegistration(memberID, classID, registrationDate, "active");
        if (registrationDatabase.contains(r1.getSearchKey()))
            return 2;
        registrationDatabase.insertRecord(r1);
        c1.setAvailableSeats(c1.getAvailableSeats() - 1);
        return 3;
    }

    public int cancelRegistration(String memberID, String classID) {
        if (!classDatabase.contains(classID)) return 1;
        if (!memberDatabase.contains(memberID)) return 2;
        if(!registrationDatabase.contains(memberID+classID)) return 3;
        MemberClassRegistration r1 = (MemberClassRegistration) registrationDatabase.getRecord(memberID + classID);
        if (!LocalDate.now().isBefore(r1.getRegistrationDate()) && !LocalDate.now().isAfter(r1.getRegistrationDate().plusDays(3))) {
            r1.setRegistrationStatus("cancelled");
            registrationDatabase.deleteRecord(r1.getSearchKey());
            Class c1 = (Class) classDatabase.getRecord(classID);
            c1.setAvailableSeats(c1.getAvailableSeats() + 1);
            return 0;
        } else
            return 4;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        ArrayList<MemberClassRegistration> registrations = new ArrayList<>();
        for (Data d : registrationDatabase.returnAllRecords()) {
            registrations.add((MemberClassRegistration) d);
        }
        return registrations;
    }

    public void logout() {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
}
