package phase1;
import java.io.*;
public  class FileManager {

    public static void savePatientVisit(Patient patient) {//static relative to the class
      try{
        FileWriter fw = new FileWriter("patientINFO.txt", true);//to append
        PrintWriter pw = new PrintWriter(fw);
     
        pw.println(patient.toString());
        pw.close();
     
       }
      catch(IOException e) {
    	  //System.out.println("There is an error while saving in the file:");
    	  e.printStackTrace();
      }
      //when we will red from the file ->
      /*  while(sc.nextLine()) {
        	String s=sc.nextLine();//each patient in each line
        	String[] patients=s.split(";");
        	(patients[0]=patient name)....
        	*/
        }
    }

