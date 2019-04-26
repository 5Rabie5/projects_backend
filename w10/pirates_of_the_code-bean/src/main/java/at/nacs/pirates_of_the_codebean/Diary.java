package at.nacs.pirates_of_the_codebean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component

public class Diary {
  @Setter
  @Getter
  boolean decipher;
}
