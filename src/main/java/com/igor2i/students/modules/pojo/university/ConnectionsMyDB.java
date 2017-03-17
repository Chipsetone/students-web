package com.igor2i.students.modules.pojo.university;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by igor2i on 16.02.17.
 */
final class ConnectionsMyDB {

    private static final Logger logger = LogManager.getLogger(ConnectionsMyDB.class);

    protected Connection connection;
    protected static ConnectionsMyDB db;



    private static String url;
    private static String login;
    private static String passwd;
    private static String driver;


    private ConnectionsMyDB(){

        try {
            config();
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, login, passwd);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    protected static synchronized ConnectionsMyDB getDbCon() {
        if ( db == null ) {
            db = new ConnectionsMyDB();
            logger.trace(db.connection);

            for (StackTraceElement el :
                    Thread.currentThread().getStackTrace()) {
                logger.trace(el);
            }

        }
        return db;

    }

    private static void config() throws IOException {


        /**
         * <entry key="jdbc.url">jdbc:mysql://localhost/university</entry>
             <entry key="jdbc.driver">com.mysql.jdbc.Driver</entry>
             <entry key="jdbc.username">user</entry>
             <entry key="jdbc.password">Qwer-1234</entry>
         */
//        Properties props = new Properties();
//        FileInputStream fis = new FileInputStream("JDBCConfig.xml");
//
//        props.loadFromXML(fis);

//        url = props.getProperty("jdbc.url");
//        driver = props.getProperty("jdbc.driver");
//        login = props.getProperty("jdbc.username");
//        passwd = props.getProperty("jdbc.password");
        url = "jdbc:postgresql://localhost:5432/students";
        driver = "org.postgresql.Driver";
        login = "postgres";
        passwd = "admin";

    }


}
