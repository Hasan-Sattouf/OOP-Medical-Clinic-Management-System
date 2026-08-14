package phase1;
import java.util.*;
import java.time.LocalDate;
public class Driver {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Patient> patientList = new ArrayList<>();//to store patients
        boolean selection = false;
        while (!selection) {//error if i declared selection as int because ! is boolean 
         System.out.println("Please Select an Operation (1-6): ");
            System.out.println("1. New Blood Test visit");
            System.out.println("2. New Alcohol Test visit");
            System.out.println("3. New Incident visit");
            System.out.println("4. New Immunization visit");
            System.out.println("5. Print Patient visit information");
            System.out.println("6. Exit");
           
            int choiceCase = in.nextInt();//selected choice
            in.nextLine();
            switch (choiceCase) {
                case 1:
                	addingVisit(1,patientList);
                    break;
                case 2:
                	addingVisit(2,patientList);
                    break;
                case 3:
                	addingVisit(3,patientList);
                    break;
                case 4:
                	addingVisit(4,patientList);
                    break;
                case 5:
                	printPatientVisitInfo(patientList);
                    break;
                case 6:
                    System.out.println("You have logged out of our system. Goodbye 🙂");
                    selection = true;// to exit from while loop >> !true=false
                    break;
                default:
                    System.out.println("Please select a number between 1 and 6:");
                    break;//i can remove it
            }
        }
    }
	
	
        // add a visit for tests
	    private static void addingVisit(int test, ArrayList<Patient> patientList) {
	        Patient patient = checkingPatient(patientList);
	        Clinic clinic = addClinic();
	        Visit visit=null;//declaretion and initialize it by null
	        
	        if(test==1){
	                BloodTest blood= new BloodTest();
	                System.out.print("Enter RBC: ");
	                blood.setRBC(in.nextDouble());
	                in.nextLine(); 
	                System.out.print("Enter WBC: ");
	                blood.setWBC(in.nextDouble());
	                in.nextLine(); 
	                System.out.print("Enter PLT: ");
	                blood.setPLT(in.nextDouble());
	                in.nextLine(); 
	                visit= blood;
	                 }
	        else if(test==2) {
	                AlcoholTest alcohol = new AlcoholTest();
	                System.out.print("Enter BAC: ");
	                alcohol.setBAC(in.nextDouble());
	                in.nextLine(); 
	                System.out.print("Enter test result (POSITIVE/NEGATIVE): ");
	                alcohol.setTestResult(in.nextLine());
	                visit= alcohol;
	                }
	        else if(test==3) {
	                Incident incident = new Incident();
	                System.out.print("Enter severity (LOW/MEDIUM/HIGH): ");
	                incident.setSeverity(in.nextLine());
	                System.out.print("Enter body part: ");
	                incident.setBodyPart(in.nextLine());
	                visit =incident ;
	              }
	        else if(test==4) {
	                Immunization immunization =new Immunization();
	                System.out.print("Enter vaccine name: ");
	                immunization.setVaccineName(in.nextLine());
	                System.out.print("Enter Dose: ");
	                immunization.setDose(in.nextLine());
	                visit = immunization;
	             }

	        if (visit!= null) {
	        	visit.setVisitDate(LocalDate.now());//store the current time
	        	visit.setClinic(clinic);
	            System.out.print("Enter Symptoms: ");
	            visit.setSymptoms(in.nextLine());
	            System.out.print("Enter Diagnosis: ");
	            visit.setDiagnosis(in.nextLine());
	            patient.addVisit(visit);
	        }
	    }
	    
//check if the patient exists , if not creat one
	 private static Patient checkingPatient(ArrayList<Patient> patientList) {
	        System.out.print("Enter patient name: ");
	        String fullName =in.nextLine();//take the full name

	        for(int i=0;i<patientList.size();i++){ 
	            if (patientList.get(i).getName().equals(fullName))
	             return patientList.get(i);//return the patient if it exists 
	        }

	       //if it does not exist create one
	        System.out.print("Enter date of birth (yyyy-mm-dd), Gender, City, Occupation and Has insurance?(true OR false):");
	        String dob=in.next();//convert from string to LocalDate in parameter
	        in.nextLine(); 
	        String gender=in.next();
	        in.nextLine(); 
	        String city=in.nextLine();//city name may have two parts or more so use line
	        String occupation =in.nextLine();
	        boolean hasInsurance=in.nextBoolean();
	        in.nextLine(); 
            Patient patient = new Patient(fullName, LocalDate.parse(dob), gender, city, occupation, hasInsurance);
            patientList.add(patient);
	        return patient;//return the patient
	        //we can initialize p with no args. and fill it by use setter methods
	    }

	 // create new clinic and enter its values
	    private static Clinic addClinic() {
	        System.out.print("Enter for the clinic name, location and telephone:");
	        String name=in.nextLine();
	        String location=in.nextLine();
	        String telephone=in.nextLine();
	        Clinic clinic = new Clinic(name, location, telephone);
	        return clinic;
	    }
	 //printing patient visits info.
	    private static void printPatientVisitInfo(ArrayList<Patient> patientList) {
	        System.out.print("Enter patient name: ");
	        String name = in.nextLine();
	        for (Patient p : patientList) {  // search for that Patient
	            if (p.getName().equals(name)) {
	                for (Visit v : p.getVisits()){  //print all visits which were stored in the ArrayList<visits> in Patient class
	                    v.generateReport();
	                }
	                return;//stop if we find the patient and print info.
	            }
	        }
	        System.out.println("Patient not found!");
	    }
	}
