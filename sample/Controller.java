package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView correct_date_icon;
    @FXML
    public ImageView correct_icon_name;
    @FXML
    public ImageView wrong_icon_date;
    @FXML
    public ImageView wrong_icon_name;
    @FXML
    public ImageView corrrect_icon_email;
    @FXML
    public ImageView correct_icon_password;
    @FXML
    public ImageView wrong_icon_email;
    @FXML
    public ImageView wrong_icon_password;
    @FXML
    public  Text netwrk_problems_text;
    @FXML
    private TextField textfield_pass;
    @FXML
    private Text password_incorrect;
    @FXML
    private Text email_correct;
    @FXML
    private Text password_correct;
    @FXML
    private DatePicker date_of_birth;
    @FXML
    private TextField password_nick;
    @FXML
    private PasswordField password_register;
    @FXML
    private Button login_clicked;
    @FXML
    private QuadCurve brucho;
    @FXML
    private Circle hlava;
    @FXML
    private Button register_button;
    @FXML
    private Line register_carka;
    @FXML
    private Line login_carka;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Button spatbutton;
    @FXML
    private Button register_button_down;
    @FXML
    private TextField email_register;
    @FXML
    private RadioButton male_radio;
    @FXML
    private RadioButton female_radio;
    @FXML
    private TextField visregister;
    @FXML
    private TextField textfield_email;
    @FXML
    private PasswordField passwordfield_password;
    @FXML
    private CheckBox visible_check;
    @FXML
    private DialogPane dialoga;

    //Alert pri Exite

    public static Alert dg = new Alert(Alert.AlertType.ERROR, "Do you really want to exit without saving?", ButtonType.YES, ButtonType.CANCEL);

    //premenne použité pri JDriveri..overovanie dát
    static Random random=new Random();

    boolean obsemail_bool;public static String emailpremenna;private static String passwordpremenna;
    boolean sediasponheslo;public static String emailregister;
    static boolean jespravne_nick;static boolean jespravne_date;static boolean jespravne_pohlavie;static boolean jespravne_email;
    static boolean jespravne_password;static LocalDate localDate;
    static String nick_register;static String gender;static String email;static String password;static int key;

    public Controller() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //fn minimalise the main window
    public void minimales(MouseEvent mouseEvent) {
        Stage stage1 = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }

    //open dialog window for exit
    public void escclicked(KeyEvent keyEvent) {
        if (keyEvent.getCode().getCode() == KeyCode.ESCAPE.getCode()) {
            dialoga.setVisible(true);
            passwordfield_password.setEditable(false);
            textfield_email.setEditable(false);
            netwrk_problems_text.setVisible(false);
        }
        if (textfield_email.isVisible()){
        if (keyEvent.getCode().getCode() == KeyCode.ENTER.getCode()) {
            textfield_email.setCursor(Cursor.WAIT);
            textfield_pass.setCursor(Cursor.WAIT);
            Jdriver.otestuj_email();
            if (Jdriver.status){
                Jdriver.otestuj_email_heslo();
            if (passwordfield_password.isVisible()){
                passwordfield_password.getText();
                if (textfield_pass.isVisible()){
                    passwordpremenna=textfield_pass.getText();
                }
            }
            if (passwordfield_password.isVisible()){
                passwordpremenna=passwordfield_password.getText();}
            else if (textfield_pass.isVisible()){
                passwordpremenna=textfield_pass.getText();}
            if (textfield_email.getText().contains("@") && textfield_email.getText().contains("."))
                emailpremenna = textfield_email.getText();
            obsemail_bool = Jdriver.sedi_email_s_heslom();
            if (obsemail_bool) {
                textfield_email.setStyle("-fx-text-inner-color: green;");
                passwordfield_password.setStyle("-fx-text-inner-color: green;");
                textfield_pass.setStyle("-fx-text-inner-color: green;");
                password_correct.setVisible(true);
            }else {
                emailpremenna = textfield_email.getText();
                sediasponheslo=Jdriver.obsahuje_email();
                if (sediasponheslo){textfield_email.setStyle("-fx-text-inner-color: green;");password_incorrect.setVisible(true);   }
                else if (!obsemail_bool){email_correct.setVisible(true);}}}else {
                textfield_email.setCursor(Cursor.TEXT);
                textfield_pass.setCursor(Cursor.TEXT);
                netwrk_problems_text.setVisible(true);
                }}

        }


    }

    //fn checks email and pass in login, if it is true,it opens next window
    public void loginclicked(MouseEvent mouseEvent) throws Exception {
        netwrk_problems_text.setVisible(false);
        Jdriver.otestuj_email();
        if (Jdriver.status){
            Jdriver.otestuj_email_heslo();
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            if (passwordfield_password.isVisible()){
                passwordfield_password.getText();
            if (textfield_pass.isVisible()){
                passwordpremenna=textfield_pass.getText();
                 }
        }
        if (passwordfield_password.isVisible()){
        passwordpremenna=passwordfield_password.getText();}
        else if (textfield_pass.isVisible()){
            passwordpremenna=textfield_pass.getText();}
            if (textfield_email.getText().contains("@") && textfield_email.getText().contains("."))
                emailpremenna = textfield_email.getText().replace(" ","");
                obsemail_bool = Jdriver.sedi_email_s_heslom();
            if (obsemail_bool) {
                textfield_email.setStyle("-fx-text-inner-color: green;");
                corrrect_icon_email.setVisible(true);
                corrrect_icon_email.setVisible(true);
                passwordfield_password.setStyle("-fx-text-inner-color: green;");
                textfield_pass.setStyle("-fx-text-inner-color: green;");
                password_correct.setVisible(true);
                Stage zavri= (Stage) passwordfield_password.getScene().getWindow();
                zavri.close();
                Main.setNew_stage(Main.new_stage);
            }else {
                emailpremenna = textfield_email.getText();
                sediasponheslo=Jdriver.obsahuje_email();
             if (sediasponheslo){textfield_email.setStyle("-fx-text-inner-color: green;");password_incorrect.setVisible(true);
                 passwordfield_password.setStyle("-fx-text-inner-color: red;");
                 wrong_icon_password.setVisible(true);corrrect_icon_email.setVisible(true);
             textfield_pass.setStyle("-fx-text-inner-color: red;");}
            else if (!obsemail_bool){email_correct.setVisible(true);
                 passwordfield_password.setStyle("-fx-text-inner-color: red;");
                 wrong_icon_password.setVisible(true);
                 wrong_icon_email.setVisible(true);
                 textfield_email.setStyle("-fx-text-inner-color: red;");
            }}}}else netwrk_problems_text.setVisible(true);}

    //fn makes visible and hide password in login and registration
    public void visibclick(MouseEvent mouseEvent){
        if (passwordfield_password.isVisible()) {
            passwordfield_password.setVisible(false);
            textfield_pass.setText(passwordfield_password.getText());
            textfield_pass.setVisible(true);
        } else if (visregister.isVisible()) {
            password_register.setText(visregister.getText());
            password_register.setVisible(true);
            visregister.setVisible(false);}
        else if (password_register.isVisible()){
            visregister.setText(password_register.getText());
            visregister.setVisible(true);
            password_register.setVisible(false);
        } else if (textfield_pass.isVisible()){
            textfield_pass.setVisible(false);
            passwordfield_password.setText(textfield_pass.getText());
            passwordfield_password.setVisible(true);}
        }

    //fn exits app,setting dialog window
    public void eit1(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        dg.setHeaderText("Exit without saving?");
        dg.setTitle("Exit");
        dg.setX(Main.suradnicax + 40);
        dg.setY(Main.suradnicay + 50);
        dg.setHeight(200);
        passwordfield_password.setEditable(false);
        textfield_email.setEditable(false);
        textfield_pass.setEditable(false);
        dg.showAndWait();
        if (dg.getResult() == ButtonType.YES) {
            System.exit(0);
        } else {
            passwordfield_password.setEditable(true);
            textfield_email.setEditable(true);
            textfield_pass.setEditable(true);
        }

    }

    //change colour to black in email and password log
    public void _backtoblack_loginemail(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType()==MouseEvent.MOUSE_ENTERED)
            netwrk_problems_text.setVisible(false);
            textfield_email.setStyle("-fx-text-inner-color: black;");
        passwordfield_password.setStyle("-fx-text-inner-color: black;");
        textfield_pass.setStyle("-fx-text-inner-color: black;");
        password_correct.setVisible(false);
        email_correct.setVisible(false);
        password_incorrect.setVisible(false);
        wrong_icon_email.setVisible(false);wrong_icon_password.setVisible(false);
        correct_icon_password.setVisible(false);corrrect_icon_email.setVisible(false);



    }


    //change colour to black in registration
    public void _backtoblack_name(MouseEvent mouseDragEvent) {
        if (MouseEvent.MOUSE_ENTERED==mouseDragEvent.getEventType()){
            netwrk_problems_text.setVisible(false);
            password_nick.setStyle("-fx-text-inner-color: black;");
        wrong_icon_name.setVisible(false);correct_icon_name.setVisible(false);}
    }

    public static String getPasswordpremenna() {
        return passwordpremenna;
    }

    //change colour to black in registration
    public void _backtoblack_email(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        if (MouseEvent.MOUSE_ENTERED.equals(mouseEvent.getEventType()))
        {email_register.setStyle("-fx-text-fill:black");
        wrong_icon_email.setVisible(false);
        corrrect_icon_email.setVisible(false);}
    }

    public void _invisible_wrong_or_correct_icons(){
        correct_date_icon.setVisible(false);correct_icon_password.setVisible(false);corrrect_icon_email.setVisible(false);correct_icon_name.setVisible(false);
        wrong_icon_date.setVisible(false);wrong_icon_password.setVisible(false);wrong_icon_email.setVisible(false);wrong_icon_name.setVisible(false);
    }

    //change colour to black in password registration
    public void _backtoblack_password(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        visregister.setStyle("-fx-text-fill:black");
        password_register.setStyle("-fx-text-fill:black");
        correct_icon_password.setVisible(false);
        wrong_icon_password.setVisible(false);
    }

    //change colour to black in calendar
    public void backtoblack_calendar(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        date_of_birth.getStylesheets()
                .add(getClass()
                        .getResource("datapicker.css")
                        .toExternalForm());
        correct_date_icon.setVisible(false);
        wrong_icon_date.setVisible(false);

    }


    //change colour to black in.visibility componentov
    public void register_clicked(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        password_nick.setVisible(true);
        password_register.setVisible(true);
        date_of_birth.setVisible(true);
        line1.setVisible(true);
        line2.setVisible(true);
        line3.setVisible(true);
        line4.setVisible(true);
        male_radio.setVisible(true);
        female_radio.setVisible(true);
        email_register.setVisible(true);
        register_button_down.setVisible(true);
        register_button.setDisable(true);
        login_clicked.setDisable(true);

        passwordfield_password.setVisible(false);
        textfield_email.setVisible(false);
        textfield_pass.setVisible(false);
       login_clicked.setVisible(false);
        register_button.setVisible(false);
        register_carka.setVisible(false);
        login_carka.setVisible(false);
        spatbutton.setDisable(false);
        login_clicked.setDisable(false);
        email_correct.setVisible(false);
       email_correct.setVisible(false);
       password_incorrect.setVisible(false);
       textfield_pass.setVisible(false);
       passwordfield_password.setVisible(false);
       textfield_pass.setVisible(false);
       _invisible_wrong_or_correct_icons();


    }

    //from registration formulat back to login
    public void spatclikced(MouseEvent mouseEvent) {
        netwrk_problems_text.setVisible(false);
        password_nick.setVisible(false);password_register.setVisible(false);date_of_birth.setVisible(false);
        line1.setVisible(false);line2.setVisible(false);line3.setVisible(false);line4.setVisible(false);
        passwordfield_password.setVisible(true);textfield_email.setVisible(true);
        login_clicked.setDisable(false);login_clicked.setVisible(true);visible_check.setVisible(true);register_button.setDisable(false);
        hlava.setLayoutY(219);brucho.setLayoutY(231);register_button.setVisible(true);register_carka.setVisible(true);login_carka.setVisible(true);
        spatbutton.setDisable(true);register_button_down.setVisible(false);email_register.setVisible(false);
        male_radio.setVisible(false);female_radio.setVisible(false);visregister.setVisible(false);password_register.setVisible(false);
        _invisible_wrong_or_correct_icons();
    }

    public static int randomID(){

        return Controller.random.nextInt()*1152;

    }

    //the process of registration
    public void registration(MouseEvent mouseEvent) throws Exception {
        Jdriver.otestujcom();
         netwrk_problems_text.setVisible(false);
        if (Jdriver.status){
            if (password_nick.getText()==null || password_nick.getText().matches(".*\\d.*")){
            password_nick.setStyle("-fx-text-inner-color: green;");}
            else {password_nick.setStyle("-fx-text-inner-color: red;");wrong_icon_name.setVisible(true);}
        if (male_radio.isSelected() || female_radio.isSelected())
        {
            if (male_radio.isSelected() && female_radio.isSelected()){
                male_radio.setStyle("-fx-text-fill: red;"); female_radio.setStyle("-fx-text-fill: red;");
            }else
                {if(male_radio.isSelected()){
                    male_radio.setStyle("-fx-text-fill: green;");
                    female_radio.setStyle("-fx-text-fill: white");}
                    else
                        if (female_radio.isSelected()){
                            female_radio.setStyle("-fx-text-fill: green;");
                            male_radio.setStyle("-fx-text-fill:white");}
                        }}else {male_radio.setStyle("-fx-text-fill: red;");
                                female_radio.setStyle("-fx-text-fill: red;");}
        emailregister=email_register.getText();
        emailregister=emailregister.replace(" ","");
        if (!emailregister.contains("@") || !emailregister.contains(".")) {
           email_register.setStyle("-fx-text-fill:red");
           wrong_icon_email.setVisible(true);
        }else if (Jdriver.obsahuje_email()){
            email_register.setStyle("-fx-text-fill:red");
            wrong_icon_email.setVisible(true);}
        else {email_register.setStyle("-fx-text-fill:green");
            corrrect_icon_email.setVisible(true);}
        if (visregister.isVisible() ){
        if (visregister.getLength()>=4){
            visregister.setStyle("-fx-text-fill:green");
            correct_icon_password.setVisible(true);
            jespravne_password=true;
            password=visregister.getText();}
        else {visregister.setStyle("-fx-text-fill:red"); }}
        if (password_register.isVisible()){
            if (password_register.getLength()>=4){
                password_register.setStyle("-fx-text-fill:green");jespravne_password=true;password=password_register.getText();}
            else {password_register.setStyle("-fx-text-fill:red");
                    wrong_icon_password.setVisible(true);}}
            localDate=date_of_birth.getValue();
        if (!password_nick.getText().matches(".*\\d.*")){jespravne_nick=true;nick_register=password_nick.getText();}
        if (date_of_birth.getValue()!=null){
        if (localDate.getYear()<=2020 && localDate.getYear()>=1950){jespravne_date=true;date_of_birth.getStylesheets()
                .add(getClass()
                        .getResource("datapicker_green.css")
                        .toExternalForm());
                correct_date_icon.setVisible(true);}
        else{date_of_birth.getStylesheets()
                .add(getClass()
                        .getResource("datapicker_wrong.css")
                        .toExternalForm());
                wrong_icon_date.setVisible(true);}}
        else{wrong_icon_date.setVisible(true);}
        if (female_radio.isSelected()){
            if (!male_radio.isSelected())
                jespravne_pohlavie=true;gender="woman";}
            else if (male_radio.isSelected()){if (!female_radio.isSelected())jespravne_pohlavie=true;gender="man";}
            if (!emailregister.contains("@") || !emailregister.contains(".") || !Jdriver.obsahuje_email())
                {jespravne_email=true;email=email_register.getText();}
        if (jespravne_nick&&jespravne_date&&jespravne_pohlavie&&jespravne_email&&jespravne_password){
            key=randomID();
            Jdriver.vlozenie_novych_udajov();
            Stage zavri= (Stage) passwordfield_password.getScene().getWindow();
            zavri.close();
            Main.setNew_stage(Main.new_stage);}}else netwrk_problems_text.setVisible(true);

    }}










