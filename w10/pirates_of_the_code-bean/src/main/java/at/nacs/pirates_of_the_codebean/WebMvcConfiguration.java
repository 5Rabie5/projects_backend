package at.nacs.pirates_of_the_codebean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/diary").setViewName("diary");
    registry.addViewController("/").setViewName("home");
   // registry.addViewController("/login");
  }

}
