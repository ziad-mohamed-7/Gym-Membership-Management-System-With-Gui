package frontend;

import backend.Class;
import backend.Main;
import backend.Member;
import backend.Trainer;
import backend.MemberClassRegistration;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClassesFrontend {

    public static class TrainerFrontend {
        String trainerID;
        String name;
        String email;
        String specialty;
        String phoneNumber;

        public TrainerFrontend(String trainerID, String name, String email, String specialty, String phoneNumber) {
            this.trainerID = trainerID;
            this.name = name;
            this.email = email;
            this.specialty = specialty;
            this.phoneNumber = phoneNumber;
        }

        public static ArrayList<TrainerFrontend> getTrainersFromBackend() {
            ArrayList<TrainerFrontend> trainers = new ArrayList<>();
            String[] tokens;
            for (Trainer trainer : Main.getListOfTrainersForFrontend()) {
                tokens = trainer.lineRepresentation().split(", ");
                trainers.add(new TrainerFrontend(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]));
            }
            return trainers;
        }

        public String getTrainerID() {
            return trainerID;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getSpecialty() {
            return specialty;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    public static class ClassFrontend {
        private String classID;
        private String className;
        private String trainerID;
        private int duration;
        private int availableSeats;

        public ClassFrontend(String classID, String className, String trainerID, int duration, int availableSeats) {
            this.classID = classID;
            this.className = className;
            this.trainerID = trainerID;
            this.duration = duration;
            this.availableSeats = availableSeats;
        }


        public static ArrayList<ClassFrontend> getClassesFromBackend() {
            ArrayList<ClassFrontend> classes = new ArrayList<>();
            String[] tokens;
            for (Class classBackend : Main.getListOfClassesForFrontend()) {
                tokens = classBackend.lineRepresentation().split(", ");
                classes.add(new ClassFrontend(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[3])));
            }
            return classes;
        }

        public String getClassID() {
            return classID;
        }

        public String getClassName() {
            return className;
        }

        public String getTrainerID() {
            return trainerID;
        }

        public int getDuration() {
            return duration;
        }

        public int getAvailableSeats() {
            return availableSeats;
        }
    }

    public static class MemberFrontend {
        private String memberID;
        private String name;
        private String membershipType;
        private String email;
        private String phoneNumber;
        private String status;

        public MemberFrontend(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
            this.memberID = memberID;
            this.name = name;
            this.membershipType = membershipType;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.status = status;
        }

        public static ArrayList<MemberFrontend> getMembersFromBackend() {
            ArrayList<MemberFrontend> members = new ArrayList<>();
            String[] tokens;
            for (Member member : Main.getListOfMembersForFrontend()) {
                tokens = member.lineRepresentation().split(", ");
                members.add(new MemberFrontend(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]));
            }
            return members;
        }

        public String getMemberID() {
            return memberID;
        }

        public String getName() {
            return name;
        }

        public String getMembershipType() {
            return membershipType;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class RegistrationFrontend {
        private String memberID;
        private String classID;
        private LocalDate registrationDate;
        private String status;

        public RegistrationFrontend(String memberId, String classId, LocalDate registrationDate, String status) {
            this.memberID = memberId;
            this.classID = classId;
            this.registrationDate = registrationDate;
            this.status = status;
        }

        public static ArrayList<RegistrationFrontend> getRegistrationsFromBackend() {
            ArrayList<RegistrationFrontend> registrations = new ArrayList<>();
            String[] tokens;
            for (MemberClassRegistration registration: Main.getListOfRegistrationsForFrontend()) {
                tokens = registration.lineRepresentation().split(", ");
                registrations.add(new RegistrationFrontend(tokens[0], tokens[1], LocalDate.parse(tokens[2]), tokens[3]));
            }
            return registrations;
        }

        public String getMemberID() {
            return memberID;
        }

        public String getClassID() {
            return classID;
        }

        public LocalDate getRegistrationDate() {
            return registrationDate;
        }

        public String getStatus() {
            return status;
        }
    }
}
