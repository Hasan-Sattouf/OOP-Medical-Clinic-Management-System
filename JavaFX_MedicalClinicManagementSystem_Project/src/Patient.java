package phase1;
import java.util.*;//importing ArrayList class etc.
import java.time.LocalDate;
public class Patient{
 private String name;  //OR private  String name,gender,city,occupation;
 private LocalDate dateOfBirth;
 private String gender;
 private String city;
 private String occupation;
 private boolean hasInsurance;//has or not>> true/false
 private Visit visit;//because, each patient has one visit(incident) 
 //for storing lists of Visits:
 // we can replace it with private ArrayList<Visit> visits as used in phase1  
 public Patient() {
	 
 }
 public Patient(String name, LocalDate dateOfBirth, String gender, String city, String occupation, boolean hasInsurance) {
	this.name = name;
	this.dateOfBirth = dateOfBirth;//(year,month,date)
	this.gender = gender;
	this.city = city;
	this.occupation = occupation;
	this.hasInsurance = hasInsurance;
 }
 //visit entered by setVisit because we first inter the major info.

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public LocalDate getDateOfBirth() {
	return dateOfBirth;
 }

 public void setDateOfBirth(LocalDate dateOfBirth) {//in main use Date(year,month,date)
	this.dateOfBirth = dateOfBirth;
 }

 public String getGender() {
	return gender;
 }

 public void setGender(String gender) {
	this.gender = gender;
 }

 public String getCity() {
	return city;
 }

 public void setCity(String city) {
	this.city = city;
 }

 public String getOccupation() {
	return occupation;
 }

 public void setOccupation(String occupation) {
	this.occupation = occupation;
 }

 public boolean isHasInsurance() {
	return hasInsurance;
 }

 public void setHasInsurance(boolean hasInsurance) {
	this.hasInsurance = hasInsurance;
 }
 public Visit getVisit() {
	return visit;
 }
 public void setVisit(Visit visit) {
	this.visit = visit;
 }
 @Override
 public String toString() {
	return name + ";" + dateOfBirth + ";" + gender + ";" + city
			+ ";" + occupation + ";" + hasInsurance +";"+ visit.toString()+";"+visit.getClinic().toString();
 }

 
}
