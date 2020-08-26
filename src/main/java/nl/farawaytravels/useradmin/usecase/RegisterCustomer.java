package nl.farawaytravels.useradmin.usecase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import nl.farawaytravels.useradmin.DBUtility;
import nl.farawaytravels.useradmin.dto.CustomerInfo;

/**
 * Registers Customer
 *
 * @author DP
 */
public class RegisterCustomer {
  private static Logger logger = Logger.getLogger("RegisterCustomer");

  public boolean registerCustomer(CustomerInfo customerInfo) {
    Connection connection = null;
    Statement statement = null;
    boolean result = false;
    try {
      connection = DBUtility.getInstance().getRemoteConnection();
      statement = connection.createStatement();
      result = statement.execute("INSERT INTO Customer_Primary_Info \n"
          + "(email_id,fullname,phone_number,destination_country) \n"
          + "VALUES \n"
          + "(\""+customerInfo.emailId+"\",\""+customerInfo.fullName+"\",\""+customerInfo.phoneNumber+"\",\""+customerInfo.destinationCountry+"\");");
    } catch (SQLException e) {
      logger.throwing("RegisterCustomer", "registerCustomer", e);
    }
    return result;
  }


}
