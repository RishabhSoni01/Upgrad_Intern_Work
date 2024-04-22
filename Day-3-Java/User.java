public class User {
    
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    
    public User(long id, String firstName, String lastName, String gender, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

class Patient extends User {
    
    private long patientId;
    private Boolean insured;
    
    public Patient(long userId, String firstName, String lastName, String gender, String email, long patientId, Boolean insured) {
        super(userId, firstName, lastName, gender, email);
        this.patientId = patientId;
        this.insured = insured;
    }
    
    public long getPatientId() {
        return patientId;
    }
    
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    
    public Boolean isInsured() {
        return insured;
    }
    
    public void setInsured(Boolean insured) {
        this.insured = insured;
    }
}

class Staff extends User {
    
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;
    
    public Staff(long userId, String firstName, String lastName, String gender, String email, long staffId, int yearsOfExperience, String description, double salary) {
        super(userId, firstName, lastName, gender, email);
        this.staffId = staffId;
        this.yearsOfExperience = yearsOfExperience;
        this.description = description;
        this.salary = salary;
    }
    
    public long getStaffId() {
        return staffId;
    }
    
    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Doctor extends Staff {
    
    private long doctorId;
    private String specialization;
    
    public Doctor(long userId, String firstName, String lastName, String gender, String email, long staffId, int yearsOfExperience, String description, double salary, long doctorId, String specialization) {
        super(userId, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }
    
    public long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

class Nurse extends Staff {
    
    private long nurseId;
    
    public Nurse(long userId, String firstName, String lastName, String gender, String email, long staffId, int yearsOfExperience, String description, double salary, long nurseId) {
        super(userId, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.nurseId = nurseId;
    }
    
    public long getNurseId() {
        return nurseId;
    }
    
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
}
class Main {
    public static void main(String[] args) {
        User user = new User(1, "John", "Doe", "Male", "john.doe@example.com");
        Patient patient = new Patient(2, "Jane", "Smith", "Female", "jane.smith@example.com", 1001, true);
        Doctor doctor = new Doctor(3, "Michael", "Jordan", "Male", "michael.jordan@example.com", 2001, 10, "Cardiology", 150000, 3001, "Cardiologist");
        Nurse nurse = new Nurse(4, "Emily", "Davis", "Female", "emily.davis@example.com", 2002, 5, "Registered Nurse", 80000, 4001);

        System.out.println("User ID: " + user.getId());
        System.out.println("User Name: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("User Email: " + user.getEmail());

        System.out.println();

        System.out.println("Patient ID: " + patient.getId());
        System.out.println("Patient Name: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Patient Email: " + patient.getEmail());
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Insured: " + patient.isInsured());

        System.out.println();

        System.out.println("Doctor ID: " + doctor.getId());
        System.out.println("Doctor Name: " + doctor.getFirstName() + " " + doctor.getLastName());
        System.out.println("Doctor Email: " + doctor.getEmail());
        System.out.println("Doctor ID: " + doctor.getStaffId());
        System.out.println("Years of Experience: " + doctor.getYearsOfExperience());
        System.out.println("Description: " + doctor.getDescription());
        System.out.println("Salary: " + doctor.getSalary());
        System.out.println("Doctor ID: " + doctor.getDoctorId());
        System.out.println("Specialization: " + doctor.getSpecialization());

        System.out.println();

        System.out.println("Nurse ID: " + nurse.getId());
        System.out.println("Nurse Name: " + nurse.getFirstName() + " " + nurse.getLastName());
        System.out.println("Nurse Email: " + nurse.getEmail());
        System.out.println("Nurse ID: " + nurse.getStaffId());
        System.out.println("Years of Experience: " + nurse.getYearsOfExperience());
        System.out.println("Description: " + nurse.getDescription());
        System.out.println("Salary: " + nurse.getSalary());
        System.out.println("Nurse ID: " + nurse.getNurseId());
    }
}
