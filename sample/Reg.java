package sample;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.EventHandler;
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
    public VBox v_box_rooms;
    public HBox living_room_hbox_left;
    public Label Living_text;
    public Label Room_text;
    public Pane kitchen_pane;
    public Label kitchen_text;
    public HBox kitchen_hbox_left;
    double suradnicax_living;
    double suradnicay_living;

    //living room
    double konecnasuradnicax;
    double konecnasuradnicay;
    double poslednahodnota=1536;
    //kitchen
    double konecnasuradnicax1;
    double konecnasuradnicay1;
    double poslednahodnota1=1536;


    //fn exites the application
    public void exit(javafx.scene.input.MouseEvent mouseEvent) {
        alertpane.setHeaderText("Exit without saving?");
        alertpane.setX(Main.new_stage.getX() + 40);
        alertpane.setY(Main.new_stage.getY() + 50);
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
        if (!Main.new_stage.isMaximized()) {
            Main.new_stage.setResizable(true);
            Main.new_stage.setMaximized(true);
            v_box_rooms.setLayoutX(1300);
            v_box_rooms.setLayoutY(400);
            anchor_pame.setPrefSize(Main.new_stage.getWidth(), Main.new_stage.getHeight() - (scroll_pane.getHeight()) - 80);
            Main.new_stage.show();
        } else {
            anchor_pame.setPrefSize(900, 350);
            Main.new_stage.setMaximized(false);
            Main.new_stage.setWidth(900);
            Main.new_stage.setHeight(500);
        }
    }

    public void exit_esc(KeyEvent keyEvent) {
        if (keyEvent.getCode().getCode() == KeyCode.ESCAPE.getCode()) {
            alertpane.setHeaderText("Exit without saving?");
            alertpane.setTitle("Exit");
            alertpane.setX(Main.new_stage.getX() + 50);
            alertpane.setY(Main.new_stage.getY() + 50);
            alertpane.setHeight(200);
            alertpane.showAndWait();
            if (alertpane.getResult() == ButtonType.YES) {
                System.exit(0);
            }
        }
    }
    //fn drags living room

    public void settings(){
        living_room_pane.setOnMousePressed(mouseEvent -> {
                suradnicax_living=mouseEvent.getScreenX();
                suradnicay_living=mouseEvent.getScreenY();
                    });
        living_room_pane.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax=mouseEvent.getScreenX()-40;
            konecnasuradnicay=mouseEvent.getScreenY()-60;

            if (poslednahodnota>konecnasuradnicay){
                if (hbox_living.getChildren().contains(living_room_pane)){
                    //to anchorpame
                        hbox_living.getChildren().remove(living_room_pane);
                        anchor_pame.getChildren().add(living_room_pane);
                        living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay-200);
                        living_room_pane.setPrefSize(150,100);
                        living_room_hbox_left.setVisible(true);
                        Living_text.setVisible(false);
                        Room_text.setVisible(false);
                        living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay-200);}

                else if (!hbox_living.getChildren().contains(living_room_pane))
                        { living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay);}
            }

            else if (poslednahodnota<konecnasuradnicay) {
                if (konecnasuradnicay>Main.new_stage.getHeight()-scroll_pane.getHeight()-100 && 903>konecnasuradnicax)
                        {if (!hbox_living.getChildren().contains(living_room_pane))
                            {anchor_pame.getChildren().remove(living_room_pane);
                            hbox_living.getChildren().add(living_room_pane);
                            living_room_pane.setPrefSize(73,56);
                            living_room_hbox_left.setVisible(false);
                                Living_text.setVisible(true);
                                Room_text.setVisible(true);}}
                else {living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay);}
        } poslednahodnota=konecnasuradnicay+5;});

        kitchen_pane.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax1=mouseEvent.getScreenX()-40;
            konecnasuradnicay1=mouseEvent.getScreenY()-60;

            if (poslednahodnota1>konecnasuradnicay1){
                if (hbox_living.getChildren().contains(kitchen_pane)){
                    //to anchorpame
                    hbox_living.getChildren().remove(kitchen_pane);
                    anchor_pame.getChildren().add(kitchen_pane);
                    kitchen_pane.setPrefSize(150,100);
                    kitchen_hbox_left.setVisible(true);
                    kitchen_text.setVisible(false);
                    kitchen_text.setVisible(false);
                    kitchen_pane.relocate(konecnasuradnicax,konecnasuradnicay-200);}

                else if (!hbox_living.getChildren().contains(kitchen_pane))
                { kitchen_pane.relocate(konecnasuradnicax1,konecnasuradnicay1);}
            }

            else if (poslednahodnota1<konecnasuradnicay1) {
                if (konecnasuradnicay1>Main.new_stage.getHeight()-scroll_pane.getHeight()-100 && 903>konecnasuradnicax1)
                {if (!hbox_living.getChildren().contains(kitchen_pane))
                {   anchor_pame.getChildren().remove(kitchen_pane);
                    hbox_living.getChildren().add(kitchen_pane);
                    kitchen_hbox_left.setVisible(false);
                    kitchen_pane.setPrefSize(73,56);
                    kitchen_text.setVisible(true);
                    kitchen_text.setVisible(true);}}
                else {kitchen_pane.relocate(konecnasuradnicax1,konecnasuradnicay1);}
            } poslednahodnota1=konecnasuradnicay1+5;});
        kitchen_pane.setOnMousePressed(mouseEvent -> {
            suradnicax_living=mouseEvent.getScreenX();
            suradnicay_living=mouseEvent.getScreenY();
        });




    }
}




