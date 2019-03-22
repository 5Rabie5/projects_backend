package at.nacs.drhouseadmission.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Patient {

    private String id;
    private String name;
    private String symptoms;
}
