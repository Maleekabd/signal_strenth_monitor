package com.signal_monitor.javafx_signal_strength_monitor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    private static XYChart.Series<Number, Number> series;
    private static int time = 0;
    private static Random random = new Random();
    private static final int MAX_DATA_POINTS = 20;

    @Override
    public void start(Stage stage) throws IOException {

//        create axis
        NumberAxis xAxis = new NumberAxis(0, MAX_DATA_POINTS, 1);
        xAxis.setLabel("Time (s)");

        NumberAxis yAxis = new NumberAxis(-100, 0, 10);
        yAxis.setLabel("Amplitude");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        series = new XYChart.Series<>();

//    series.getData().add(new XYChart.Data<>(1));

        lineChart.getData().add(series);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateChart()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(lineChart, 400, 400);
        stage.setTitle("Signal Strength");
        stage.setScene(scene);
        stage.show();
    }

    private static void updateChart() {
        int signalStrenth = -100 + random.nextInt(101);
        time++;

        series.getData().add(new XYChart.Data<>(time, signalStrenth));

        if (series.getData().size() > MAX_DATA_POINTS) {
            series.getData().remove(0);
        }

        NumberAxis xAxis = (NumberAxis) series.getChart().getXAxis();
        xAxis.setLowerBound(time - MAX_DATA_POINTS);
        xAxis.setUpperBound(time);

        System.out.println("time : " + time + ", signal strength : " + signalStrenth + ", size : " + series.getData().size());
    }

    public static void main(String[] args) {
        launch(args);
    }
}