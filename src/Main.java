public class Main {
    public static void main(String[] args) {


        User ironMan = new User(1, "Tony", "Stark", "Male", "tony.stark@starkindustries.com");
        Patient thor = new Patient(2, "Thor", "", "Male", "thor@asgard.com", 1001, false);
        Doctor hulk = new Doctor(3, "Bruce", "Banner", "Male", "bruce.banner@gamma.com",
                2001, 10, "Radiologist", 120000, 3001, "Radiology");
        Nurse blackWidow = new Nurse(4, "Natasha", "Romanoff", "Female", "natasha.romanoff@shield.com",
                2002, 5, "ICU Nurse", 80000, 4001);


        System.out.println("Iron Man: " + ironMan.getId() + ", " + ironMan.getFirstName() + " " + ironMan.getLastName() + ", " + ironMan.getGender() + ", " + ironMan.getEmail());
        System.out.println("Thor: " + thor.getId() + ", " + thor.getFirstName() + " " + thor.getLastName() + ", " + thor.getGender() + ", " + thor.getEmail() + ", " + thor.getPatientId() + ", " + (thor.isInsured() ? "Insured" : "Not Insured"));
        System.out.println("Hulk: " + hulk.getId() + ", " + hulk.getFirstName() + " " + hulk.getLastName() + ", " + hulk.getGender() + ", " + hulk.getEmail() + ", " + hulk.getStaffId() + ", " + hulk.getYearsOfExperience() + ", " + hulk.getDescription() + ", " + hulk.getSalary() + ", " + hulk.getDoctorId() + ", " + hulk.getSpecialization());
        System.out.println("Black Widow: " + blackWidow.getId() + ", " + blackWidow.getFirstName() + " " + blackWidow.getLastName() + ", " + blackWidow.getGender() + ", " + blackWidow.getEmail() + ", " + blackWidow.getStaffId() + ", " + blackWidow.getYearsOfExperience() + ", " + blackWidow.getDescription() + ", " + blackWidow.getSalary() + ", " + blackWidow.getNurseId());
    }
}