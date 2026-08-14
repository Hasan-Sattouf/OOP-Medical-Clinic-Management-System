package phase1;
import java.time.LocalDate;
public class Immunization extends Visit{
   private String vaccineName;
   private String dose;
   
   public Immunization() {
  }

   public Immunization(LocalDate visitDate, String symptoms, String diagnosis, Clinic clinic, String vaccineName, String dose) {
	super(visitDate, symptoms, diagnosis, clinic);
	this.vaccineName = vaccineName;
	this.dose = dose;
   }

   public String getVaccineName() {
	return vaccineName;
   }

   public void setVaccineName(String vaccineName) {
	this.vaccineName = vaccineName;
   }

   public String getDose() {
	return dose;
   }

   public void setDose(String dose) {
	this.dose = dose;
   }
   
  @Override
   public void generateReport(){
	      System.out.println("Immunization Report: ");
	      System.out.println(super.toString());
	      System.out.println("Vaccine Name: "+vaccineName+", Dose: "+dose);
   }
}
