package nl.farawaytravels.useradmin.usecase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import nl.farawaytravels.useradmin.DBUtility;
import nl.farawaytravels.useradmin.dto.AuthUser;
import nl.farawaytravels.useradmin.dto.CustomerInfo;

/**
 * Fetches all customers with primary information
 *
 * @author DP
 */
public class FetchAllCustomersPrimaryInfo {

  private static Logger logger = Logger.getLogger("FetchAllCustomersPrimaryInfo");

  public List<CustomerInfo> fetchCustomerInfo() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<CustomerInfo> customerInfoList = null;
    try {
      connection = DBUtility.getInstance().getRemoteConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM Customer_Primary_Info");
      customerInfoList = new ArrayList<CustomerInfo>();

      while (resultSet.next()) {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setEmailId(resultSet.getString("email_id"));
            customerInfo.setFullName(resultSet.getString("fullname"));
            customerInfo.setPhoneNumber(resultSet.getString("phone_number"));
            customerInfo.setDestinationCountry(resultSet.getString("destination_country"));
            logger.info("email id " + resultSet.getString("email_id")
            + " fullname " + resultSet.getString("fullname")
            + " phone number " + resultSet.getString("phone_number")
            + " destination country " + resultSet.getString("destination_country"));
            customerInfoList.add(customerInfo);
      }

    } catch (SQLException e) {
      logger.throwing("FetchAllCustomersPrimaryInfo", "fetchCustomerInfo", e);
    }
    return customerInfoList;
  }
}
