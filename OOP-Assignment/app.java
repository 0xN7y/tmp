//N7y
import java.util.ArrayList;
import java.util.Scanner;


// "admin", "admin", "Admin"
// "doc1", "doc1", "Doctor"
// "nurse1", "nurse1", "Nurse
// "patient1", "patient1", "patient1", "Flu", "Prescribed Rest"


class UserInfo {
    int ID;
    String username;
    String password;
    String role;

    UserInfo(int ID, String username, String password, String role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

class PatientInfo {
    int patientID;
    String name;
    String disease;
    String record;
    ArrayList<String> appointments = new ArrayList<>();

    PatientInfo(int patientID, String name, String disease, String record) {
        this.patientID = patientID;
        this.name = name;
        this.disease = disease;
        this.record = record;
    }
}

class HospitalMgs {
    ArrayList<UserInfo> userList = new ArrayList<>();
    ArrayList<PatientInfo> patientList = new ArrayList<>();

    // Register Staff
    void registerStaff(String username, String password, String role) {
        int id = 1000 + userList.size();
        UserInfo user = new UserInfo(id, username, password, role);
        userList.add(user);
        System.out.println(role + " registered successfully with ID: " + id);
    }

    // Register Patient
    void registerPatient(String name, String username, String password, String disease, String record) {
        int patientID = 5000 + patientList.size();
        PatientInfo patient = new PatientInfo(patientID, name, disease, record);
        patientList.add(patient);
        UserInfo user = new UserInfo(patientID, username, password, "Patient");
        userList.add(user);
        System.out.println("Patient registered successfully with ID: " + patientID);
    }



    // Login
    UserInfo login(String username, String password) {
        for (UserInfo user : userList) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful as " + user.role + "!");
                return user;
            }
        }
        System.out.println("Invalid credentials. Login failed.");
        return null;
    }

    // Admin Functions
    void viewStaff() {
        System.out.println("Staff List:");
        for (UserInfo user : userList) {
            if (!user.role.equals("Patient")) {
                System.out.println("ID: " + user.ID + ", Username: " + user.username + ", Role: " + user.role);
            }
        }
    }

