/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotoislemodev;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author serdar
 */
public class RotatePopup {
    
public static String display()
{
    Stage popupwindow=new Stage();

    popupwindow.initModality(Modality.APPLICATION_MODAL);
    popupwindow.setTitle("Dondurme Miktari");
    Label lblCheck= new Label("Dondurme dercesini giriniz");
    //TextField retVlaAci = new TextField("Dondurme dercesini giriniz");
    
    
   TextField retVlaAci = new TextField() {
      @Override public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]*")) {
          super.replaceText(start, end, text);
        }
      }

      @Override public void replaceSelection(String text) {
        if (text.matches("[0-9]*")) {
          super.replaceSelection(text);
        }
      }
    };
       
    Button button1= new Button("Onay");
    button1.setOnAction(e ->{
        popupwindow.close();
    });

    VBox layout= new VBox(10);
    layout.getChildren().addAll(retVlaAci, lblCheck, button1);
    layout.setAlignment(Pos.CENTER);
    Scene scene1= new Scene(layout, 300, 250);
    popupwindow.setScene(scene1);
    popupwindow.showAndWait();
    return (retVlaAci.getText() != null) ? retVlaAci.getText():"";
}

    
}
