package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.interf.IClaimsServiceRemote;
import services.interf.IMessageServiceRemote;
import util.CompareClaims;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.control.ScrollBar;

import org.controlsfx.control.PopOver;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.script.Bindings;

import entities.Claim;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Effect;
import com.jfoenix.controls.JFXScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.KeyEvent;

public class ConsultClaimsController implements Initializable {
	@FXML
	private VBox content_area;

	@FXML
    private VBox ConsultVbox;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private JFXTextField filter;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
		Context context;
		try {
			context = new InitialContext();
			IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);

			ConsultVbox.getChildren().clear();
			GridPane grid = new GridPane();
			grid.alignmentProperty();
			grid.setHgap(50);
			grid.setPadding(new Insets(5, 5, 5, 5));
			ConsultVbox.getChildren().add(grid);
			scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
	    	List<Claim> claims =proxy.findClaimsByTraitement("non traite");
			int cols = 1, colCnt = 0, rowCnt = 0;
			List<Claim> l = claims;
			for (int i = 0; i < claims.size(); i++) {
				int k = i;
				if (claims.get(i) != null) {
					HBox gd = new HBox();
					grid.setMargin(gd, (new Insets(5, 5, 10, 5)));
					gd.setStyle( 
							"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
					Label l1 = new Label(claims.get(i).getDescription());
					l1.setPadding(new Insets(5, 5, 5, 5));
					l1.setMaxSize(500, 50);
					l1.setMinSize(500, 50);
					Label l2 = new Label(claims.get(i).getClaim_date().toString());
					gd.getChildren().add(l1);
					gd.getChildren().add(l2);
					grid.add(gd, colCnt, rowCnt);
					colCnt++;
					if (colCnt == cols) {
						colCnt = 0;
						rowCnt++;
					}
					gd.setOnMouseClicked((MouseEvent event1) -> {
						System.out.println(l.get(k).getClaim_id());
						Label label3 = new Label(l.get(k).getReference_police() + " ");
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/claim.fxml")); 
				        Scene scene;
				        GridPane grid1 = new GridPane();
						try {
							scene = new Scene(loader.load());
							 Stage stage = new Stage();
						        ((ClaimController)loader.getController()).setClaim(l.get(k));
						        ((ClaimController)loader.getController()).getLabelSubject().setText((l.get(k).getType_subject().toString()));
						        ((ClaimController)loader.getController()).getDateLabel().setText((l.get(k).getClaim_date().toString()));
						        ((ClaimController)loader.getController()).getLabelRef().setText(Integer.toString(l.get(k).getReference_police()));
						        ((ClaimController)loader.getController()).getScrollPane().setVbarPolicy(ScrollBarPolicy.ALWAYS);
								((ClaimController)loader.getController()).getScrollPane().setHbarPolicy(ScrollBarPolicy.NEVER);
								
						       
								grid1.alignmentProperty();
								//grid1.setHgap(50);
								//grid1.setPadding(new Insets(5, 5, 5, 5));
								((ClaimController)loader.getController()).getTextarea().getChildren().add(grid1);
						        stage.setScene(scene);
						        scene.getStylesheets().add(getClass().getResource("/styles/stylehseet.css").toExternalForm());
						        stage.show();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				       
							String values = l.get(k).getDescription();
							String[] array = values.split("\\s", -1);
							Label string=new Label();
					        Set<String> hash = new HashSet<String>();
							int cols1 = 4, colCnt1 = 0, rowCnt1 = 0;
							for (int m = 0; m < array.length; m++) {
								Label label = new Label(array[m] + " ");
								grid1.add(label, colCnt1, rowCnt1);
								colCnt1++;
								if (colCnt1 == cols1) {
									colCnt1 = 0;
									rowCnt1++;
								}
								label.setOnMouseEntered((MouseEvent event4) -> {
									label.setStyle(label.getStyle() + ";-fx-text-fill:red");
								});
								label.setOnMouseExited((MouseEvent event4) -> {
									label.setStyle(label.getStyle() + "; -fx-text-fill:grey");
								});
								label.setOnMouseClicked((MouseEvent event4) -> {
									try {string.setText("");
										hash.add(label.getText().trim());
										for (String e : hash) {
										string.setText(string.getText()+" "+e);
										}
										String[] array3 = string.getText().split("\\s", -1);
										label.setStyle("-fx-background-color:yellow");
								        ((ClaimController)loader.getController()).findMatch(array3,string.getText());
									} catch (NamingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								});
							}
				
					});

				}
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@FXML
    void filterclaims(KeyEvent event) throws NamingException {
/*		String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
		Context context= new InitialContext();
		IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);

		ConsultVbox.getChildren().clear();
		GridPane grid = new GridPane();
		grid.alignmentProperty();
		grid.setHgap(50);
		grid.setPadding(new Insets(5, 5, 5, 5));
		ConsultVbox.getChildren().add(grid);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        if (filter.getText().trim().equals(""))
        {
			claims = proxy.findClaimsByTraitement("non traite");

        }
        else {claims = proxy.findClaimsBySubject(filter.getText());}
				int cols = 1, colCnt = 0, rowCnt = 0;
		List<Claim> l = claims;
		for (int i = 0; i < claims.size(); i++) {
			int k = i;
			if (claims.get(i) != null) {
				HBox gd = new HBox();
				grid.setMargin(gd, (new Insets(5, 5, 10, 5)));
				gd.setStyle( 
						"-fx-background-color:#F1F5F8;-fx-border-color:#eaf2f7 ;-fx-border-radius: 30px 30px 30px 30px;-fx-background-radius: 30px 30px 30px 30px;-fx-effect: dropshadow(three-pass-box, #dad4d4, 1, 1, 1,1);");
				Label l1 = new Label(claims.get(i).getDescription());
				l1.setPadding(new Insets(5, 5, 5, 5));
				l1.setMaxSize(500, 50);
				l1.setMinSize(500, 50);
				Label l2 = new Label(claims.get(i).getClaim_date().toString());
				gd.getChildren().add(l1);
				gd.getChildren().add(l2);
				grid.add(gd, colCnt, rowCnt);
				colCnt++;
				if (colCnt == cols) {
					colCnt = 0;
					rowCnt++;
				}
				gd.setOnMouseClicked((MouseEvent event1) -> {
					Label label3 = new Label(l.get(k).getReference_police() + " ");
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/claim.fxml")); 
			        Scene scene;
			        GridPane grid1 = new GridPane();
					try {
						scene = new Scene(loader.load());
						 Stage stage = new Stage();
					        ((ClaimController)loader.getController()).setClaim(l.get(k));
					        ((ClaimController)loader.getController()).getLabelSubject().setText((l.get(k).getType_subject().toString()));
					        ((ClaimController)loader.getController()).getDateLabel().setText((l.get(k).getClaim_date().toString()));
					        ((ClaimController)loader.getController()).getLabelRef().setText(Integer.toString(l.get(k).getReference_police()));
					        ((ClaimController)loader.getController()).getScrollPane().setVbarPolicy(ScrollBarPolicy.ALWAYS);
							((ClaimController)loader.getController()).getScrollPane().setHbarPolicy(ScrollBarPolicy.NEVER);
							
					       
							grid1.alignmentProperty();
							//grid1.setHgap(50);
							//grid1.setPadding(new Insets(5, 5, 5, 5));
							((ClaimController)loader.getController()).getTextarea().getChildren().add(grid1);
					        stage.setScene(scene);
					        scene.getStylesheets().add(getClass().getResource("/styles/stylehseet.css").toExternalForm());
					        stage.show();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			       
						String values = l.get(k).getDescription();
						String[] array = values.split("\\s", -1);
						Label string=new Label();
				        Set<String> hash = new HashSet<String>();
						int cols1 = 4, colCnt1 = 0, rowCnt1 = 0;
						for (int m = 0; m < array.length; m++) {
							Label label = new Label(array[m] + " ");
							grid1.add(label, colCnt1, rowCnt1);
							colCnt1++;
							if (colCnt1 == cols1) {
								colCnt1 = 0;
								rowCnt1++;
							}
							label.setOnMouseEntered((MouseEvent event4) -> {
								label.setStyle(label.getStyle() + ";-fx-text-fill:red");
							});
							label.setOnMouseExited((MouseEvent event4) -> {
								label.setStyle(label.getStyle() + "; -fx-text-fill:grey");
							});
							label.setOnMouseClicked((MouseEvent event4) -> {
								try {string.setText("");
									hash.add(label.getText().trim());
									for (String e : hash) {
									string.setText(string.getText()+" "+e);
									}
									String[] array3 = string.getText().split("\\s", -1);
									label.setStyle("-fx-background-color:yellow");
							        ((ClaimController)loader.getController()).findMatch(array3,string.getText());
								} catch (NamingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							});
						}
			
				});

			}
		}*/

    }
	public void findMatch(Claim claim) throws NamingException {
		String jndiName = "Insurance-ear/Insurance-ejb/ServiceClaims!services.interf.IClaimsServiceRemote";
		Context context = new InitialContext();
		IClaimsServiceRemote proxy = (IClaimsServiceRemote) context.lookup(jndiName);
		Claim c = proxy.findClaimById(claim.getClaim_id());
		List<Claim> claims = proxy.FindMatch(claim.getType_subject().toString(), claim.getClaim_id());
		int match;
		TreeSet<CompareClaims> MatchOrdered= new TreeSet<>();
		for (int i = 0; i < claims.size(); i++) {
			CompareClaims cc=new CompareClaims();
			cc.setC(claims.get(i));
		cc.CodeComparisonScoresHelper(c.getDescription(),claims.get(i).getDescription());
		MatchOrdered.add(cc);}
		for (CompareClaims e : MatchOrdered) {
            System.out.println("**"+e.getC().getClaim_id()+e.getC().getDescription());
        }		//String[] array = c.getDescription().split("\\ ", -1);
//		for (int i = 0; i < claims.size(); i++) {
//			int x = 0;
//			HBox gd = new HBox();
//			VboxMatch.getChildren().add(gd);
//			String[] array1 = new String[1000];		
//			array1 = claims.get(i).getDescription().split("\\ ", -1);
//
//			for (int l = 0; l < array1.length; l++) {
//				Label lab = new Label(array1[l] + " ");
//				gd.getChildren().add(lab);
//			}
//			for (int j = 0; j < array1.length; j++) {
//			for (int k = 0; k < array.length; k++) {
//
//					if (array[k].equals(array1[j])) {
//						x++;
//					}
//				}
//			}
//			System.out.println(x);
//		}
	}
}
