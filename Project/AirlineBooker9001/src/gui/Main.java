package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
public static Stage mainstage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainstage=primaryStage;
        try{
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            primaryStage.setTitle("Airline Booker 9001®");
            primaryStage.setScene(new Scene(root, 840, 680));
            primaryStage.show();
        }
        catch (Exception e) {
                System.out.print(e.getCause());
                System.out.print(e.toString());
                System.err.println(e);
                e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
