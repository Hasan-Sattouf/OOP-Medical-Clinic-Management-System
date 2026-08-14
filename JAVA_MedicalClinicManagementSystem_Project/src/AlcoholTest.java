package phase1;
import java.time.LocalDate;
public class AlcoholTest extends Visit{
  private double BAC;//its shortage for Blood Alcohol Concentration 
  private String testResult;// (POSITIVE/NEGATIVE)
 
  public AlcoholTest() {
	  
  }
  public AlcoholTest(LocalDate visitDate, String symptoms, String diagnosis, Clinic clinic, double BAC, String testResult) {
	 super(visitDate, symptoms, diagnosis, clinic);
	 this.BAC=BAC;
	 this.testResult=testResult;
 }
  // generally there's nothing to do getters/setters because the values ​​are usually entered once and printed
  public double getBAC(){
	 return BAC;
   }

  public void setBAC(double bAC){
 	  BAC = bAC;
   }

  public String getTestResult(){
      return testResult;
   }

  public void setTestResult(String testResult){
	this.testResult = testResult;
   }

  @Override
  public void generateReport(){
      System.out.println("Alcohol Test Report: ");
      System.out.println(super.toString());
      System.out.println("BAC: "+BAC+", Test Result: "+testResult);
     }
  }
