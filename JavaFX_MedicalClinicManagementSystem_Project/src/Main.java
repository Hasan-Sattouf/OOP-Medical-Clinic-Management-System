package phase1;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.ComboBox;
public class Main extends Application {

    @Override
    public void start(Stage stage) {
    	
    	GridPane root=new GridPane();
    	root.setHgap(10);
    	root.setVgap(10);
    	root.setPadding(new Insets(15));
    	
    	//creat labels,texfields and radiobuttos 
    	Label lbPatient=new Label("PATIENT INFO:");
    	   lbPatient.setFont(Font.font("System",FontWeight.BOLD,13));
    	Label lbName=new Label("Patient Name:");
    	TextField txtName=new TextField();
    	Label LbDob=new Label("Date Of Birth:");
    	TextField txtDob=new TextField();
    	Label lbDobForm=new Label("YYYY-MM-DD");
    	Label lbGender=new Label("Gender:");
    	RadioButton rbMale=new RadioButton("Male");
    	RadioButton rbFemale=new RadioButton("Female");
    	Label lbCity=new Label("City:");
    	TextField txtCity=new TextField();
    	Label lbOccupation=new Label("Occupation:");
    	TextField txtOccupation=new TextField();
    	Label lbHasInsurance=new Label("Has Insurance:");
    	RadioButton rbYesHasInsurance=new RadioButton("YES");
    	RadioButton rbNoHasInsurance=new RadioButton("NO");
    	
    	Label lbVisit=new Label("VISIT INFO:");
    	  lbVisit.setFont(Font.font("System",FontWeight.BOLD,13));
    	Label lbVisitDate=new Label("Visit Date:");
    	TextField txtVisitDate=new TextField(""+LocalDate.now());
    	Label lbSymptoms=new Label("Symptoms:");
    	TextField txtSymptoms=new TextField();
    	Label lbDiagnosis=new Label("Diagnosis:");
    	TextField txtDiagnosis=new TextField();
    	
    	Label lbClinic=new Label("CLINIC INFO:");
    	     lbClinic.setFont(Font.font("System",FontWeight.BOLD,13));
    	Label lbClinicName=new Label("Clinic Name:");
    	TextField txtClinicName=new TextField();
    	Label lbLocation=new Label("Location:");
    	TextField txtLocation=new TextField();
    	Label lbTelephone=new Label("Telephone:");
    	TextField txtTelephone=new TextField();
    	
    	Label lbIncident=new Label("INCIDENT INFO:");
    	lbIncident.setFont(Font.font("System",FontWeight.BOLD,13));
    	Label lbSeverity=new Label("Severity:");
    	ComboBox<String> severityStatus=new ComboBox<>();
    	severityStatus.getItems().addAll("LOW","MEDIUM","HIGH");
    	   severityStatus.setValue("MEDIUM");
    	Label lbBodyPart=new Label("Body Part:");
    	TextField txtBodyPart=new TextField();
   
    	Button save=new Button("Save");
        Button clear=new Button("Clear");
        
    	//Add labels,texfields and radiobuttos to GridPane
    	
    	root.addRow(0,lbPatient);//root.addRow(1,new Label("PATIENT INFO:")); ANOTHOR WAY easy in one step
    	root.addRow(1,lbName,txtName);
    	root.addRow(2,LbDob,txtDob,lbDobForm);
    	root.addRow(3,lbGender,rbMale,rbFemale);
    	root.addRow(4,lbCity,txtCity);
    	root.addRow(5,lbOccupation,txtOccupation);
    	root.addRow(6,lbHasInsurance,rbYesHasInsurance,rbNoHasInsurance);
    
    	root.addRow(7,lbVisit);
    	root.addRow(8,lbVisitDate,txtVisitDate);
    	root.addRow(9,lbSymptoms,txtSymptoms);
    	root.addRow(10,lbDiagnosis,txtDiagnosis);
    	
    	root.addRow(11,lbIncident);
    	root.addRow(12,lbSeverity,severityStatus);
    	root.addRow(13,lbBodyPart,txtBodyPart);
    	
    	root.addRow(14,lbClinic);
    	root.addRow(15,lbClinicName,txtClinicName);
    	root.addRow(16,lbLocation,txtLocation);
    	root.addRow(17,lbTelephone,txtTelephone);
    	
    	root.addRow(18,save,clear);
    	
    	
    	
    	//create objects
    	Patient patient=new Patient();
    	Visit visit=new Incident();
    	Clinic clinic=new Clinic();
    	
    	//handel event the textfields and buttons
    	ToggleGroup tg1=new ToggleGroup();
    	ToggleGroup tg2=new ToggleGroup();
    	rbMale.setToggleGroup(tg1);
    	rbFemale.setToggleGroup(tg1);
    	rbYesHasInsurance.setToggleGroup(tg2);
    	rbNoHasInsurance.setToggleGroup(tg2);
    	
    	           //when the save button clicked
    	save.setOnAction(e->{
    //i cane do -->> if(txtName.getText().isEmpty() &&>........) checkAlert("please enter all information:");
    		         
 //validation patient info.
    		if(txtName.getText().isEmpty()) {
    			checkAlert("Please enter the patient name:");
    			return;//to prevent add any missing value in the objs,
    		}
            
    		try {
    			LocalDate.parse(txtDob.getText());
    		}
    		catch(Exception ex){
    			checkAlert("Please enter the date of birth in format (YYYY-MM-DD):");
    			return;
    		}
    		
    		if(!rbMale.isSelected()&&!rbFemale.isSelected()) {
    			checkAlert("Please select the patient Gender");
    			return;
    		}
    		
    		if(txtCity.getText().isEmpty()) {
    			checkAlert("Please enter the city name:");
    			return;
    		}
    		if(txtOccupation.getText().isEmpty()) {
    			checkAlert("Please enter the patient's occupation");
    			return;
    		}
    		if(!rbYesHasInsurance.isSelected()&&!rbNoHasInsurance.isSelected()) {
    			checkAlert("Please select YES/NO if the patient has insurance or not:");
    			return;
    		}
    		
  //validation visit info.
    		try {
    			LocalDate.parse(txtVisitDate.getText());
    		}
    		catch(Exception ex){
    			checkAlert("Please enter the date of visit in format (YYYY-MM-DD):");
    			return;
    		}
        
    		if(txtSymptoms.getText().isEmpty()) {
    			checkAlert("Please enter the patient's symptoms:");
    			return;
    		}
    		if(txtDiagnosis.getText().isEmpty()) {
    			checkAlert("Please enter the patient's diagnosis:");
    			return;
    		}
//validation Incident info.
        	
    		if(severityStatus.getValue()==null) {// i can remove it because i initialized the severityStatus
    			checkAlert("Please select the severity status:");
    			return;
    		}
        
        	if(txtBodyPart.getText().isEmpty()) {
    			checkAlert("Please enter the patient's body part:");
    			return;
    		}
        	
//validation clinic info.
        	if(txtClinicName.getText().isEmpty()) {
    			checkAlert("Please enter the clinic's name:");
    			return;
    		}
        	if(txtLocation.getText().isEmpty()) {
    			checkAlert("Please enter the clinic's location:");
    			return;
    		}
        	if(txtTelephone.getText().isEmpty()) {
    			checkAlert("Please enter the clinic's telephone:");
    			return;
    		}
        	
        	
        	
    		//setting patient info.
    		patient.setName(txtName.getText());
    		patient.setDateOfBirth(LocalDate.parse(txtDob.getText()));
    		
    		 if (rbMale.isSelected()){
    		        patient.setGender("Male");
    		    }
    		 else if (rbFemale.isSelected()){
    		        patient.setGender("Female");
    		    }

    		patient.setCity(txtCity.getText());
    		patient.setOccupation(txtOccupation.getText());
    		
    		if (rbYesHasInsurance.isSelected()){
    	        patient.setHasInsurance(true);
    	    } 
    		else if (rbNoHasInsurance.isSelected()){
    	        patient.setHasInsurance(false);
    	    }
    		
    		//setting visit info.
    	visit.setVisitDate(LocalDate.parse(txtVisitDate.getText()));
    	visit.setSymptoms(txtSymptoms.getText());
    	visit.setDiagnosis(txtDiagnosis.getText());
    	
    	 //setting Incident info.
    	((Incident)visit).setSeverity(severityStatus.getValue());
    	((Incident)visit).setBodyPart(txtBodyPart.getText());//down casting is always guarantee because there is just one type of visit ->>Incident
    	
    	   //setting clinic info.
    	clinic.setClinicName(txtClinicName.getText());
    	clinic.setLocation(txtLocation.getText());
    	clinic.setTelephone(txtTelephone.getText());
    	
    	visit.setClinic(clinic);
    	patient.setVisit(visit);
    	 
    	FileManager.savePatientVisit(patient);
    	});
    	
    	      //when the clear button clicked
    	clear.setOnAction(c->{
    		txtName.setText("");//.clear();//null
    		txtDob.setText("");
    		
    		txtCity.setText("");
    	txtOccupation.setText("");
    	txtVisitDate.setText(""+LocalDate.now());
    	txtSymptoms.setText("");
    	txtDiagnosis.setText("");
    	txtClinicName.setText("");
    	txtLocation.setText("");
    	txtTelephone.setText("");
    	severityStatus.setValue("MEDIUM");
    	txtBodyPart.setText("");
    	tg1.selectToggle(null);
    	tg2.selectToggle(null);
    	});
        Scene scene = new Scene(root, 450, 650);
        stage.setScene(scene);
        stage.setTitle("Hasan Clinic");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void checkAlert(String missing) {
    	Alert alert=new Alert(Alert.AlertType.ERROR);
    	alert.setContentText(missing);
    	alert.setHeaderText("Missing Information!");
    	alert.showAndWait();
    }
}