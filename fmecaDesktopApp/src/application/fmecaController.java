package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class fmecaController extends GridPane {

	// FXML instances for the FX:IDs created in FXML file
	@FXML
	ChoiceBox<String> componentList, modesList, effectList, frequencyList, iterationsList, causeList, detectionList,
			possibilityList;
	@FXML
	Label rpnDisplayLabel;
	@FXML
	TextField suggestionsInput;
	@FXML
	Button rpnCalculateButton;

	/**
	 * initializer to load the contents for application
	 */
	@FXML
	private void initialize() {
		// add values to the drop down lists
		componentList.getItems().add("Select component");
		componentList.getItems().add("GPS");
		componentList.getItems().add("Radar System");
		componentList.getItems().add("Bluetooth");
		componentList.getItems().add("Cameras");
		// select the first item to display in the drop down by default
		componentList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		modesList.getItems().add("Select failure mode");
		modesList.getItems().add("Complete");
		modesList.getItems().add("Partial");
		modesList.getItems().add("Intermittent");
		modesList.getItems().add("Gradual");
		// select the first item to display in the drop down by default
		modesList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		effectList.getItems().add("Select Severity");
		// add values to the list for severity index
		effectList.getItems().add(10 + " - Hazardous without warning");
		// select the first item to display in the drop down by default
		effectList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		frequencyList.getItems().add("Select Occurence Frequency");
		// add values to the list for frequency
		for (int i = 1; i <= 10; i++) {
			frequencyList.getItems().add("Rank " + i);
		}
		// select the first item to display in the drop down by default
		frequencyList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		iterationsList.getItems().add("Select Number of Iterations");
		// add values to the list for Iterations
		for (int i = 10; i >= 1; i--) {
			iterationsList.getItems().add((i * 5) + "");
		}
		// select the first item to display in the drop down by default
		iterationsList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		causeList.getItems().add("Select Probable Cause");
		causeList.getItems().add("Broken communication");
		causeList.getItems().add("Authentication issues");
		causeList.getItems().add("Unauthorized communication");
		causeList.getItems().add("No 2 way handshake implementation done");
		causeList.getItems().add("Camera Lens dirty");
		causeList.getItems().add("Camera lens broken");
		causeList.getItems().add("Camera system not communicating with vehicle system");
		causeList.getItems().add("Insecure Open Port");
		causeList.getItems().add("Insufficient Personnel Trainings");
		causeList.getItems().add("No encryption algorithm used");
		causeList.getItems().add("Encryption algorithm malfunction");
		causeList.getItems().add("Weak authentication protocols used");
		causeList.getItems().add("Open port for Brute Force Authentication");
		causeList.getItems().add("Insufficient transmission of Data");
		causeList.getItems().add("LIDAR gathering incorrect data");
		causeList.getItems().add("Failed penetration testing");
		// select the first item to display in the drop down by default
		causeList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		detectionList.getItems().add("Select Detection Type");
		// add values to the list for Detection Type
		for (int i = 1; i <= 3; i++) {
			detectionList.getItems().add("Type " + i);
		}
		// select the first item to display in the drop down by default
		detectionList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		possibilityList.getItems().add("Select Detection Possibility");
		possibilityList.getItems().add(10 + " - Absolute Uncertainity");
		// add values to the list for Detection Type
		for (int i = 9; i > 1; i--) {
			effectList.getItems().add(i + "");
			possibilityList.getItems().add(i + "");
		}
		// add No effect and almost certain values to drop down lists
		effectList.getItems().add(1 + " - No Effect");
		possibilityList.getItems().add(1 + " - Almost Certain");
		// select the first item to display in the drop down by default
		possibilityList.getSelectionModel().selectFirst();

		rpnCalculateButton.setOnAction(calculateRPN -> {
			//variables to store input values of severity index, frequency and detection possibility
			String severityIndexString = effectList.getValue();
			String frequencyString = frequencyList.getValue();
			String possibilityString = possibilityList.getValue();
			//variables to store the actual values of severity index, frequency and detection possibility
			int severityIndex = 0, possibility = 0, frequency = 0;
			
			//handle different cases of severity index
			if (!severityIndexString.startsWith("Select")) {
				//if  10 is selected
				if (severityIndexString.contains("Hazardous")) {
					severityIndex = 10;
				} else if (severityIndexString.contains("Effect")) { //if 1 is selected
					severityIndex = 1;
				} else { // for all other valid selections
					severityIndex = Integer.parseInt(severityIndexString);
				}
			} else { //if no value is selected
				severityIndex = 0;
			}
			
			//handle different cases of detection possibilities
			if (!possibilityString.startsWith("Select")) {
				//if 10 is selected
				if (possibilityString.contains("Absolute")) {
					possibility = 10;
				} else if (possibilityString.contains("Certain")) { //if 1 is selected
					possibility = 1;
				} else { //for all other valid selections
					possibility = Integer.parseInt(possibilityString);
				}
			} else { //for no selections made
				possibility = 0;
			}
			
			//handle cases of frequency
			//if a valid selection is done
			if (!frequencyString.startsWith("Select")) {
				frequency = Integer.parseInt(frequencyString.split(" ")[1]);
			} else {//for all invalid selections
				frequency = 0;
			}
			
			//calculate risk priority number
			int riskPriorityNumber = severityIndex * frequency * possibility;
			//display risk priority number to the user on the screen
			rpnDisplayLabel.setText(String.valueOf(riskPriorityNumber));
		});
	}
}
