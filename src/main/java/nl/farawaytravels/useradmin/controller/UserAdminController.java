package nl.farawaytravels.useradmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lists Api's for User Admin
 *
 * @author Debidutt Prasad (C39392)
 */
@RestController
public class UserAdminController {

  /**
   * Authenticates User of fawt portal
   *
   * @param userName username of fawt employee
   * @param password password of fawt employee
   * @return true if the credentials are valid
   */
  @PostMapping(value = "user/auth")
  public boolean authenticateUser(String userName, String password) {
    if (userName.equals("fawt")) {
      if (password.equals("Lets@2020")) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

}
