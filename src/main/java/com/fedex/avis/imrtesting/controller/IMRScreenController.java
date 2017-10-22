package com.fedex.avis.imrtesting.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class IMRScreenController {
	
	
	@FXML
	private RadioButton devDB=new RadioButton();
	
	@FXML
	private RadioButton qaDB=new RadioButton();
	
	@FXML
	private RadioButton uatDB=new RadioButton();
	
	@FXML
	private ComboBox<String> visaRouteNo=new ComboBox<>();
	
	@FXML
	private TextField awb=new TextField();
	
	@FXML
	private TextField shipperAcc=new TextField();
	
	@FXML
	private CheckBox oda=new CheckBox();
	
	@FXML
	private CheckBox metro=new CheckBox();
	
	@FXML
	private TextField ursa=new TextField();
	
	@FXML
	private DatePicker from=new DatePicker();
	
	@FXML
	private ComboBox<String> fromCondtion=new ComboBox<>();
	
	@FXML
	private DatePicker to=new DatePicker();
	
	@FXML
	private ComboBox<String> toCondtion=new ComboBox<>();
	
	@FXML
	private TextField cons=new TextField();
	
	@FXML
	private Button submit=new Button();
	
	@FXML
	private Button reset=new Button();
	
	@FXML
	private Label resultCount=new Label();
	
	@FXML
	private TextArea sql=new TextArea();
	
	@FXML
	private TextArea sqlParams=new TextArea();
	
	@FXML
	private Button clear=new Button();
	
	@FXML
	private TextArea resultReference=new TextArea();
	
	
	private ObservableList<String> visaRouteNoList ;
	private ObservableList<String> fromDateConditionList ;
	private ObservableList<String> toDateConditionList ;
	
	
	@FXML
	private void initialize() {
		
		visaRouteNo.setEditable(true);
		
	    visaRouteNoList = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five", "Six",
	                "Seven", "Eight", "Nine", "Ten");
		 
	    FilteredList<String> filteredVRItems = new FilteredList<String>(visaRouteNoList, p -> true);
	    
	    visaRouteNo.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = visaRouteNo.getEditor();
            final String selected = visaRouteNo.getSelectionModel().getSelectedItem();

            // This needs run on the GUI thread to avoid the error described
            // here: https://bugs.openjdk.java.net/browse/JDK-8081700.
            Platform.runLater(() -> {
                // If the no item in the list is selected or the selected item
                // isn't equal to the current input, we refilter the list.
                if (selected == null || !selected.equals(editor.getText())) {
                	filteredVRItems.setPredicate(item -> {
                        // We return true for any items that starts with the
                        // same letters as the input. We use toUpperCase to
                        // avoid case sensitivity.
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });
	    
	    visaRouteNo.setItems(filteredVRItems);
	    
	    
	    fromCondtion.setEditable(true);
	    fromDateConditionList = FXCollections.observableArrayList(">", ">=", "<", "<=", "=");
	    fromCondtion.setItems(fromDateConditionList);
	    
	    toCondtion.setEditable(true);
	    toDateConditionList = FXCollections.observableArrayList(">", ">=", "<", "<=", "=");
	    toCondtion.setItems(toDateConditionList);
	    
	}
	
	@FXML
	private void handleSubmit() {
		
		System.out.println("###"+devDB.isSelected());
		System.out.println("###"+qaDB.isSelected());
		System.out.println("###"+uatDB.isSelected());
		
		
		System.out.println("###"+visaRouteNo.getSelectionModel().getSelectedItem());
		System.out.println("###"+awb.getText());
		System.out.println("###"+shipperAcc.getText());
		System.out.println("###"+oda.isSelected());
		System.out.println("###"+metro.isSelected());
		System.out.println("###"+ursa.getText());
		
		System.out.println("###"+from.getValue());
		System.out.println("###"+fromCondtion.getSelectionModel().getSelectedItem());
		
		System.out.println("###"+to.getValue());
		System.out.println("###"+toCondtion.getSelectionModel().getSelectedItem());
		
		
		System.out.println("###"+cons.getText());
		
		resultCount.setText("333");
		
	}
	
	@FXML
	private void handleReset() {
		
	}
	
	@FXML
	private void handleClear() {
		
	}
	
	@FXML
	private void handleExportHistory() {
		
	}
	
	
	@FXML
	private void handleFlushHistory() {
		
	}
	
}