package at.nacs.thecodiattissecretorder.view.controller;

import at.nacs.thecodiattissecretorder.logic.Maneger;
import at.nacs.thecodiattissecretorder.persistence.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final Maneger maneger;


    @GetMapping
    String page() {
        return "home";
    }


    @RolesAllowed("ROLE_ADMIN")
    @PostMapping
    String save(@RequestBody String name, @RequestBody String password) {
        User user = maneger.createUser(name, password);
        maneger.save(user);
      //  return "redirect:/home";
      return "redirect:/";
    }

    @ModelAttribute("users")
    List<User> participants() {
        return maneger.getAll();
    }


}
