package phase1;
import java.time.LocalDate;
public abstract class Visit{
	 private LocalDate visitDate;
	 private String symptoms;
	 private String diagnosis;
	 private Clinic clinic;// To establish the relation 1 to * between the clinic and the visit 
 
    public Visit() { //No need to add it because all values ​​are usually entered 
	}

	public Visit(LocalDate visitDate, String symptoms, String diagnosis, Clinic clinic){
	        this.visitDate = visitDate;
	        this.symptoms = symptoms;
	        this.diagnosis = diagnosis;
	        this.clinic = clinic;
	 }

	//Generally, there is no need to add ALL getters/setters because all values ​​are entered and not modified in our case (Clinic System)
   //However, there is a possibility that there is incorrect information that we will correct it by use setters 
	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
  
	@Override
	public String toString() {
		return visitDate + ";" + symptoms + ";" + diagnosis; 
	}
    
}
