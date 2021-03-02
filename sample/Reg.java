package sample;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Reg {
    public Line exitline1;
    public Line exitline2;
    public Line minimalise_line;
    public Rectangle maximalise_line;
    public Button minimalise_button;
    public Button exit_button;
    public Button maximalise_button;
    public DialogPane dialog_exit;
    public static Alert alertpane = new Alert(Alert.AlertType.ERROR, "Do you really want to exit without saving?", ButtonType.YES, ButtonType.CANCEL);
    public AnchorPane anchor_new;
    public Pane living_room_pane;
    public HBox hbox_living;
    public Pane anchor_pame;
    public ScrollPane scroll_pane;
    double suradnicax_living;
     double suradnicay_living;

    double konecnasuradnicax;
    double konecnasuradnicay;



    //fn exites the application
    public void exit(javafx.scene.input.MouseEvent mouseEvent){
        alertpane.setHeaderText("Exit without saving?");
        alertpane.setX(Main.new_stage.getX()+40);
        alertpane.setY(Main.new_stage.getY()+50);
        alertpane.setTitle("Exit");
        alertpane.setHeight(200);
        alertpane.showAndWait();
        if (alertpane.getResult() == ButtonType.YES) {
            System.exit(0);

    }
}
    //fn minimalises the app
    public void minimalise(MouseEvent mouseEvent) {
        Stage stage1 = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }
    //fn maximalise the app
    public void maximalise() throws IOException {
        if (!Main.new_stage.isMaximized()){
            Main.new_stage.setResizable(true);
            Main.new_stage.setMaximized(true);
            anchor_pame.setPrefSize(Main.new_stage.getWidth(),Main.new_stage.getHeight()-(scroll_pane.getHeight())-80);
            Main.new_stage.show();
        }
        else {
            anchor_pame.setPrefSize(900,350);
            Main.new_stage.setMaximized(false);
            Main.new_stage.setWidth(900);
            Main.new_stage.setHeight(500);
                   }
    }

    //fn drags living room
    public  void settings(){
        living_room_pane.toFront();
        living_room_pane.requestFocus();
        living_room_pane.setOnMousePressed(event1 -> {
            suradnicax_living = event1.getSceneX();
             suradnicay_living = event1.getSceneY();
             konecnasuradnicax = event1.getScreenX() - suradnicax_living;
             konecnasuradnicay = event1.getScreenY() - suradnicay_living;
        });
        living_room_pane.setOnMouseDragged(event1 ->{
            konecnasuradnicax=event1.getScreenX()-suradnicax_living;
            konecnasuradnicay=event1.getScreenY()-suradnicay_living;
            if (hbox_living.getChildren().contains(living_room_pane))
            {
                System.out.println(hbox_living.getLayoutY());
                System.out.println(event1.getSceneY());
                hbox_living.getChildren().remove(living_room_pane);
                if (hbox_living.getLayoutY()<event1.getScreenY()){
            anchor_pame.getChildren().add(living_room_pane);
            living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay);}}
            else{
                anchor_pame.getChildren().remove(living_room_pane);
                hbox_living.getChildren().add(living_room_pane);
            }
        });
            }
    public void exit_esc(KeyEvent keyEvent) {
        if (keyEvent.getCode().getCode() == KeyCode.ESCAPE.getCode()) {
            alertpane.setHeaderText("Exit without saving?");
            alertpane.setTitle("Exit");
            alertpane.setX(Main.new_stage.getX()+50);
            alertpane.setY(Main.new_stage.getY() + 50);
            alertpane.setHeight(200);
            alertpane.showAndWait();
            if (alertpane.getResult() == ButtonType.YES) {
                System.exit(0);
            }
    }
}}





