package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
    public  double xOffset = 0;public static double xOffset1=0;
    public  double yOffset = 0;public static double yOffset1=0;
    public static Scene scene;

    public static Scene scene1;
    public static double suradnicax; protected static double suradnicay;
    public static double suradnicax1; protected static double suradnicay1;
    public static Stage new_stage=new Stage();

    @Override
    //login a register form(bez menu,not resizable)
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Covid-19 Spread Simulator");
        primaryStage.setResizable(false);

        Image icona=new Image("resources/chat.png");
        primaryStage.getIcons().add(icona);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
            suradnicax=event.getScreenX() - xOffset;
            suradnicay=event.getScreenY() - yOffset;
        });
        root.setOnMouseDragged(event -> {
             suradnicax=event.getScreenX() - xOffset;
            suradnicay=event.getScreenY() - yOffset;
            primaryStage.setX(suradnicax);
            primaryStage.setY(suradnicay);
        });
        scene=new Scene(root);
        primaryStage.setScene(scene);
        Controller.dg.initOwner(primaryStage);
        primaryStage.show();
        suradnicax=primaryStage.getX();
        suradnicay=primaryStage.getY();

    }
    //(second frame after log form)
    public static void setNew_stage(Stage new_stage)throws Exception{
        Parent root_new = FXMLLoader.load(Reg.class.getResource("reg.fxml"));
        new_stage.setResizable(false);
        new_stage.setTitle("Covid-19 Spread Simulator");
        Image icona=new Image("resources/chat.png");
        new_stage.getIcons().add(icona);
        new_stage.initStyle(StageStyle.UNDECORATED);


        root_new.setOnMousePressed(event -> {
            xOffset1 = event.getSceneX();
            yOffset1 = event.getSceneY();
            suradnicax1=event.getScreenX() - xOffset1;
            suradnicay1=event.getScreenY() - yOffset1;
        });
        root_new.setOnMouseDragged(event -> {
            suradnicax1=event.getScreenX() - xOffset1;
            suradnicay1=event.getScreenY() - yOffset1;
            new_stage.setX(suradnicax1);
            new_stage.setY(suradnicay1);
        });
        AnchorPane anchor1=new AnchorPane();
        new_stage.setX(suradnicax);
        System.out.println(suradnicax);
        System.out.println(suradnicay);
        new_stage.setY(suradnicay);
        scene1=new Scene(root_new,696,388);
        new_stage.setScene(scene1);
        new_stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
