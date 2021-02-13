package sample;
import java.sql.*;
import java.util.Calendar;

public class Jdriver {
    static String emailsedi;
    static Connection myconn; static Connection myconn_for_pass;static Connection myconn_for_ulozenie;
    static Statement stm;   static Statement stm_for_pass;static Statement stm_for_ulozenie;
    static ResultSet rst;   static ResultSet rst_for_pass;

    static {
        try {
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static {
        try {
            myconn_for_pass = DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static {
        try {
            myconn_for_ulozenie= DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","");
        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean obsahuje_email()  {
        try{
        stm=myconn.createStatement();
        rst=stm.executeQuery("select * from new_table");

        while (rst.next()) {
            emailsedi=rst.getString("email");
            if (emailsedi.equals(Controller.emailpremenna)||emailsedi.equals(Controller.emailregister))
            {return true;}
        }
        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());
        }

        return false;
    }
    public static boolean sedi_email_s_heslom(){
        try{
            stm_for_pass=myconn_for_pass.createStatement();
            rst_for_pass=stm_for_pass.executeQuery("select * from new_table");
            obsahuje_email();

            while (rst_for_pass.next()){
                if (rst_for_pass.getString("email").equals(Controller.emailpremenna)&&rst_for_pass.getString("password").equals(Controller.getPasswordpremenna()))
                    return true;
            }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return false;}
    public static void vlozenie_novych_udajov(){
        try{
            // create a mysql database connection
            Class.forName("com.mysql.jdbc.Driver");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into new_table ()"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = myconn_for_ulozenie.prepareStatement(query);
            preparedStmt.setInt (1, Controller.randomID());
            preparedStmt.setString (2, Controller.nick_register);
            preparedStmt.setDate   (3, Date.valueOf(Controller.localDate));
            preparedStmt.setString(4, Controller.gender);
            preparedStmt.setString    (5, Controller.emailregister);
            preparedStmt.setString    (6, Controller.password);


            // execute the preparedstatement
            preparedStmt.execute();

            myconn_for_ulozenie.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }}