    void viewPatients() {
        System.out.println("Patient List:");
        for (PatientInfo patient : patientList) {
            System.out.println("ID: " + patient.patientID + ", Name: " + patient.name + ", Disease: " + patient.disease);
        }
    }
    void removePatient(String name) {
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).name.equalsIgnoreCase(name)) {
                patientList.remove(i);
                System.out.println("Patient " + name + " has been removed.");
                return;
            }
        }
        System.out.println("Patient not found!");
    }
    void removeStaff(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).username.equalsIgnoreCase(username) && !userList.get(i).role.equals("Patient")) {
                userList.remove(i);
                System.out.println("Staff " + username + " has been removed.");
                return;
            }
        }
        System.out.println("Staff not found!");
    }


    // Doctor Functions
    void viewPatientRecord(String name) {
        for (PatientInfo patient : patientList) {
            if (patient.name.equalsIgnoreCase(name)) {
                System.out.println("Patient Name: " + patient.name);
                System.out.println("Disease: " + patient.disease);
                System.out.println("Record: " + patient.record);
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    void addPatientRecord(String name, String record) {
        for (PatientInfo patient : patientList) {
            if (patient.name.equalsIgnoreCase(name)) {
                patient.record = record;
                System.out.println("Patient record updated for " + name);
                return;
            }
        }
        System.out.println("Patient not found!");
    }
    void doctorRemovePatient(String name) {
        removePatient(name); 
    }

    // Nurse Functions
    void nurseViewPatientRecord(String name) {
        viewPatientRecord(name);
    }

    // Patient Functions
    void bookAppointment(String patientName, String details) {
        for (PatientInfo patient : patientList) {
            if (patient.name.equalsIgnoreCase(patientName)) {
                patient.appointments.add(details);
                System.out.println("Appointment booked for " + patientName);
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    void viewMedicalHistory(String username) {
        for (UserInfo user : userList) {
            if (user.username.equalsIgnoreCase(username) && user.role.equals("Patient")) {
                for (PatientInfo patient : patientList) {
                    if (patient.patientID == user.ID) {
                        System.out.println("Medical History for " + patient.name);
                        System.out.println("Disease: " + patient.disease);
                        System.out.println("Record: " + patient.record);
                        return;
                    }
                }
            }
        }
        System.out.println("No medical history found!");
    }
}

public class app {
    public static void clear() {
    try {
            if (System.getProperty("os.name").contains("Windows")) {
               
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
      
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        HospitalMgs hospital = new HospitalMgs();
        Scanner input = new Scanner(System.in);

        hospital.registerStaff("admin", "admin", "Admin");
        hospital.registerStaff("doc1", "doc1", "Doctor");
        hospital.registerStaff("nurse1", "nurse1", "Nurse");

        hospital.registerPatient("patient1", "patient1", "patient1", "Flu", "Prescribed Rest");

        
        while (true) {
            System.out.println("\n\t********************************************");
            System.out.println("        Hospital Management System");
            System.out.println("\t********************************************\n\n");
            System.out.println("1. Login for Staff");
            System.out.println("2. Login for Patient");
            System.out.println("3. Exit");
            System.out.println("\n");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {

                choice = input.nextInt();
            }catch (java.util.InputMismatchException e) {
		        clear();
                System.out.println("Invalid input Type");
                input.nextLine();
            }
            input.nextLine();

            if (choice == 3) {
		        clear();
                System.out.println("Exiting the system...");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter Username: ");
                String username = input.nextLine();
                System.out.print("Enter Password: ");
                String password = input.nextLine();

                UserInfo loggedInUser = hospital.login(username, password);
                if (loggedInUser == null) continue;

                if (loggedInUser.role.equals("Admin")) {
                    System.out.println("\n");
                    while (true) {
                        System.out.println("1. View Staff");
                        System.out.println("2. View Patients");
                        System.out.println("3. Register Staff");
                        System.out.println("4. Register Patient");
                        System.out.println("5. Remove Staff");
                        System.out.println("6. Remove Patient");
                        System.out.println("7. Logout");
                        System.out.println("\n");
                        System.out.print("Enter your choice: ");
                        
                        int adminChoice = input.nextInt();
                        input.nextLine();

			System.out.println("\n");
			clear();
                        if (adminChoice == 7) {
                            clear();
                            break;
                        }

                        switch (adminChoice) {
                            case 1 : 
                                System.out.println("\n");
                                hospital.viewStaff();
                                System.out.println("\n");
                                break;
                            case 2 : 
                                System.out.println("\n");
                                hospital.viewPatients();
                                System.out.println("\n");
                                break;
                            case 3 : 

                                System.out.println("\n \tRegister Staff \n");
                                System.out.print("Enter Username: ");
                                String staffUsername = input.nextLine();
                                System.out.print("Enter Password: ");
                                String staffPassword = input.nextLine();
                                System.out.print("Enter Role (Doctor/Nurse): ");
                                String role = input.nextLine();
                                hospital.registerStaff(staffUsername, staffPassword, role);
                                System.out.println("\n");
                                break;
                            
                            case 4 : 
                                System.out.println("\n \tRegister Patient \n");
                                System.out.print("Enter Patient Name: ");
                                String patientName = input.nextLine();
                                System.out.print("Enter Username: ");
                                String patientUsername = input.nextLine();
                                System.out.print("Enter Password: ");
                                String patientPassword = input.nextLine();
                                System.out.print("Enter Disease: ");
                                String disease = input.nextLine();
                                System.out.print("Enter Record (Additional Info): ");
                                String record = input.nextLine();
                                hospital.registerPatient(patientName, patientUsername, patientPassword, disease, record);
                                System.out.println("\n");
                                break;
                            case 5 : 
                                System.out.println("\n");
                                System.out.print("Enter Staff Username to Remove: ");
                                staffUsername = input.nextLine();
                                hospital.removeStaff(staffUsername);
                                System.out.println("\n");
                                break;
                            case 6 : {
                                System.out.println("\n");
                                System.out.print("Enter Patient Name to Remove: ");
                                patientName = input.nextLine();
                                hospital.removePatient(patientName);
                                System.out.println("\n");
                                break;
                            }
                            default:
                                System.out.println("Invalid choice!");
                                break;

                            
                        }
                    }
                } else if (loggedInUser.role.equals("Doctor")) {
                    while (true) {
                        System.out.println("\n");
                        System.out.println("1. View Patient Record by Name");
                        System.out.println("2. Add/Update Patient Record");
                        System.out.println("3. Remove Patient by Name");
                        System.out.println("4. Logout");
                        System.out.println("\n");
                        System.out.print("Enter your choice: ");
                        int doctorChoice = input.nextInt();
                        input.nextLine();
                        System.out.println("\n");
                        if (doctorChoice == 4) {
                            clear();
                            break;
                        }

                        switch (doctorChoice) {
                            case 1: {
                                System.out.print("Enter Patient Name: ");
                                String name = input.nextLine();
                                hospital.viewPatientRecord(name);
                                break;
                            }
                            case 2 : {
                                System.out.print("Enter Patient Name: ");
                                String name = input.nextLine();
                                System.out.print("Enter Record Details: ");
                                String record = input.nextLine();
                                hospital.addPatientRecord(name, record);
                                break;
                            }
                            case 3 : {
                                System.out.print("Enter Patient Name to Remove: ");
                                String name = input.nextLine();
                                hospital.doctorRemovePatient(name);
                                break;
                            }
                            default :
                                System.out.println("Invalid choice!");
                                break;
                        }
                    }
                } else if (loggedInUser.role.equals("Nurse")) {
                    System.out.println("\n");
                    while (true) {
                        System.out.println("1. View Patient Record by Name");
                        System.out.println("2. Logout");
                        System.out.println("\n");
                        System.out.print("Enter your choice: ");
                        int nurseChoice = input.nextInt();
                        input.nextLine();

                        if (nurseChoice == 2) {
                            clear();
                            break;
                        }

                        if (nurseChoice == 1) {
                            System.out.print("Enter Patient Name: ");
                            String name = input.nextLine();
                            hospital.nurseViewPatientRecord(name);
                        }
                    }
                }
            } else if (choice == 2) {
                System.out.println("\n");
                System.out.print("Enter Username: ");
                String username = input.nextLine();
                System.out.print("Enter Password: ");
                String password = input.nextLine();

                UserInfo loggedInUser = hospital.login(username, password);
                if (loggedInUser == null || !loggedInUser.role.equals("Patient")) {
                    System.out.println("Invalid Patient Credentials!");
                    continue;
                }

                while (true) {
                    System.out.println("\n");
                    System.out.println("1. Book Appointment");
                    System.out.println("2. View Medical History");
                    System.out.println("3. Logout");
                    System.out.println("\n");
                    System.out.print("Enter your choice: ");
                    int patientChoice = input.nextInt();
                    input.nextLine();

                    if (patientChoice == 3) {
                        clear();
                        break;
                    } 

                    switch (patientChoice) {
                        case 1 : {
                            System.out.print("Enter Appointment Details: ");
                            String details = input.nextLine();
                            hospital.bookAppointment(loggedInUser.username, details);
			                Syetem.out.println("\n");
				            break;
                        }
                        case 2 : hospital.viewMedicalHistory(loggedInUser.username);
                    }
                }
            }
        }

       
    }
}
