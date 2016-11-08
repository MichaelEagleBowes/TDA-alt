package de.uni_bamberg.swl.tda.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
		
	/*
	 * 
	 * fx:ids:
	 * TabPane for Linecharts = "tabfield"
	 * AnchorPane for dependencies = "dependencies"
	 * TableView for class names = "ClassNameTable"
	 * TableColumn for names = "ClassNameColumn"
	 * tableColumn for failure percentage = "FailureColumn"
	 * 
	 * 
	 */
	
	private Tab loadTab(){
		Layout layoutObj = new Layout();
		return layoutObj.getClassTab();	
	}
	
	@FXML
	TabPane tabfield;
	
	@FXML
	private Tab classtab;
	//Function is executed when the Loadbutton is pressed.
	@FXML
	private void onLoadClick(){
		/*
		 * ToDO:
		 * sort tested classes
		 * create tableelements.
		 * change tableproperties.
		 * create classtabs.
		 * change classtab properties.
		 * 
		 */
			
		//TEST
		tabfield.getTabs().add(loadTab());
		
	}
	
}
