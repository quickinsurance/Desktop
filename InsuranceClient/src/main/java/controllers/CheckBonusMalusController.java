package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheckBonusMalusController implements Initializable {
	@FXML
	private Pane paneParent;

	@FXML
	private ImageView exitImageView;

	@FXML
	private JFXTextField bonusOuMalusTxt;

	@FXML
	private JFXTextField coefficientTxt;

	@FXML
	private JFXTextField BonusPercentageTxt;

	@FXML
	private JFXTextField MalusPercentageTxt;

	@FXML
	private JFXTextField stateTxt;
	
    @FXML
    private Label coefficientBonusLabel;
    
	public Stage Dialog;
    @FXML
    private JFXTextField PercentageBonusVisibleTxt;

	public void setParams(Stage Dialog){
		this.Dialog=Dialog;
	} 
	public void setResult(String s){
		this.coefficientTxt.setText(String.format("%.2f", Double.valueOf(s)));
		this.coefficientBonusLabel.setText(s);
		calculParameters();
		PercentageBonusVisibleTxt.setText(BonusPercentageTxt.getText());
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void calculParameters(){
		
		if(Double.valueOf(coefficientBonusLabel.getText())<0.75){
			bonusOuMalusTxt.setText("Bonus");
			double f = (1-Double.valueOf((coefficientBonusLabel.getText())))*100;
			BonusPercentageTxt.setText(String.format("%.2f", Double.valueOf(f))+" %");
			MalusPercentageTxt.setText("0 %");
			stateTxt.setText("Excellent Situation");
		}else if(Double.valueOf(coefficientBonusLabel.getText())<1 &&Double.valueOf(coefficientBonusLabel.getText())>=0.75){
			bonusOuMalusTxt.setText("Bonus");
			double f = (1-Double.valueOf((coefficientBonusLabel.getText())))*100;
			BonusPercentageTxt.setText(String.format("%.2f", Double.valueOf(f))+" %");
			MalusPercentageTxt.setText("0 %");
			stateTxt.setText("Good Situation");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())==1){
			bonusOuMalusTxt.setText("Ni Bonus ni Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("0 %");
			stateTxt.setText("Good Situation");
		}
		
		else if(Double.valueOf(coefficientBonusLabel.getText())>1 &&Double.valueOf(coefficientBonusLabel.getText())<=1.10){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 1 to 10 % on the old tarif");
			stateTxt.setText("Bad Situation");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>1.10 &&Double.valueOf(coefficientBonusLabel.getText())<=1.25){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 11 to 25 % on the old tarif");
			stateTxt.setText("Bad Situation");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>1.25 &&Double.valueOf(coefficientBonusLabel.getText())<=1.50){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 26 to 50 % on the old tarif");
			stateTxt.setText("Bad Situation");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>1.50 &&Double.valueOf(coefficientBonusLabel.getText())<=2){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 51 to 100 % on the old tarif");
			stateTxt.setText("Very risky customer");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>2 &&Double.valueOf(coefficientBonusLabel.getText())<=3){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 101 to 200 % on the old tarif");
			stateTxt.setText("Very risky customer");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>3 &&Double.valueOf(coefficientBonusLabel.getText())<=3.5){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("An increase from 201 to 250 % on the old tarif");
			stateTxt.setText("Very risky customer");
		}
		else if(Double.valueOf(coefficientBonusLabel.getText())>3.5){
			bonusOuMalusTxt.setText("Malus");
			BonusPercentageTxt.setText("0 %");
			MalusPercentageTxt.setText("A very strong increase above 250%");
			stateTxt.setText("Soryy! Can't be insured by our company");
		}	
	}
	
	@FXML
	void exitAction(MouseEvent event) {
		Dialog.close();
	}


}
