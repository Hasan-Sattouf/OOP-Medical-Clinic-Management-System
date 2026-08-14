package phase1;
import java.time.LocalDate;
public class Incident extends Visit{
	private String severity;// (LOW/MEDIUM/HIGH)
	private String bodyPart;
	
	public Incident() {
	}

	public Incident(LocalDate visitDate, String symptoms, String diagnosis, Clinic clinic, String severity, String bodyPart) {
		 super(visitDate, symptoms, diagnosis, clinic);
		 this.severity=severity;
		 this.bodyPart=bodyPart;
	}
	
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	@Override
	public String toString() {
		return super.toString()+";"+ severity + ";" + bodyPart;
	}
	
	

}
