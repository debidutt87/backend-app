package nl.farawaytravels.useradmin.controller;

import nl.farawaytravels.useradmin.dto.AuthUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lists Api's for User Admin
 *
 * @author DP
 */
@RestController
public class UserAdminController {

  @RequestMapping("/")
  public String healthCheck(){
    return "OK";
  }

  /**
   * Authenticates User of fawt portal
   *
   * @param userName username of fawt employee
   * @param password password of fawt employee
   * @return true if the credentials are valid
   */
  @PostMapping(value = "user/auth")
  public AuthUser authenticateUser(String userName, String password) {
    AuthUser authUser = new AuthUser();
    if (userName.equals("fawt")) {
      if (password.equals("Lets@2020")) {
        authUser.setAuthenticated(true);
      } else {
        authUser.setAuthenticated(false);
      }
    } else {
      authUser.setAuthenticated(false);
    }
    return authUser;
  }

}
