package nl.farawaytravels.useradmin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Wraps CustomerInfo object
 *
 * @author DP
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomersWrapper implements Serializable {

  private static final long serialVersionUID = 2228636633769359184L;

  private List<CustomerInfo> customers;
}
