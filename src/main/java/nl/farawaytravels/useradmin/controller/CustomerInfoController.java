package nl.farawaytravels.useradmin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;
import nl.farawaytravels.useradmin.dto.CustomerInfo;
import nl.farawaytravels.useradmin.usecase.FetchAllCustomersPrimaryInfo;
import nl.farawaytravels.useradmin.usecase.RegisterCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * List all api's related to Customer Info
 *
 * @author DP
 */
@RestController
public class CustomerInfoController {

  private static Logger logger = Logger.getLogger("CustomerInfoController");

  @GetMapping(value = "/customerInfo/getAll")
  public String getCustomersInfo() {

    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ObjectMapper mapper = new ObjectMapper();
    try {
      mapper
          .writeValue(out, new FetchAllCustomersPrimaryInfo().fetchCustomerInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }

    final byte[] data = out.toByteArray();
    return new String(data);
  }

  @PostMapping(value = "/register")
  public ResponseEntity<Void> registerCustomer(@RequestBody CustomerInfo fetchCustomerInfo)
      throws JsonProcessingException {
    logger.info("customer details "+fetchCustomerInfo);
    new RegisterCustomer().registerCustomer(fetchCustomerInfo);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
