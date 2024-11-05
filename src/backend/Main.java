package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    static AdminRole admin = new AdminRole();
    public static boolean addTrainerFromFrontend(String trainerID, String name, String email, String speciality, String phoneNumber) {
        return admin.addTrainer(trainerID, name, email, speciality, phoneNumber);
    }
    public static boolean removeTrainerFromFrontend(String trainerID) {
        return admin.removeTrainer(trainerID);
    }
    public static ArrayList<Trainer> getListOfTrainersForFrontend() {
        return admin.getListOfTrainers();
    }
    public static void adminLogoutFromFrontend() {
        admin.logout();
    }


    static TrainerRole trainer = new TrainerRole();
    public static boolean addMemberFromFrontend(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        return trainer.addMember(memberID, name, membershipType, email, phoneNumber, status);
    }
    public static boolean addClassFromFrontend(String classID, String className, String trainerID, int duration, int maxParticipants) {
        return trainer.addClass(classID, className, trainerID, duration, maxParticipants);
    }
    public static int registerFromFrontend(String memberID, String classID, LocalDate registrationDate) {
        return trainer.registerMemberForClass(memberID, classID, registrationDate);
    }
    public static int cancelRegistrationFromFrontend(String memberID, String classID) {
        return trainer.cancelRegistration(memberID, classID);
    }
    public static ArrayList<Member> getListOfMembersForFrontend() {
        return trainer.getListOfMembers();
    }
    public static ArrayList<Class> getListOfClassesForFrontend() {
        return trainer.getListOfClasses();
    }
    public static ArrayList<MemberClassRegistration> getListOfRegistrationsForFrontend() {
        return trainer.getListOfRegistrations();
    }
    public static void  trainerLogoutFromFrontend() {
        trainer.logout();
    }
}


