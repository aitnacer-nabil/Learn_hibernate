package edu.mum.cs.domain.onetoone;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity()
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String lastName;
   @OneToOne
    private  Address address;
    public User() {

    }
}
