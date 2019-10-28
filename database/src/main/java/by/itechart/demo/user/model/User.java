package by.itechart.demo.user.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "id"))
    private List<Role> role;

}
