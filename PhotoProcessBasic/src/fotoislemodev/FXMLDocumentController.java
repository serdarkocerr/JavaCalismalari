/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotoislemodev;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

/**
 *
 * @author serdar
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnYukle;
    @FXML
    private Button btnDondur;
    @FXML
    private Button btnGri;
    @FXML
    private Button btnKapat;
    @FXML
    private ImageView imgView;
    @FXML
    private Label lblFileSelected;
    
    private String imageFile;
    @FXML
    private BorderPane borderPane;

    public Image image =null;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtnYukleAction(ActionEvent event) {
       try {
           lblFileSelected.setText("");
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Resim Dosyayi Sec.");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Resim Dosyasi", "*.png", "*.jpg")); 
            File selectedFile = fileChooser.showOpenDialog(lblFileSelected.getScene().getWindow());

            if (selectedFile != null) {
                    imageFile = selectedFile.toURI().toURL().toString();
                this.image = new Image(imageFile);
                imgView.setImage(image);
                imgView.setFitWidth(400);
                imgView.setFitHeight(300);
                imgView.setPreserveRatio(true);
                
                borderPane.setPrefSize(400, 300);
                borderPane.setCenter(imgView);
        
            } else {
                lblFileSelected.setText("Dosya secimi iptal edildi!!!");
            }
       }
       catch (MalformedURLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }  catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    @FXML
    private void handleBtnDondurAction(ActionEvent event) {
        try {
           lblFileSelected.setText("");

            if(imgView.getImage() == null){
                 lblFileSelected.setText("Resim yok !!" );
                 return;
            }
           String aci =  RotatePopup.display();
           if(aci == null || aci.equalsIgnoreCase("")  ){
            lblFileSelected.setText("aci degeri hatali! " );
            return;
           }
           else
             lblFileSelected.setText("aci degeri : " + aci );

           imgView.setRotate(imgView.getRotate() + Double.valueOf(aci));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
boolean isClicked = false;
double firstSaturationProp = 0;
    @FXML
    private void handleBtnGriAction(ActionEvent event) {
        lblFileSelected.setText("");

        if(image == null || imgView.getImage() == null){
            lblFileSelected.setText("Resim yok !!" );
             return;
        }
        
        if(!isClicked){
            ColorAdjust desaturate = new ColorAdjust();
            desaturate.setSaturation(-1);
            imgView.setEffect(desaturate);
             lblFileSelected.setText("Gri yapildi." );
             isClicked= true;
        }else{
             imgView.setEffect(null);
              lblFileSelected.setText("Resim orjinal rengine donduruldu" );
               isClicked= false;
        }


    }

    @FXML
    private void handleBtnKapatAction(ActionEvent event) {
        Platform.exit();
    }
    
}
