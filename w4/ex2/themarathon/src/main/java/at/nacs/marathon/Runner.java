package at.nacs.marathon;

import lombok.Data;


import java.time.Duration;

@Data
public class Runner {
    private String name;
    private Duration time;
}
