package sample;
import java.sql.*;
public class Jdriver {
    static String emailsedi;
    static Connection myconn; static Connection myconn_for_pass;static Connection myconn_for_ulozenie;
    static Statement stm;   static Statement stm_for_pass;static Statement stm_for_ulozenie;
    static ResultSet rst;   static ResultSet rst_for_pass;

    static {
        try {
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","7262099504Qq");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static {
        try {
            myconn_for_pass = DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","7262099504Qq");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static {
        try {
            myconn_for_ulozenie= DriverManager.getConnection("jdbc:mysql://localhost:3306/klienty","root","7262099504Qq");
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
            stm_for_ulozenie=myconn_for_ulozenie.createStatement();
            String sql=("INSERT INTO new_table(name,date,gender,email,password) VALUES ('\"+Text1+\"','\"+Text2+\"+\"','\"+Text3+\"','\"+Text4++\"','\"+Text4++");
            stm_for_ulozenie.execute(sql);
            System.out.println("zacina");
            System.out.println("Vlozenie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }}
