package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
    public Pane bathroom_pane;
    public Label bathroom_text1;
    public Label bedroom_text1;
    public Pane bedroom_pane;
    public HBox label_living;
    public HBox bedroom_hbox_left;
    public HBox bathroom_hbox_left;
    public Slider slider_size;
    public Pane restroom_pane1;
    public Label restroom_text;
    public HBox restroom_hbox_left;
    public HBox hbox_width_height;
    public Label living_width_height_labels;
    public Label kitchen_width_height_labels;
    public Label restroom_width_height_labels1;
    public Label bedroom_width_height_labels11;
    public Label bathroom_width_height_labels111;
    public Label garage_width_height_labels1111;
    public HBox bathroom_hbox_left1;
    public Pane garage_pane11;
    public Label garage_text1;
    public HBox garage_hbox_left;
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
    //bedroom
    double konecnasuradnicax2;
    double konecnasuradnicay2;
    double poslednahodnota2=1536;
    //bathroom
    double konecnasuradnicax3;
    double konecnasuradnicay3;
    double poslednahodnota3=1536;
    //restroom
    double konecnasuradnicax4;
    double konecnasuradnicay4;
    double poslednahodnota4=1536;
    //garage
    double konecnasuradnicax5;
    double konecnasuradnicay5;
    double poslednahodnota5=1536;

    int pocet_viditelnych;



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
            hbox_width_height.setLayoutX(1450);
            living_room_hbox_left.setPrefWidth(330);
            v_box_rooms.setPrefWidth(330);
            hbox_width_height.setLayoutY(370);
            show_numbers_under_WandH();
            slider_size.setLayoutX(1500);
            slider_size.setLayoutY(50);
            slider_size.setPrefHeight(200);
            anchor_pame.setPrefSize(Main.new_stage.getWidth(), Main.new_stage.getHeight() - (scroll_pane.getHeight()) - 80);
            Main.new_stage.show();
        } else {
            anchor_pame.setPrefSize(900, 350);
            slider_size.setLayoutX(871);
            slider_size.setLayoutY(1);
            Main.new_stage.setMaximized(false);
            Main.new_stage.setWidth(900);
            Main.new_stage.setHeight(500);
        }
    }

    public void show_numbers_under_WandH(){
        living_width_height_labels.setPrefWidth(90);
        living_width_height_labels.setPadding(new Insets(0,0,0,10));
        kitchen_width_height_labels.setPrefWidth(90);
        kitchen_width_height_labels.setPadding(new Insets(0,0,0,10));
        restroom_width_height_labels1.setPrefWidth(90);
        restroom_width_height_labels1.setPadding(new Insets(0,0,0,10));
        bedroom_width_height_labels11.setPrefWidth(90);
        bedroom_width_height_labels11.setPadding(new Insets(0,0,0,10));
        bathroom_width_height_labels111.setPrefWidth(90);
        bathroom_width_height_labels111.setPadding(new Insets(0,0,0,10));
        garage_width_height_labels1111.setPrefWidth(90);
        garage_width_height_labels1111.setPadding(new Insets(0,0,0,10));







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
                        hbox_width_height.setVisible(true);
                        living_room_hbox_left.setVisible(true);
                        Living_text.setVisible(false);
                        Room_text.setVisible(false);
                        living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay-200);}

                else if (!hbox_living.getChildren().contains(living_room_pane))
                        if (konecnasuradnicax<1100)
                        { living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay);}
            }

            else if (poslednahodnota<konecnasuradnicay) {
                if (konecnasuradnicay>Main.new_stage.getHeight()-scroll_pane.getHeight()-100)
                        {if (!hbox_living.getChildren().contains(living_room_pane))
                            {
                                anchor_pame.getChildren().remove(living_room_pane);
                            hbox_living.getChildren().add(living_room_pane);
                            living_room_pane.setPrefSize(73,56);
                            living_room_pane.setScaleX(1);
                            living_room_pane.setScaleY(1);
                            if (anchor_pame.getChildren().size()==0){
                                hbox_width_height.setVisible(false);}
                            living_room_hbox_left.setVisible(false);
                                Living_text.setVisible(true);
                                Room_text.setVisible(true);}}
                else {if (suradnicax_living<1100){
                    living_room_pane.relocate(konecnasuradnicax,konecnasuradnicay);}}
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
                    hbox_width_height.setVisible(true);
                    kitchen_text.setVisible(false);
                    kitchen_text.setVisible(false);
                    kitchen_pane.relocate(konecnasuradnicax,konecnasuradnicay1-200);}

                else if (!hbox_living.getChildren().contains(kitchen_pane))
                {if (konecnasuradnicax1<1100) kitchen_pane.relocate(konecnasuradnicax1,konecnasuradnicay1);}
            }

            else if (poslednahodnota1<konecnasuradnicay1) {
                if (konecnasuradnicay1>Main.new_stage.getHeight()-scroll_pane.getHeight()-100 )
                {if (!hbox_living.getChildren().contains(kitchen_pane))
                {   anchor_pame.getChildren().remove(kitchen_pane);
                    hbox_living.getChildren().add(kitchen_pane);
                    kitchen_hbox_left.setVisible(false);
                    kitchen_pane.setPrefSize(73,56);
                    if (anchor_pame.getChildren().size()==0){
                        hbox_width_height.setVisible(false);}
                    kitchen_pane.setScaleX(1);
                    kitchen_pane.setScaleY(1);
                    kitchen_text.setVisible(true);
                    kitchen_text.setVisible(true);}}
                else {
                    if (konecnasuradnicax1<1100)kitchen_pane.relocate(konecnasuradnicax1,konecnasuradnicay1);}
            } poslednahodnota1=konecnasuradnicay1+5;});
        kitchen_pane.setOnMousePressed(mouseEvent -> {
            suradnicax_living=mouseEvent.getScreenX();
            suradnicay_living=mouseEvent.getScreenY();
        });

        bedroom_pane.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax2=mouseEvent.getScreenX()-40;
            konecnasuradnicay2=mouseEvent.getScreenY()-60;

            if (poslednahodnota2>konecnasuradnicay2){
                if (hbox_living.getChildren().contains(bedroom_pane)){
                    //to anchorpame
                    hbox_living.getChildren().remove(bedroom_pane);
                    anchor_pame.getChildren().add(bedroom_pane);
                    bedroom_pane.relocate(konecnasuradnicax2,konecnasuradnicay2-200);
                    bedroom_pane.setPrefSize(150,100);
                    hbox_width_height.setVisible(true);
                    bedroom_hbox_left.setVisible(true);
                    bedroom_text1.setVisible(false);
                    bedroom_pane.relocate(konecnasuradnicax2,konecnasuradnicay2-200);}

                else if (!hbox_living.getChildren().contains(bedroom_pane))
                {if (konecnasuradnicax2<1100) bedroom_pane.relocate(konecnasuradnicax2,konecnasuradnicay2);}
            }

            else if (poslednahodnota2<konecnasuradnicay2) {
                if (konecnasuradnicay2>Main.new_stage.getHeight()-scroll_pane.getHeight()-100 )
                {if (!hbox_living.getChildren().contains(bedroom_pane))
                {anchor_pame.getChildren().remove(bedroom_pane);
                    hbox_living.getChildren().add(bedroom_pane);
                    bedroom_pane.setPrefSize(73,56);
                    bedroom_pane.setScaleY(1);
                    if (anchor_pame.getChildren().size()==0){
                        hbox_width_height.setVisible(false);}
                    bedroom_pane.setScaleX(1);
                    bedroom_hbox_left.setVisible(false);
                    bedroom_text1.setVisible(true);}}
                else {if (konecnasuradnicax2<1100)bedroom_pane.relocate(konecnasuradnicax2,konecnasuradnicay2);}
            } poslednahodnota2=konecnasuradnicay2+5;});

        bathroom_pane.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax3=mouseEvent.getScreenX()-40;
            konecnasuradnicay3=mouseEvent.getScreenY()-60;

            if (poslednahodnota3>konecnasuradnicay3){
                if (hbox_living.getChildren().contains(bathroom_pane)){
                    //to anchorpame
                    hbox_living.getChildren().remove(bathroom_pane);
                    anchor_pame.getChildren().add(bathroom_pane);
                    bathroom_pane.relocate(konecnasuradnicax3,konecnasuradnicay3-200);
                    bathroom_pane.setPrefSize(150,100);
                    bathroom_hbox_left.setVisible(true);
                    hbox_width_height.setVisible(true);
                    bathroom_text1.setVisible(false);
                    bathroom_pane.relocate(konecnasuradnicax3,konecnasuradnicay3-200);}

                else if (!hbox_living.getChildren().contains(bathroom_pane))
                { if (konecnasuradnicax3<1100)bathroom_pane.relocate(konecnasuradnicax3,konecnasuradnicay3);}
            }

            else if (poslednahodnota3<konecnasuradnicay3) {
                if (konecnasuradnicay3>Main.new_stage.getHeight()-scroll_pane.getHeight()-100)
                {if (!hbox_living.getChildren().contains(bathroom_pane))
                {anchor_pame.getChildren().remove(bathroom_pane);
                    hbox_living.getChildren().add(bathroom_pane);
                    bathroom_pane.setPrefSize(85,56);
                    bathroom_pane.setScaleX(1);
                    if (anchor_pame.getChildren().size()==0){
                        hbox_width_height.setVisible(false);}
                    bathroom_pane.setScaleY(1);
                    bathroom_hbox_left.setVisible(false);
                    bathroom_text1.setVisible(true);
                }}
                else {if (konecnasuradnicax3<1100)bathroom_pane.relocate(konecnasuradnicax3,konecnasuradnicay3);}
            } poslednahodnota3=konecnasuradnicay3+5;});

        restroom_pane1.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax4=mouseEvent.getScreenX()-40;
            konecnasuradnicay4=mouseEvent.getScreenY()-60;

            if (poslednahodnota4>konecnasuradnicay4){
                if (hbox_living.getChildren().contains(restroom_pane1)){
                    //to anchorpame
                    restroom_hbox_left.getChildren().remove(restroom_pane1);
                    anchor_pame.getChildren().add(restroom_pane1);
                    restroom_pane1.setPrefSize(150,100);
                    bathroom_pane.relocate(konecnasuradnicax4,konecnasuradnicay4-200);
                    restroom_hbox_left.setVisible(true);
                    restroom_text.setVisible(false);
                    hbox_width_height.setVisible(true);
                    restroom_text.setVisible(false);
                    restroom_pane1.relocate(konecnasuradnicax4,konecnasuradnicay4-200);}

                else if (!restroom_hbox_left.getChildren().contains(restroom_pane1))
                { restroom_pane1.relocate(konecnasuradnicax4,konecnasuradnicay4);}
            }

            else if (poslednahodnota4<konecnasuradnicay4) {
                if (konecnasuradnicay4>Main.new_stage.getHeight()-scroll_pane.getHeight()-100 && 903>konecnasuradnicax4)
                {if (!hbox_living.getChildren().contains(restroom_pane1))
                {   anchor_pame.getChildren().remove(restroom_pane1);
                    hbox_living.getChildren().add(restroom_pane1);
                    restroom_hbox_left.setVisible(false);
                    restroom_pane1.setScaleX(1);
                    if (anchor_pame.getChildren().size()==0){
                        hbox_width_height.setVisible(false);}
                    restroom_pane1.setScaleY(1);
                    restroom_pane1.setPrefSize(83,56);
                    restroom_text.setVisible(true);
                    }}
                else {if (konecnasuradnicax4<1100)restroom_pane1.relocate(konecnasuradnicax4,konecnasuradnicay4);}
            } poslednahodnota4=konecnasuradnicay4+5;});

        garage_pane11.setOnMouseDragged(mouseEvent -> {
            konecnasuradnicax5=mouseEvent.getScreenX()-40;
            konecnasuradnicay5=mouseEvent.getScreenY()-60;

            if (poslednahodnota5>konecnasuradnicay5){
                if (hbox_living.getChildren().contains(garage_pane11)){
                    //to anchorpame
                    hbox_living.getChildren().remove(garage_pane11);
                    anchor_pame.getChildren().add(garage_pane11);
                    garage_pane11.relocate(konecnasuradnicax5,konecnasuradnicay5-200);
                    garage_pane11.setPrefSize(150,100);
                    hbox_width_height.setVisible(true);
                    garage_hbox_left.setVisible(true);
                    garage_text1.setVisible(false);
                    garage_pane11.relocate(konecnasuradnicax5,konecnasuradnicay5-200);}

                else if (!hbox_living.getChildren().contains(garage_pane11))
                    if (konecnasuradnicax5<1100)
                    { garage_pane11.relocate(konecnasuradnicax5,konecnasuradnicay5);}
            }

            else if (poslednahodnota5<konecnasuradnicay5) {
                if (konecnasuradnicay5>Main.new_stage.getHeight()-scroll_pane.getHeight()-100)
                {if (!hbox_living.getChildren().contains(garage_pane11))
                {
                    anchor_pame.getChildren().remove(garage_pane11);
                    hbox_living.getChildren().add(garage_pane11);
                    garage_pane11.setPrefSize(73,56);
                    garage_pane11.setScaleX(1);
                    garage_pane11.setScaleY(1);
                    if (anchor_pame.getChildren().size()==0){
                        hbox_width_height.setVisible(false);}
                    garage_hbox_left.setVisible(false);
                    garage_text1.setVisible(true);
                    }}
                else {if (konecnasuradnicay5<1100){
                    garage_pane11.relocate(konecnasuradnicax5,konecnasuradnicay5);}}
            } poslednahodnota5=konecnasuradnicay5+5;});

        slider_size.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldvalue, Number newvalue) {
                for (int i = 0; i < anchor_pame.getChildren().size(); i++) {
                    if (newvalue.doubleValue()/20>.5){
                    anchor_pame.getChildren().get(i).setScaleX(newvalue.doubleValue()/45);
                    anchor_pame.getChildren().get(i).setScaleY(newvalue.doubleValue()/45);
                        for (int a = 0; a < v_box_rooms.getChildren().size(); a++) {
                            if (v_box_rooms.getChildren().get(i).isVisible()) {
                                pocet_viditelnych = pocet_viditelnych + 1;
                            }
                        }
                        for (int j = 1; j < pocet_viditelnych+1; j++) {
                            HBox hbox_selected = (HBox) v_box_rooms.getChildren().get(i);
                            try {Label label_selected;
                                if (j==1){ label_selected= (Label) hbox_selected.getChildren().get(j*2);}
                                else{
                                 label_selected= (Label) hbox_selected.getChildren().get(j*2+1);}
                                label_selected.setText(Math.round((newvalue.doubleValue() / 10) + 1) +"              "+
                                        Math.round((newvalue.doubleValue() / 10) + 1));
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        pocet_viditelnych=0;

                        }
                                    }}

            }
        });

       





    }
}




