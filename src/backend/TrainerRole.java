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

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member m1 = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(m1);
    }

    public ArrayList<Data> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class c1 = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(c1);
    }

    public ArrayList<Class> getListOfClasses() {
        ArrayList<Class> classes = new ArrayList<>();
        for (Data d : classDatabase.returnAllRecords()) {
            classes.add((Class) d);
        }
        return classes;
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (!classDatabase.contains(classID)) return false;
        Class c1 = (Class) classDatabase.getRecord(classID);
        if (c1.getAvailableSeats() == 0) return false;
        MemberClassRegistration r1 = new MemberClassRegistration(memberID, classID, registrationDate, "active");
        if (registrationDatabase.contains(r1.getSearchKey()))
            return false;
        registrationDatabase.insertRecord(r1);
        c1.setAvailableSeats(c1.getAvailableSeats() - 1);
        return true;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        MemberClassRegistration r1 = (MemberClassRegistration) registrationDatabase.getRecord(memberID + classID);


        if (!LocalDate.now().isBefore(r1.getRegistrationDate()) && !LocalDate.now().isAfter(r1.getRegistrationDate().plusDays(3))) {
            r1.setRegistrationStatus("cancelled");
            Class c1 = (Class) classDatabase.getRecord(classID);
            c1.setAvailableSeats(c1.getAvailableSeats() + 1);
            return true;
        } else
            return false;
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
