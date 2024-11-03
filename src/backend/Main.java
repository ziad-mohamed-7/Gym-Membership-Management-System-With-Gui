package backend;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            AdminRole admin = new AdminRole();
            // add trainer
            admin.addTrainer("T1", "Ziad", "ziad@laef.com", "Calisthenics", "01000000302");
            System.out.println("Num of Trainers: " + admin.getListOfTrainers().size() + " and it's supposed to be 1");
            // duplicate trainer
            admin.addTrainer("T1", "Ziad", "ziad@laef.com", "Calisthenics", "01000000302");
            // add another trainer
            admin.addTrainer("T2", "Rofa", "Rofa@laef.com", "Dead Lifting", "01222200302");
            // remove trainer
            admin.removeTrainer("T2");
            System.out.println("Num of Trainers: " + admin.getListOfTrainers().size() + " and it's supposed to be 1");
            admin.logout();
        } catch (Exception e) {
            System.out.println("test1:" + e.getMessage());
        }

        try {
            TrainerRole trainer = new TrainerRole();
            // add member
            trainer.addMember("M1", "Karim", "Monthly", "karim@laef.com", "01111100302", "active");
            System.out.println("Num of Members: " + trainer.getListOfMembers().size() + " and it's supposed to be 1");
            //  duplicate member
            trainer.addMember("M1", "Karim", "Monthly", "karim@laef.com", "01111100302", "active");
            // add another member
            trainer.addMember("M2", "Taha", "Monthly", "taha@laef.com", "01555500302", "active");
            System.out.println("Num of Members: " + trainer.getListOfMembers().size() + " and it's supposed to be 2");
            trainer.logout();
        } catch (Exception e) {
            System.out.println("test2:" + e.getMessage());
        }
        try {
            AdminRole admin = new AdminRole();
            TrainerRole trainer = new TrainerRole();
            // add class
            trainer.addClass("C1", "Calisthenics", "T1", 5, 20);
            System.out.println("Num of Classes: " + trainer.getListOfClasses().size() + " and it's supposed to be 1");
            // duplicate class
            trainer.addClass("C1", "Calisthenics", "T1", 5, 20);
            // add another class
            admin.addTrainer("T3", "Maro", "Maro@laef.com", "Boxing", "01555500302");
            trainer.addClass("C2", "Boxing", "T3", 5, 1);
            System.out.println("Num of classes: " + trainer.getListOfClasses().size() + " and it's supposed to be 2");
            admin.logout();
            trainer.logout();
        } catch (Exception e) {
            System.out.println("test3:" + e.getMessage());
        }

        try {
            TrainerRole trainer = new TrainerRole();
            // register member for a class
            boolean flag1 = trainer.registerMemberForClass(trainer.getListOfMembers().getFirst().getSearchKey(), "C1", LocalDate.now());
            if (!flag1) System.out.println("register1 failed");
            else System.out.println("register1 passed");
            // register another member for a class
            boolean flag2 = trainer.registerMemberForClass(trainer.getListOfMembers().get(1).getSearchKey(), "C2", LocalDate.now().minusDays(10));
            if (!flag2) System.out.println("register2 failed");
            else System.out.println("register2 passed");
            // register member for a non-existing class
            boolean flag3 = trainer.registerMemberForClass(trainer.getListOfMembers().get(1).getSearchKey(), "C3", LocalDate.now());
            if (!flag3) System.out.println("register3 passed");
            else System.out.println("register3 failed");
            // register non-existing member for a class
            boolean flag4 = trainer.registerMemberForClass("M3", "C2", LocalDate.now());
            if (!flag4) System.out.println("register4 passed");
            else System.out.println("register4 failed");
            // register member for a class with no seats
            trainer.addMember("M3", "Ghazal", "Monthly", "Ghazal@laef.com", "01011140307", "active");
            boolean flag5 = trainer.registerMemberForClass("M3", "C2", LocalDate.now());
            if (!flag5) System.out.println("register5 passed");
            else System.out.println("register5 failed");
            // cancel registration (valid  -> before 3 days)
            boolean flag6 = trainer.cancelRegistration(trainer.getListOfMembers().getFirst().getSearchKey(), "C1");
            if (!flag6) System.out.println("cancel failed");
            else System.out.println("cancel (valid) passed and the status now is: " + trainer.getListOfRegistrations().getFirst().getStatus());
            // cancel registration (invalid -> after 3 days)
            boolean flag7 = trainer.cancelRegistration(trainer.getListOfMembers().get(1).getSearchKey(), "C2");
            if (!flag7) System.out.println("cancel (invalid) passed");
            else System.out.println("cancel failed");
            trainer.logout();
        } catch (Exception e) {
            System.out.println("test4:" + e.getMessage());;
        }
    }
}


