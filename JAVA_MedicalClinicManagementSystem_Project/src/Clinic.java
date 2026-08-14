package phase1;
public class Clinic {
	private String clinicName;
	private String location;
	private String telephone;
	
	public Clinic() {
	}

	public Clinic(String clinicName, String location, String telephone) {
			this.clinicName = clinicName;
			this.location = location;
			this.telephone = telephone;
	}
	
	public String getClinicName() {
		   return clinicName;
	}
	
	public void setClinicName(String clinicName) {
		   this.clinicName = clinicName;
	}
	
	public String getLocation() {
		   return location;
	}
	
	public void setLocation(String location) {
		    this.location = location;
	}
	
	public String getTelephone() {
		   return telephone;
	}
	
	public void setTelephone(String telephone) {
	    	this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "\nClinic [clinicName=" + clinicName + ", location=" + location + ", telephone=" + telephone + "]";
	}
	
	
}
