package nl.farawaytravels.useradmin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class CORSFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // Not used
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.setHeader("Access-Control-Allow-Origin", "*");
    filterChain.doFilter(servletRequest, response);
  }

  @Override
  public void destroy() {
    // Not used
  }
}
