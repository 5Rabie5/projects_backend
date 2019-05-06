package at.nacs.thecodiattissecretorder.view.advice;


import at.nacs.thecodiattissecretorder.persistence.model.User;
import at.nacs.thecodiattissecretorder.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "at.nacs.thecodiattissecretorder.view")
public class UserControllerAdvice {

  @ModelAttribute("user")
  User user(@AuthenticationPrincipal UserPrincipal principal) {
    if (isNotLoggedIn(principal)) {
      return null;
    }
    return principal.getUser();
  }

  private boolean isNotLoggedIn(UserPrincipal principal) {
    return principal == null;
  }
}
