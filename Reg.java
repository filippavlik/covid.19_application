package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.ObjectInputFilter;

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

    //fn exites the application
    public void exit(javafx.scene.input.MouseEvent mouseEvent){
        alertpane.setHeaderText("Exit without saving?");
        alertpane.setTitle("Exit");
        alertpane.setX(Main.suradnicax + 40);
        alertpane.setY(Main.suradnicay + 50);
        alertpane.setHeight(200);
        /*passwordfield_password.setEditable(false);
        textfield_email.setEditable(false);
        textfield_pass.setEditable(false);*/
        alertpane.showAndWait();
        if (alertpane.getResult() == ButtonType.YES) {
            System.exit(0);
        } else {
            /*passwordfield_password.setEditable(true);
            textfield_email.setEditable(true);
            textfield_pass.setEditable(true);*/
    }
}
    //fn minimalises the app
    public void minimalise(MouseEvent mouseEvent) {
        Stage stage1 = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }
    //fn maximalise the app
    public void maximalise(){
        Main.new_stage.setResizable(true);
        Main.new_stage.setMaximized(true);

    }


}
