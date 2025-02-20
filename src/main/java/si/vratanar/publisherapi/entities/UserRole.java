package si.vratanar.publisherapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq", sequenceName = "user_role_sequence", allocationSize = 1)
    private Long userRoleId;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(length = 30)
    private String role;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "news_user_user_role", joinColumns = @JoinColumn(name = "user_role_id"),
            inverseJoinColumns = @JoinColumn(name = "news_user_id"))
    private Set<NewsUser> users = new HashSet<>();
}
