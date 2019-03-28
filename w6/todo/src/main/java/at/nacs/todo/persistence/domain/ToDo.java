package at.nacs.todo.persistence.domain;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDo {

    private String id;
    private String title;
    private boolean done;
}
