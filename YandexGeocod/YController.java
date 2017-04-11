package YandexGeocod;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Created by 1234 on 3/28/2017.
 */
public class YController {

    @FXML
    // public Text actiontarget;

    public ProgressBar progressBar;

    public Text helo;


    public TextField userName_Field;
    static YMainProcessExec mThing;
YInput dataIn;





    public YController() {
    }


    @FXML

    public void setActiontarget1(MouseEvent mouseEvent) throws Exception {



        mThing = new YMainProcessExec();

        Thread myThready = new Thread(mThing);	//Создание потока "myThready"
        myThready.start();




    }




    public void inFormer (){



    }

    public void Cancel(ActionEvent actionEvent ) {
        System.out.println("Cancel button pressed");
        helo.setText("hello from button");
     //  myThready.interrupt();
    }



}