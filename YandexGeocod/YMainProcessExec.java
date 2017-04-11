package YandexGeocod;

import java.io.IOException;

/**
 * Created by 1234 on 3/31/2017.
 */
public class YMainProcessExec implements Runnable {


    @Override
    public void run() {

        YInput yInput = null;
        try {
            yInput = new YInput();
            yInput.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
