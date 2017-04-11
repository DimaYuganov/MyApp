package helloworld;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by 1234 on 3/31/2017.
 */
public class Control {


    @FXML
    private PieChart piechart;
    @FXML
    private Text Tem_C, wind;

    @FXML
    private ImageView weather_icon;


    public Control() throws Exception {


       //  chart.getData().add(new XYChart.Data(3, 35));
    }
    @FXML
    private void handleButton1Action(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("January", 100),
                        new PieChart.Data("January", 100),
                        new PieChart.Data("February", 200),
                        new PieChart.Data("March", 50),
                        new PieChart.Data("April", 75),
                        new PieChart.Data("May", 110),
                        new PieChart.Data("June", 300),
                        new PieChart.Data("July", 111),
                        new PieChart.Data("August", 30),
                        new PieChart.Data("September", 75),
                        new PieChart.Data("October", 55),
                        new PieChart.Data("November", 225),
                        new PieChart.Data("December", 99));

        piechart.setTitle("Monthly Record");
        piechart.setData(pieChartData);
    }

    @FXML
    private void handleButton2Action(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Sunday", 30),
                        new PieChart.Data("Monday", 45),
                        new PieChart.Data("Tuesday", 70),
                        new PieChart.Data("Wednesday", 97),
                        new PieChart.Data("Thursday", 100),
                        new PieChart.Data("Friday", 80),
                        new PieChart.Data("Saturday", 10));

        piechart.setTitle("Weekly Record");
        piechart.setData(pieChartData);
    }

    @FXML
    private void handleButtonClearAction(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        piechart.setTitle("");
        piechart.setData(pieChartData);
    }


    public void weather(ActionEvent actionEvent) throws IOException {

        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {

                WeatherFcst weather =new WeatherFcst();
                try {
                    Tem_C.setText(weather.getWeatherTem("Kiev"));
                    wind.setText(weather.getWeatherWind());



                    Image image = new Image("http:"+weather.getWeathericon());


                    weather_icon.setImage(image);

                System.out.println(weather.getWeathericon());

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        myThready.start();	//Запуск потока



    }
}
