package oose2;

import java.sql.Connection;
import java.sql.DriverManager;
public class MariaDBConnector {

    private MariaDBConnector(){}
    private static class Singleton{
        private static final MariaDBConnector instance = new MariaDBConnector();
    }

    public static MariaDBConnector getInstance(){
        return Singleton.instance;
    }

    private Connection connection = null;

    private String url ="jdbc:mariadb://localhost:3306/oose?user=root&password=635155";

    public Connection sqlLogin(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(url);
            System.out.println("데이터베이스 연결");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패");
        }
        return connection;
    }

}
