package nl.farawaytravels.useradmin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * AuthUser DTO Class
 *
 * @author Debidutt Prasad (C39392)
 */
@Getter
@Setter
@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class AuthUser implements Serializable {

  private boolean isAuthenticated;
}
