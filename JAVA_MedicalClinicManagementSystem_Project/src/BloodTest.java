package phase1;
import java.time.LocalDate;
public class BloodTest extends Visit{
	private double RBC;
	private double WBC;
	private double PLT;

    public BloodTest() {
	}

	public BloodTest(LocalDate visitDate, String symptoms, String diagnosis, Clinic clinic, double RBC, double WBC, double PLT) {
        super(visitDate, symptoms, diagnosis, clinic);
        this.RBC = RBC;
        this.WBC = WBC;
        this.PLT = PLT;
    }

    public double getRBC() {
		return RBC;
	}

	public void setRBC(double RBC) {
		this.RBC = RBC;
	}

	public double getWBC() {
		return WBC;
	}

	public void setWBC(double WBC) {
		this.WBC = WBC;
	}

	public double getPLT() {
		return PLT;
	}

	public void setPLT(double PLT) {
		this.PLT = PLT;
	}

	
    @Override
    public void generateReport(){
    	// i can print all of them in the same println but that form is easier
        System.out.println("Blood Test Report: ");
        System.out.println(super.toString());
        System.out.println("RBC: " + RBC + ", WBC: " + WBC + ", PLT: " + PLT);// i can do @Override toString() to return Blood,Alchol..test info. then call it in generateReport() method for each test
       // System.out.println("-----"); //To make reading better at end of each test
    }
}
