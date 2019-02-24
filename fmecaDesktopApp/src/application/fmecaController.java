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
	Button rpnButtonList;

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
		effectList.getItems().add("Select Criticality");
//		for (int i=0; i<)
		// select the first item to display in the drop down by default
		effectList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		frequencyList.getItems().add("Select Occurence Frequency");
		// select the first item to display in the drop down by default
		frequencyList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		iterationsList.getItems().add("Select Number of Iterations");
		// select the first item to display in the drop down by default
		iterationsList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		causeList.getItems().add("Select Probable Cause");
		// select the first item to display in the drop down by default
		causeList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		detectionList.getItems().add("Select Detection Type");
		// select the first item to display in the drop down by default
		detectionList.getSelectionModel().selectFirst();

		// add values to the drop down lists
		possibilityList.getItems().add("Select Detection Possibility");
		// select the first item to display in the drop down by default
		possibilityList.getSelectionModel().selectFirst();
	}
}
