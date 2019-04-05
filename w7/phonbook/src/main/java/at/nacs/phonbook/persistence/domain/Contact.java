package at.nacs.phonbook.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

   // @JoinColumn(name = "performancelog_id")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Address address;


}
