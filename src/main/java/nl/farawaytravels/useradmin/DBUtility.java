package nl.farawaytravels.useradmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class contains all database related functions / methods
 *
 * @author Debidutt Prasad (C39392)
 */
@Component
public class DBUtility {

  private static Logger logger = Logger.getLogger("getRemoteConnection");

  @Autowired
  private static DBUtility dbUtility;

//  @Value("${aws.rds.hostname}")
//  private String rdsDbHostname;
//
//  @Value("${aws.rds.dbname}")
//  private String rdsDbName;
//
//  @Value("${aws.rds.username}")
//  private String rdsUsername;
//
//  @Value("${aws.rds.password}")
//  private String rdsPassword;
//
//  @Value("${aws.rds.port}")
//  private String rdsPort;

  private String rdsDbHostname = "fat-customers-info.cjc6hmkwvudc.eu-west-3.rds.amazonaws.com";
  private String rdsDbName = "Customer_Info";
  private String rdsUsername = "admin";
  private String rdsPassword = "Lets2020";
  private String rdsPort = "3306";



  /**
   * Fetches a singleton instance of DBUtility
   * @return instance of DBUtility
   */
  public static DBUtility  getInstance() {
    if (dbUtility == null) {
      dbUtility = new DBUtility();
    }
    return dbUtility;
  }

   public Connection getRemoteConnection() {
//    if (rdsDbHostname != null) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String jdbcUrl =
//            "jdbc:mysql://" + rdsDbHostname + ":" + rdsPort + "/" + rdsDbName + "?user=" + rdsUsername
//                + "&password=" + rdsPassword;
        String jdbcUrl =
            "jdbc:mysql://fat-customers-info.cjc6hmkwvudc.eu-west-3.rds.amazonaws.com:3306/Customer_Info?user=admin&password=Lets2020";
        logger.info("Getting remote connection with connection string from environment variables.");
        Connection con = DriverManager.getConnection(jdbcUrl);
        logger.info("Remote connection successful.");
        return con;
      } catch (ClassNotFoundException e) {
        logger.warning(e.toString());
      } catch (SQLException e) {
        logger.warning(e.toString());
      }
//    }
    return null;
  }

}
