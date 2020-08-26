package nl.farawaytravels.useradmin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer Info DTO Class
 *
 * @author Debidutt Prasad (C39392)
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo implements Serializable {

  private static final long serialVersionUID = 4543784676239221567L;

  public String emailId;
  public String fullName;
  public String phoneNumber;
  public String destinationCountry;
}
